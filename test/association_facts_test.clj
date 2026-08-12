(ns association-facts-test
  (:require [clojure.java.io :as io] [clojure.java.shell :as shell]
            [clojure.test :refer [deftest is testing]]
            [kotoba.compiler.core :as compiler] [kotoba.kir :as ir]))
(def source (slurp "src/association_facts.kotoba"))
(defn call [kir f & xs] (ir/execute kir f (vec xs)))
(defn present [x] (when (second x) (nth x 2)))
(def fields ["id" "title" "association" "isic" "country" "kind" "url" "url-provenance"
             "established-date" "last-revised-date" "retrieved-at"])
(def expected
  [{"id" "ubf.founding-1982" "title" "UBF founding (homepage)" "association" "ubf"
    "isic" "6419" "country" "ARE" "kind" "governance-program" "url" "https://www.ubf.ae/"
    "url-provenance" "official-ubf-ae" "established-date" "1982" "last-revised-date" nil
    "retrieved-at" "2026-07-16"}
   {"id" "ubf.tasharuk-platform-2017"
    "title" "TASHARUK cyber threat intelligence sharing platform (Initiatives)"
    "association" "ubf" "isic" "6419" "country" "ARE" "kind" "governance-program"
    "url" "https://ubf.ae/en/activities/initiatives/initiatives-details/3"
    "url-provenance" "official-ubf-ae" "established-date" "2017" "last-revised-date" nil
    "retrieved-at" "2026-07-16"}])
(deftest reference-preserves-authority
  (let [kir (:kir (compiler/compile-source source :js-kotoba-v1))
        observed (mapv (fn [i] (into {} (map (fn [f] [f (present (call kir 'entry-field "ubf" i f))]) fields))) [0 1])]
    (is (= expected observed))
    (is (= ["1982" "2017"] (mapv #(present (call kir 'entry-field "ubf" % "established-date")) [0 1])))
    (is (= ["governance" "technology-standards"] (mapv #(present (call kir 'topic "ubf" % 0)) [0 1])))
    (is (= "ubf.tasharuk-platform-2017" (present (call kir 'by-topic-id "ubf" "technology-standards" 0))))
    (is (= #{} (set (:effects kir))))
    (testing "fail closed"
      (is (zero? (call kir 'entry-count "uaebf")))
      (is (nil? (present (call kir 'entry-field "ubf" 2 "id"))))
      (is (nil? (present (call kir 'entry-field "ubf" 0 "last-revised-date"))))
      (is (nil? (present (call kir 'topic "ubf" 0 1))))
      (is (zero? (call kir 'by-topic-count "ubf" "cybersecurity")))
      (is (nil? (present (call kir 'by-topic-id "ubf" "governance" 1)))))))
(defn compiler-root [] (nth (iterate #(.getParent ^java.nio.file.Path %)
  (java.nio.file.Path/of (.toURI (io/resource "kotoba/compiler/core.clj")))) 4))
(defn base64 [x] (.encodeToString (java.util.Base64/getEncoder) x))
(deftest restricted-js-and-wasm-conform-semantically
  (let [js (compiler/compile-source source :js-kotoba-v1) wasm (compiler/compile-source source :wasm32-browser-kotoba-v1)
        js64 (base64 (.getBytes ^String (:source js) "UTF-8")) wasm64 (base64 ^bytes (:bytes wasm))
        p (shell/sh "node" "--input-type=module" "-e"
            (str "import(process.argv[1]).then(async h=>{const j=await import('data:text/javascript;base64," js64 "');const w=await h.instantiateKotoba(Buffer.from(process.argv[2],'base64'));const r=x=>{if(x['entry-field']('ubf',0n,'established-date')[2]!=='1982'||x['entry-field']('ubf',1n,'established-date')[2]!=='2017'||x['entry-field']('ubf',0n,'last-revised-date')[1]!==false)throw Error('dates');if(x['by-topic-id']('ubf','technology-standards',0n)[2]!=='ubf.tasharuk-platform-2017'||x['entry-count']('uaebf')!==0n)throw Error('authority');};r(j.instantiateKotoba({}));r(w.instance.exports)}).catch(e=>{console.error(e);process.exit(99)})")
            (.toString (.toUri (.resolve (compiler-root) "runtime/browser-host.mjs"))) wasm64)]
    (is (zero? (:exit p)) (str (:out p) (:err p)))))
(deftest production-source-authority
  (is (= ["src/association_facts.kotoba"] (->> (file-seq (io/file "src")) (filter #(.isFile %)) (map str) sort vec))))
