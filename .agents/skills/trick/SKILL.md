---
name: trick
description: "Adversarial knowledge trap — presents deceptively simple questions that expose hidden tradeoffs, memory/time pitfalls, subtle bugs, or common misconceptions. Designs questions that most developers answer confidently but WRONG. Triggered by '/trick <topic>' or '/trick' (random topic from learning.md)."
---

# `/trick <topic>` — Knowledge Trap Engine

## Purpose
Trick the user with a question that **looks easy but isn't**. The goal is to expose false confidence, shallow understanding, and memorized-but-not-understood concepts. If a developer can survive your traps, they genuinely know the topic.

## Execution Flow

### Phase 1: Topic Selection
- If the user provides a `<topic>`, use it.
- If the user types just `/trick` with no topic, read `learning.md` and pick a topic they've already covered (competency stage `Exposure` or `Guided Practice` in `learning_tracker.md`). These are the ripest targets — just enough knowledge to be dangerous.

### Phase 2: Craft the Trap

Design exactly **ONE** question that satisfies ALL of these criteria:

1. **Surface simplicity** — The question must *look* like something a mid-level developer would answer in 5 seconds.
2. **Hidden depth** — The obvious answer is **wrong or incomplete**. The real answer requires understanding internals, edge cases, or production behavior.
3. **Confidence bait** — Frame it so the user feels sure about their answer. The trap works best when they commit confidently before realizing the catch.

#### Trap Categories (rotate between these):

**🧠 The Misconception Trap**
Present a commonly believed "fact" and ask the user to confirm or apply it — but the fact is subtly wrong.
- Example: "You have a `HashMap` with 10,000 entries. You call `.values()` and iterate. What's the time complexity?" *(Most say O(n). Real answer: O(capacity), which could be much larger if load factor is low or initial capacity was set high. They iterate over the entire bucket array, not just the entries.)*

**⏱️ The Performance Trap**
Show two code approaches and ask which is faster — but the "obvious" fast one is actually slower due to hidden costs (autoboxing, cache misses, context switching, object allocation).
- Example: "Which is faster for summing 1M integers: `parallelStream().reduce()` or a simple `for` loop?" *(The for loop wins by 10-50x for this simple operation due to ForkJoinPool overhead, boxing, and thread coordination cost.)*

**💾 The Memory Trap**
Ask about memory usage where the intuitive answer is wrong because of object headers, padding, references, or hidden data structures.
- Example: "How much heap memory does an `ArrayList<Integer>` with 1000 elements use?" *(Not 4KB. Each `Integer` is an object: 16 bytes header + 4 bytes value + 4 bytes padding = ~24 bytes × 1000 = ~24KB for the Integer objects alone, plus the Object[] array of references, plus the ArrayList overhead itself. ~28KB+, not the 4KB most guess.)*

