(ns clj-metrics.core
  (:import (com.codahale.metrics MetricRegistry Counter Meter Histogram Timer ConsoleReporter ConsoleReporter$Builder)
           (java.util.concurrent Callable TimeUnit))
  (:gen-class))

(defn format-name [name]
  (if (vector? name)
    (apply str (interpose \. name))
    name))

(def registry (MetricRegistry.))

(defn counter [name]
  (.counter registry (format-name name)))

(defn inc! [counter]
  (.inc counter))

(defn dec! [counter]
  (.dec counter))

(defn histogram [name]
  (.histogram registry (format-name name)))

(defn update! [histogram]
  (.update histogram))

(defn meter [name]
  (.meter registry (format-name name)))

(defn mark! [meter]
  (.mark meter))

(defn timer [name]
  (.timer registry (format-name name)))

(defmacro time! [^Timer t & body]
  `(.time ~(vary-meta t assoc :tag `Timer)
          (proxy [Callable] []
            (call [] (do ~@body)))))

(defn report-to-console []
  (future (-> (ConsoleReporter/forRegistry registry)
              (.convertRatesTo TimeUnit/SECONDS)
              (.convertDurationsTo TimeUnit/MILLISECONDS)
              (.build)
              (.start 1 TimeUnit/MINUTES))))

