(defproject cryogen "0.1.3"
            :description "Simple static site generator"
            :url "https://github.com/lacarmen/cryogen"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.10.0"]
                           [ring/ring-devel "1.5.1"]
                           [compojure "1.5.2"]
                           [ring-server "0.4.0"]
                           [selmer "1.10.6"]
                           [clj-text-decoration "0.0.3"]
                           [io.aviso/pretty "0.1.33"]
                           [cryogen-markdown "0.1.13"]
                           [cryogen-core "0.3.2"]]
            :plugins [[lein-ring "0.12.5"]]
            :main cryogen.core
            :ring {:init cryogen.server/init
                   :handler cryogen.server/handler}
            :aliases {"serve"      ["run" "-m" "cryogen.server"]
                      "serve-fast" ["run" "-m" "cryogen.server" "fast"]})
