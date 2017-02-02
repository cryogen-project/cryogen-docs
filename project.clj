(defproject cryogen "0.1.0"
            :description "Simple static site generator"
            :url "https://github.com/lacarmen/cryogen"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [ring/ring-devel "1.5.1"]
                           [compojure "1.5.2"]
                           [ring-server "0.4.0"]
                           [selmer "1.10.6"]
                           [clj-text-decoration "0.0.3"]
                           [io.aviso/pretty "0.1.33"]
                           [cryogen-markdown "0.1.5"]
                           [cryogen-core "0.1.21"]]
            :plugins [[lein-ring "0.8.13"]]
            :main cryogen.compiler
            :ring {:init cryogen.server/init
                   :handler cryogen.server/handler})
