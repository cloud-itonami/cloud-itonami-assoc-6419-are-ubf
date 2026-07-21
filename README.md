# cloud-itonami-assoc-6419-are-ubf

Industry rule/history catalog for the **UAE Banks Federation** (UBF)
— the FIFTH entry aligned to **ISIC 6419** (other monetary
intermediation / banking), alongside
[`-6419-jpn-zenginkyo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-jpn-zenginkyo)
(Japan),
[`-6419-deu-bankenverband`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-deu-bankenverband)
(Germany),
[`-6419-fra-fbf`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-fra-fbf)
(France), and
[`-6419-aus-aba`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-aus-aba)
(Australia). Continues this session's UAE research thread alongside
[`cloud-itonami-municipality-are-abu-dhabi`](https://github.com/cloud-itonami/cloud-itonami-municipality-are-abu-dhabi).

Alongside
[`cloud-itonami-assoc-6512-jpn-sonpo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-jpn-sonpo),
[`-6612-jpn-jsda`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-jpn-jsda),
[`-6612-usa-finra`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-usa-finra),
[`-6512-usa-naic`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-usa-naic),
[`-6920-jpn-jicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-jpn-jicpa),
[`-6920-usa-aicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-usa-aicpa),
[`-6511-jpn-seiho`](https://github.com/cloud-itonami/cloud-itonami-assoc-6511-jpn-seiho),
[`-6910-jpn-nichibenren`](https://github.com/cloud-itonami/cloud-itonami-assoc-6910-jpn-nichibenren),
[`-6810-jpn-recaj`](https://github.com/cloud-itonami/cloud-itonami-assoc-6810-jpn-recaj),
[`-6411-jpn-boj`](https://github.com/cloud-itonami/cloud-itonami-assoc-6411-jpn-boj),
[`-6120-usa-ctia`](https://github.com/cloud-itonami/cloud-itonami-assoc-6120-usa-ctia),
[`-5110-usa-a4a`](https://github.com/cloud-itonami/cloud-itonami-assoc-5110-usa-a4a),
[`-3510-usa-eei`](https://github.com/cloud-itonami/cloud-itonami-assoc-3510-usa-eei),
[`-2910-deu-vda`](https://github.com/cloud-itonami/cloud-itonami-assoc-2910-deu-vda),
[`-2910-gbr-smmt`](https://github.com/cloud-itonami/cloud-itonami-assoc-2910-gbr-smmt),
[`-5010-nor-rederiforbundet`](https://github.com/cloud-itonami/cloud-itonami-assoc-5010-nor-rederiforbundet),
[`-5510-usa-ahla`](https://github.com/cloud-itonami/cloud-itonami-assoc-5510-usa-ahla),
[`-2100-usa-phrma`](https://github.com/cloud-itonami/cloud-itonami-assoc-2100-usa-phrma),
[`-4719-usa-nrf`](https://github.com/cloud-itonami/cloud-itonami-assoc-4719-usa-nrf),
[`-4100-usa-agc`](https://github.com/cloud-itonami/cloud-itonami-assoc-4100-usa-agc),
[`-6020-usa-nab`](https://github.com/cloud-itonami/cloud-itonami-assoc-6020-usa-nab),
[`-3600-usa-awwa`](https://github.com/cloud-itonami/cloud-itonami-assoc-3600-usa-awwa),
[`-4923-usa-ata`](https://github.com/cloud-itonami/cloud-itonami-assoc-4923-usa-ata),
[`-5610-usa-nra`](https://github.com/cloud-itonami/cloud-itonami-assoc-5610-usa-nra),
[`-2011-usa-acc`](https://github.com/cloud-itonami/cloud-itonami-assoc-2011-usa-acc),
[`-8621-usa-ama`](https://github.com/cloud-itonami/cloud-itonami-assoc-8621-usa-ama),
[`-6201-usa-gtia`](https://github.com/cloud-itonami/cloud-itonami-assoc-6201-usa-gtia),
[`-0610-usa-api`](https://github.com/cloud-itonami/cloud-itonami-assoc-0610-usa-api),
and
[`-0150-usa-afbf`](https://github.com/cloud-itonami/cloud-itonami-assoc-0150-usa-afbf).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on UBF's behalf.

Coverage is reported honestly through the bounded `association-facts` ABI: an
association not admitted by `association-covered?` has **no spec-basis**, full
stop — never fabricate one.

## Data

- `src/association_facts.kotoba` — the sole production catalog source.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries directly WebFetch-verified against `ubf.ae` (NOT the
TLS-broken `uaebf.ae`): the homepage ("Established in 1982...") and
the TASHARUK initiatives page (UBF's cyber threat intelligence
sharing platform, launched 2017).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains UBF's; this repo stores only citation metadata
(id/title/url/dates), not full text.
