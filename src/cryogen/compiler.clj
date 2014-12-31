(ns cryogen.compiler
  (:require [selmer.parser :refer [cache-off! render-file]]
            [io.aviso.exception :refer [write-exception]]
            [text-decoration.core :refer :all]
            [clojure.java.io :refer [reader]]
            [cryogen-core.compiler :refer :all
             :exclude [parse-page read-pages compile-pages compile-assets compile-assets-timed -main]]
            [cryogen-core.io :refer [create-folder wipe-public-folder copy-resources copy-images-from-markdown-folders]]
            [cryogen-core.sitemap :as sitemap]
            [cryogen-core.rss :as rss]
            [cryogen-core.toc :refer [generate-toc]]))

(defn parse-page
  "Parses a page/post and returns a map of the content, uri, date etc."
  [is-post? page config]
  (with-open [rdr (java.io.PushbackReader. (reader page))]
    (let [page-name (.getName page)
          file-name (clojure.string/replace page-name #".md" ".html")
          page-meta (read-page-meta page-name rdr)
          content (parse-content rdr config)]
      (merge
        (update-in page-meta [:layout] #(str (name %) ".html"))
        {:file-name file-name
         :content   content
         :toc       (if (:toc page-meta) (generate-toc content))}
        (if is-post?
          (let [date (parse-post-date file-name (:post-date-format config))
                archive-fmt (java.text.SimpleDateFormat. "yyyy MMMM" (java.util.Locale. "en"))
                formatted-group (.format archive-fmt date)]
            {:date                    date
             :formatted-archive-group formatted-group
             :parsed-archive-group    (.parse archive-fmt formatted-group)
             :uri                     (post-uri file-name config)
             :tags                    (set (:tags page-meta))})
          {:uri        (page-uri file-name config)
           :page-index (:page-index page-meta)
           :section    (:section page-meta)})))))

(defn read-pages
  "Returns a sequence of maps representing the data from markdown files of pages.
   Sorts the sequence by post date."
  [config]
  (->> (find-pages config)
       (map #(parse-page false % config))
       (sort-by :page-index)))

(defn group-docs-by-section [pages]
  (->> pages
       (map #(select-keys % [:title :uri :page-index :section]))
       (group-by :section)
       (map (fn [[section pages]]
              {:section section
               :pages   (map #(select-keys % [:title :uri]) pages)}))))

(defn compile-pages
  "Compiles all the pages into html and spits them out into the public folder"
  [default-params pages {:keys [blog-prefix page-root]}]
  (when-not (empty? pages)
    (println (blue "compiling pages"))
    (create-folder (str blog-prefix page-root))
    (doseq [{:keys [uri] :as page} pages]
      (println "\t-->" (cyan uri))
      (spit (str public uri)
            (render-file "templates/html/layouts/page.html"
                         (merge default-params
                                {:servlet-context "../"
                                 :page            page
                                 :sections        (group-docs-by-section pages)}))))))

(defn compile-assets
  "Generates all the html and copies over resources specified in the config"
  []
  (println (green "compiling assets..."))
  (let [{:keys [site-url blog-prefix rss-name recent-posts keep-files ignored-files] :as config} (read-config)
        posts (add-prev-next (read-posts config))
        pages (add-prev-next (read-pages config))
        [navbar-pages sidebar-pages] (group-pages pages)
        posts-by-tag (group-by-tags posts)
        posts (tag-posts posts config)
        default-params {:title         (:site-title config)
                        :tags          (map (partial tag-info config) (keys posts-by-tag))
                        :latest-posts  (->> posts (take recent-posts) vec)
                        :navbar-pages  navbar-pages
                        :sidebar-pages sidebar-pages
                        :archives-uri  (str blog-prefix "/archives.html")
                        :index-uri     (str blog-prefix "/index.html")
                        :rss-uri       (str blog-prefix "/" rss-name)}]

    (wipe-public-folder keep-files)
    (println (blue "copying resources"))
    (copy-resources config)
    (copy-images-from-markdown-folders config)
    (compile-pages default-params pages config)
    (compile-posts default-params posts config)
    (compile-tags default-params posts-by-tag config)
    (compile-index default-params config)
    (compile-archives default-params posts config)
    (println (blue "generating site map"))
    (spit (str public blog-prefix "/sitemap.xml") (sitemap/generate site-url ignored-files))
    (println (blue "generating rss"))
    (spit (str public blog-prefix "/" rss-name) (rss/make-channel config posts))))

(defn compile-assets-timed []
  (time
    (try
      (compile-assets)
      (catch Exception e
        (if
          (or (instance? IllegalArgumentException e)
              (instance? clojure.lang.ExceptionInfo e))
          (println (red "Error:") (yellow (.getMessage e)))
          (write-exception e))))))

