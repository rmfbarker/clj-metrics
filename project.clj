(defproject clj-metrics "0.1.2"
  :description "Coda Hale metrics for Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.codahale.metrics/metrics-core "3.0.1"]]
  :main ^:skip-aot clj-metrics.core
  :target-path "target/%s"

  :profiles {:uberjar {:aot :all}})
