(ns clj-metrics.core-test
  (:require [clojure.test :refer :all]
            [clj-metrics.core :refer :all]))

(deftest a-test
  (testing "Format name."
    (is (= "foo.bar.baz" (format-name ["foo" "bar" "baz"])))
    (is (= "foo" (format-name "foo")))))
