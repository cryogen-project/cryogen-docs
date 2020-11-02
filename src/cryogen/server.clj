(ns cryogen.server
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]
            [cryogen-core.watcher :refer [start-watcher!]]
            [cryogen-core.plugins :refer [load-plugins]]
            [cryogen-core.config :as config]
            [cryogen.compiler :refer [compile-assets-timed]]))

(defn init []
  (load-plugins)
  (compile-assets-timed)
  (let [ignored-files (-> (config/resolve-config) :ignored-files)]
    (start-watcher! "content" ignored-files compile-assets-timed)
    (start-watcher! "themes" ignored-files compile-assets-timed)))

(defroutes handler
           (GET "/" [] (redirect (str (:blog-prefix (config/resolve-config)) "/index.html")))
           (route/resources "/")
           (route/not-found "Page not found"))
