(defproject cryogen "0.1.0"
            :description "Simple static site generator"
            :url "https://github.com/lacarmen/cryogen"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [markdown-clj "0.9.66"
                            :exclusions [com.keminglabs/cljx]]
                           [ring/ring-devel "1.3.2"]
                           [compojure "1.3.4"]
                           [ring-server "0.4.0"]
                           [selmer "0.8.2"]
                           [clj-text-decoration "0.0.3"]
                           [io.aviso/pretty "0.1.18"]
                           [cryogen-markdown "0.1.1"]
                           [cryogen-core "0.1.21"]]
            :plugins [[lein-ring "0.8.13"]]
            :main cryogen.compiler
            :ring {:init cryogen.server/init
                   :handler cryogen.server/handler})
