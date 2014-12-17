(ns cryogen.server
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]
            [cryogen-core.watcher :refer [start-watcher!]]
            [cryogen-core.compiler :refer [read-config]]
            [cryogen.compiler :refer [compile-assets-timed]]))

(defn init []
  (compile-assets-timed)
  (start-watcher! "resources/templates" compile-assets-timed))

(defroutes handler
  (GET "/" [] (redirect (str (:blog-prefix (read-config)) "/index.html")))
  (route/resources "/")
  (route/not-found "Page not found"))
