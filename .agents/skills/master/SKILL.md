---
name: master
description: "Comprehensive concept mastery engine — teaches any topic from first principles to production-grade understanding. Covers theory, internals, practical implementation, tradeoffs, optimization, and advanced guardrails/edge cases. Designed for deep learning, not surface exposure. Triggered by '/master <topic>'."
---

# `/master <topic>` — Concept Mastery Engine

## Purpose
Take ANY concept from absolute zero to production mastery in a single, structured deep session. This is not a quick overview (`/shorts`) or a code walkthrough (`/guide`). This is the full engineering education — theory, first principles, hands-on implementation, tradeoffs, optimization, and advanced production guardrails.

**Use when:** You want to TRULY understand something, not just use it.

## Execution Flow

### Phase 1: First Principles — "Why Does This Exist?"

#### 1.1 🌍 The World Before This Concept
- What problem existed before this technology/pattern/concept was created?
- How did engineers solve it before? What was painful?
- What specific failure or limitation forced its invention?

> Frame this as a story. The user should *feel* the pain that created this concept.

#### 1.2 🧬 The Core Mental Model
- The ONE fundamental idea behind this concept, explained in a single sentence.
- An analogy from the physical world that makes it click instantly.
- The formal definition (after the intuition is built, not before).

#### 1.3 🔬 How It Actually Works — Under the Hood
- Step-by-step internal mechanism. How does it work at the lowest relevant level?
- For data structures: memory layout, pointer mechanics, algorithm steps
- For frameworks: lifecycle, proxy generation, bean wiring, request flow
- For patterns: component interaction sequence, data flow, state transitions
- For AI/ML integrations: pipeline stages, prompt flow, model interaction, token economics

**Draw a diagram (Mermaid)** showing the internal flow.

---

### Phase 2: Theory & Classification

#### 2.1 📚 Formal Properties
- Time complexity (best, average, worst)
- Space complexity
- Key invariants or guarantees
- Mathematical foundations (if applicable)

#### 2.2 🗂️ Taxonomy — Where Does This Fit?
- Category (data structure, algorithm, pattern, framework, protocol, etc.)
- Related concepts (what it's similar to, what it's often confused with)
- Prerequisites (what you MUST understand first)
- Alternatives (what else solves the same problem, and when to pick each)

| Alternative | When to Use | When NOT to Use |
|-------------|-------------|-----------------|
| This concept | [scenarios] | [scenarios] |
| Alternative A | [scenarios] | [scenarios] |
| Alternative B | [scenarios] | [scenarios] |

---

### Phase 3: Hands-On Implementation

#### 3.1 🏗️ Build From Scratch (where applicable)
Guide the user to implement it themselves:

1. **Define the structure** — class/interface design, fields, constructor
2. **Core operations** — method signatures with detailed hints (NOT full code)
3. **Edge cases** — what inputs break naive implementations
4. **Test cases** — provide 5+ test scenarios covering happy path, edge cases, and failure modes

> ⚠️ **NO BLIND COPYING.** Provide structure, signatures, and behavioral hints. The user writes the implementation.

#### 3.2 🔌 Framework Integration (where applicable)
- How to use the production-ready version (Spring, Java standard library, etc.)
- Configuration: dependency, application.yml properties, annotations
- Correct usage patterns and anti-patterns
- Integration with NexCommerce: which service, which layer, why

**Provide:**
- Maven dependency block (exact)
- Configuration file snippets (exact)
- Method signatures for the user to implement (NOT full bodies)

---

### Phase 4: Tradeoff Analysis — "Every Choice Has a Cost"

#### 4.1 ⚖️ The Tradeoff Matrix

| Dimension | Benefit | Cost | When It Hurts |
|-----------|---------|------|---------------|
| Performance | [what you gain] | [what you pay] | [at what scale] |
| Memory | [what you gain] | [what you pay] | [at what scale] |
| Complexity | [what you gain] | [what you pay] | [team impact] |
| Reliability | [what you gain] | [what you pay] | [failure mode] |
| Scalability | [what you gain] | [what you pay] | [at what load] |

#### 4.2 🎯 Decision Framework
- "Use this when..." (3-5 concrete scenarios)
- "Do NOT use this when..." (3-5 concrete anti-scenarios)
- "The moment you regret using this is when..." (production horror stories)

