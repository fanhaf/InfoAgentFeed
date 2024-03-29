(defproject infoagent "0.1.0-SNAPSHOT"
  :description ""
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.4"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [enlive "1.0.1"]
                 [cheshire "5.0.1"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler infoagent.core/application}
)