**🔥 The Production Trap**
Present a "working" code snippet and ask "will this work in production?" — it works in dev but breaks under load, concurrency, or specific edge cases.
- Example: "This Spring `@Service` has a `SimpleDateFormat` field used in a method. It works perfectly in your tests. Ship it?" *(SimpleDateFormat is NOT thread-safe. Under concurrent requests, it will produce corrupt dates or throw NumberFormatException. Tests pass because they're single-threaded.)*

**🔄 The Tradeoff Trap**
Present a design decision and ask the user to pick one option — but both options have non-obvious costs they must articulate.
- Example: "Your REST API gets 10K req/sec. You need caching. Redis or local Caffeine cache — which do you pick?" *(Neither is "correct" without context. Redis: network hop per request, serialization cost, but consistent across instances. Caffeine: zero network latency, but each pod has its own cache — stale data, wasted memory across N pods, cache stampede on cold start. The trap is thinking either one is obviously better.)*

**💀 The Silent Bug Trap**
Show code that compiles, runs, passes tests, but has a subtle bug that only manifests under specific conditions.
- Example: "This `equals()` method compares all fields. Is it correct?" *(Missing `hashCode()` override. It will work everywhere EXCEPT in `HashMap`/`HashSet`, where objects that are `.equals()` but have different hash codes end up in different buckets — creating phantom duplicates.)*

**🔐 The Security Trap**
Present code that looks secure but has a non-obvious vulnerability.
- Example: "This endpoint validates the JWT token's signature and expiration. Is it secure?" *(Missing `alg` validation — an attacker can set algorithm to `none` and bypass signature verification entirely. CVE-2015-9235.)*

### Phase 3: Present the Question

Format the trap as:

---

**🎯 Trick Question — [Topic Area]**

*[Present the scenario or code snippet]*

**Your call:** *[Ask the specific question — make it feel like a quick yes/no or A/B choice]*

---

**STOP here. Do NOT reveal the trap.** Wait for the user's response.

### Phase 4: Spring the Trap (after user responds)

After the user answers, deliver:

#### 1. 🪤 The Verdict
- **"Trapped!"** if they fell for it — explain WHY the obvious answer is wrong.
- **"Not today!"** if they caught it — acknowledge their depth and explain what most people miss.

#### 2. 🔬 The Real Answer
- The complete, nuanced, production-grade answer.
- Include the **exact mechanism** that makes the obvious answer wrong (JVM behavior, framework internals, protocol specs, etc.).
- Quantify where possible — actual memory numbers, benchmark results, latency impact.

#### 3. ⚖️ The Tradeoff Matrix
For every trap, provide a tradeoff table:

| Dimension | What Most Think | What Actually Happens |
|-----------|----------------|----------------------|
| Time Complexity | O(n) | O(capacity) — bucket array traversal |
| Memory Impact | 4KB | ~28KB — object headers + boxing |
| Production Risk | None | Thread-safety violation under load |
| Scale Behavior | Linear | Degrades non-linearly past threshold |

#### 4. 🧲 The Anchor
One memorable sentence they'll never forget:
- *"Every `Integer` in Java is a 24-byte object pretending to be a 4-byte number."*
- *"Parallel streams are a performance footgun for anything that fits in L1 cache."*
- *"`HashMap` iterates buckets, not entries. Empty buckets aren't free."*

#### 5. 🎯 Score
- **Caught it (8-10/10):** They identified the trap AND explained the mechanism.
- **Partial (5-7/10):** They sensed something was off but couldn't articulate the full reason.
- **Trapped (1-4/10):** They committed to the wrong answer confidently.

### Phase 5: Combo Trap (Optional Escalation)

If the user caught the first trap, immediately follow up with a **harder trap on the same topic** — a second-order consequence they might not have considered. This tests whether they truly understand or just knew that one specific gotcha.

Example flow:
1. User catches the `SimpleDateFormat` thread-safety trap → 
2. Follow-up: "OK, you switch to `DateTimeFormatter` which is thread-safe. But you're parsing user-supplied date strings with `DateTimeFormatter.ofPattern(userInput)`. Safe now?" *(No — `ofPattern` compiles the pattern each time, and user-supplied patterns can cause ReDoS-like CPU spikes with pathological inputs.)*

## Difficulty Calibration

- **Core Java / Spring Boot:** Use JVM-level traps — memory layout, proxy mechanics, classloader behavior, GC pauses.
- **Databases:** Use query plan traps — index selectivity, join ordering, lock escalation.
- **Messaging:** Use ordering/delivery guarantee traps — partition rebalance during processing, duplicate delivery.
- **DevOps:** Use container layer traps — build cache invalidation, PID 1 signal handling, DNS caching.

## Post-Execution
After scoring, update `learning_tracker.md`:
- Log the session with date, topic, trap type, whether they were caught, and score.
- If they were trapped (score < 7), add the specific concept to the **Revision Queue** with `High` priority.
- If they caught it (score ≥ 8), bump the topic's competency stage up one level.
- Track trick success rate across sessions — if they stop getting trapped, escalate to combo traps and cross-domain traps.