---

### Phase 5: Optimization & Advanced Usage

#### 5.1 ⚡ Performance Optimization
- Common performance pitfalls and how to avoid them
- Benchmarking approach (what to measure, how to measure)
- Tuning parameters and their effects
- Memory optimization techniques
- Thread safety considerations

#### 5.2 🔒 Production Guardrails
- **Input validation:** What malformed/malicious inputs can break this?
- **Error handling:** What exceptions can occur and how to handle gracefully?
- **Timeout/circuit breaker:** When does this concept hang or degrade?
- **Monitoring:** What metrics should you track?
- **Security:** What attack vectors exist? (SQL injection, prompt injection, DoS, etc.)
- **Rate limiting:** Does this need throttling?

#### 5.3 🛡️ Advanced Guardrails (for AI/ML integrations)
When the topic involves AI (Spring AI, LLMs, embeddings, etc.), additionally cover:
- **Prompt injection protection** — how to sanitize user inputs
- **Output validation** — how to verify LLM responses before using them
- **Hallucination detection** — how to cross-validate AI outputs
- **Token budget management** — cost control, max tokens, model selection
- **Fallback strategies** — what happens when the AI service is down?
- **Content filtering** — how to block harmful/inappropriate outputs
- **Observability** — logging prompts, responses, latency, token usage
- **A/B testing** — how to compare model versions or prompt strategies
- **Caching** — semantic caching for repeated queries

---

### Phase 6: Production Context in NexCommerce

#### 6.1 🏢 Where This Lives
- Which NexCommerce microservice owns this?
- Which layer (controller, service, repository, infrastructure)?
- How it interacts with other services (sync/async, events, API calls)

#### 6.2 🔥 Production Scenarios
Present 2-3 realistic production scenarios:
1. **Happy path at scale** — how this behaves under normal production load
2. **Failure scenario** — what happens when this breaks? Cascading effects?
3. **Edge case** — the 1-in-10,000 case that catches junior developers off guard

#### 6.3 📊 Monitoring & Alerting
- What metrics to expose (custom Micrometer metrics)
- What alerts to set (threshold values)
- Dashboard panels to create

---

### Phase 7: Knowledge Lock-In

#### 7.1 ❓ Comprehension Check
Ask 3 progressively harder questions:
1. **Recall** — "What is the time complexity of X?"
2. **Application** — "Given this scenario, how would you apply X?"
3. **Analysis** — "What breaks if you use X in this production context?"

Wait for user response. Score each answer.

#### 7.2 🧲 The Anchor
One memorable sentence that captures the essence:
> *"[Concept] is essentially [vivid one-line summary]."*

#### 7.3 📖 Further Reading
- 2-3 resources for deeper study (official docs, blog posts, source code)
- Related `/master` topics to study next
- LeetCode problems if applicable (3-5, ordered by difficulty)

---

## Difficulty Calibration

| Domain | Depth |
|--------|-------|
| Core Java | JVM-level internals, bytecode, memory layout |
| Spring Boot | Proxy mechanics, context lifecycle, auto-configuration source |
| Spring AI | Full pipeline: prompt templates → model call → output parsing → guardrails |
| DSA | Custom implementation + complexity proof + production integration |
| System Design | Architecture diagrams + failure modes + scaling math |
| Databases | Query plan analysis + index internals + connection pool tuning |
| Messaging | Partition mechanics + exactly-once semantics + consumer group rebalancing |
| DevOps | Container layers + build cache + PID 1 signal handling |

## Session Duration Guide
- A `/master` session is expected to take **60-90 minutes** of focused work.
- The user should come away with **Guided Practice** competency level minimum.
- If they build the implementation successfully, they're at **Independent Application**.

## Post-Execution
Update `learning_tracker.md`:
- Log session: date, topic, domain, comprehension check scores
- Set competency stage based on Phase 7 scores:
  - 0-4/10 average → `Exposure`
  - 5-7/10 average → `Guided Practice`
  - 8-9/10 average → `Independent Application`
  - 10/10 average → `Production Mastery`
- Add any identified gaps to the Revision Queue
