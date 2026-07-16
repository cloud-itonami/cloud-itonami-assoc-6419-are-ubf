(ns association.facts
  "Industry rule/history catalog for the UAE Banks Federation (UBF) --
  a 34th industry-association-level source per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The FIFTH entry aligned
  to ISIC 6419 (other monetary intermediation / banking), alongside
  cloud-itonami-assoc-6419-jpn-zenginkyo (Japan), -6419-deu-bankenverband
  (Germany), -6419-fra-fbf (France), and -6419-aus-aba (Australia) --
  the same cross-country-same-ISIC pattern already used for ISIC 2910
  (VDA/SMMT). Continues this session's UAE research thread alongside
  cloud-itonami-municipality-are-abu-dhabi.

  Both entries directly WebFetch-verified against ubf.ae (the
  association's own official domain, NOT the TLS-broken uaebf.ae
  which threw an 'unable to verify the first certificate' error):
  the homepage states plainly 'Established in 1982, UAE Banks
  Federation (UBF) is the sole representative body of the member
  banks and financial institutions operating in the UAE'; the
  TASHARUK initiative page states 'UBF launched TASHARUK - the first
  Information Sharing and Analysis Center (ISAC) in the United Arab
  Emirates (UAE) in 2017', a cyber-threat-intelligence-sharing
  platform for member banks. Both dates year-only, matching the
  year-only-date discipline already used for several sibling
  association entries.

  No Wikidata Q-id was found for UBF specifically -- omitted rather
  than guessed.

  A rule not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "assoc-slug -> vector of self-regulatory rule entries."
  {"ubf"
   [{:association-rule/id "ubf.founding-1982"
     :association-rule/title "UBF founding (homepage)"
     :association-rule/association "ubf"
     :association-rule/isic "6419"
     :association-rule/country "ARE"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ubf.ae/"
     :association-rule/url-provenance :official-ubf-ae
     :association-rule/established-date "1982"
     :association-rule/retrieved-at "2026-07-16"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ubf.tasharuk-platform-2017"
     :association-rule/title "TASHARUK cyber threat intelligence sharing platform (Initiatives)"
     :association-rule/association "ubf"
     :association-rule/isic "6419"
     :association-rule/country "ARE"
     :association-rule/kind :governance-program
     :association-rule/url "https://ubf.ae/en/activities/initiatives/initiatives-details/3"
     :association-rule/url-provenance :official-ubf-ae
     :association-rule/established-date "2017"
     :association-rule/retrieved-at "2026-07-16"
     :association-rule/topic #{:technology-standards}}]})

(defn spec-basis [assoc-slug] (get catalog assoc-slug))

(defn coverage
  ([] (coverage (keys catalog)))
  ([slugs]
   (let [have (filter catalog slugs)
         missing (remove catalog slugs)]
     {:requested (count slugs)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-6419-are-ubf Wave 0 (ADR-2607141700): "
                 (count (get catalog "ubf")) " ubf entries seeded with an "
                 "official ubf.ae citation. Extend "
                 "`association.facts/catalog`, never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))
