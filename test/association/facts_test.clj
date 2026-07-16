(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest ubf-has-spec-basis
  (let [sb (facts/spec-basis "ubf")]
    (is (= 2 (count sb)))
    (is (every? #(= "6419" (:association-rule/isic %)) sb))
    (is (every? #(= "ARE" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "aba")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["ubf" "aba"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["aba"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= ["ubf.tasharuk-platform-2017"]
         (mapv :association-rule/id (facts/by-topic "ubf" :technology-standards))))
  (is (empty? (facts/by-topic "ubf" :labor)))
  (is (empty? (facts/by-topic "aba" :governance))))
