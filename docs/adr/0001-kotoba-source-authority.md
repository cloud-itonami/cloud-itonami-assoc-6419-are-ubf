# ADR 0001: Kotoba is the UBF catalog source authority

- Status: Accepted
- Date: 2026-07-21

`src/association_facts.kotoba` is the sole production source. It preserves the
year-only `1982` founding and `2017` TASHARUK launch without inventing finer
precision or revision dates. Unknown values and indexes fail closed; no effects
are declared. Conformance is semantic across reference, restricted JavaScript,
and instantiated typed WebAssembly; compiler-output byte identity is not a gate.
Clojure and the JVM are compiler/test hosts only.
