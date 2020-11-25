(ns cryogen.compiler
  (:require
    [cryogen-core.compiler :as core-compiler]))

(defn group-docs-by-section [pages]
  (->> pages
       (map #(select-keys % [:title :uri :page-index :section]))
       (group-by :section)
       (map (fn [[section pages]]
              {:section section
               :pages   (map #(select-keys % [:title :uri]) pages)}))))

(defn compile-assets-timed
  ([] (compile-assets-timed nil))
  ([changeset]
   (core-compiler/compile-assets-timed
     {:extend-params-fn
      (fn extend-params [params {:keys [pages]}]
        (assoc params :sections
                      (group-docs-by-section pages)))}
     #_changeset)))
