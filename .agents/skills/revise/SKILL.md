---
name: revise
description: "Active Recall evaluation — asks deep conceptual questions about a topic, waits for the user to answer, scores their response with granular feedback, and logs revision timestamps. Triggered by '/revise <topic>'."
---

# `/revise <topic>` — Active Recall Engine

## Purpose
Trigger an active recall evaluation block for the given `<topic>`. This is NOT a teaching session — it is an assessment of retained knowledge. The user must retrieve information from memory without hints.

## Execution Flow

### Phase 1: Question Delivery
- Ask exactly **TWO** deep, conceptual questions about the topic.
- Questions must be **open-ended** — no multiple choice, no true/false, no fill-in-the-blank.
- Questions should test **understanding**, not memorization:
  - ❌ Bad: "What annotation starts a Spring Boot app?" (trivia)
  - ✅ Good: "Explain the sequence of events that occurs inside the Spring container between the moment `@SpringBootApplication` is processed and the moment your first `@RestController` is ready to serve traffic. What role does `@EnableAutoConfiguration` play in this sequence?"
  - ✅ Good: "If you have a `@Transactional` method that calls another `@Transactional` method within the same class, what happens to the transaction boundary and why? What Spring mechanism causes this behavior?"

### Question Depth Calibration
- **Core Java:** JVM internals, memory model, concurrency primitives, garbage collection generations, classloading, reflection mechanics, generics type erasure.
- **Spring Boot:** Proxy generation, bean lifecycle, auto-configuration resolution, transaction propagation, AOP pointcut weaving, security filter chain ordering.
- **Frontend:** Event loop mechanics, virtual DOM reconciliation, closure behavior, prototype chain, CSP policies, hydration strategies.
- **Microservices:** Circuit breaker state machines, saga compensation, service mesh data planes, distributed tracing propagation, consensus algorithms.
- **DevOps:** Container layer caching, iptables/nftables routing, OCI runtime specs, Kubernetes scheduler scoring, etcd consistency guarantees.

### Phase 2: Wait for Response
- **STOP after asking the questions.** Do NOT provide answers, hints, or any additional context.
- Do NOT continue until the user provides their answer.
- If the user asks for a hint, provide ONE minimal nudge (a single keyword or concept name) and note in the log that a hint was used.

### Phase 3: Scoring & Feedback (after user responds)
- Score each answer on a scale of **1-10** using this rubric:
  - **9-10:** Production-grade understanding. Could explain this in a system design interview.
  - **7-8:** Solid conceptual grasp with minor gaps. Knows the "what" and most of the "why."
  - **5-6:** Surface-level understanding. Knows the concept exists but can't explain the mechanics.
  - **3-4:** Fragmented knowledge. Mixed up with adjacent concepts or missing key details.
  - **1-2:** Incorrect or no meaningful answer provided.

- For each answer, provide:
  1. **Score: X/10**
  2. **What was correct:** Acknowledge the parts they got right.
  3. **What was missing:** Specifically name the concepts, mechanisms, or details they omitted.
  4. **The complete answer:** Provide the full, production-grade explanation they should have given.
  5. **Memory anchor:** A one-sentence mnemonic or mental model to help retain the concept.

### Phase 4: Tracker Update
After scoring, update `learning_tracker.md` at the workspace root:
- Add a session log entry with today's date, the topic, domain, scores, and updated competency stage.
- Update the competency stage based on score:
  - Average 9-10 → `Production Mastery`
  - Average 7-8 → `Independent Application`
  - Average 5-6 → `Guided Practice`
  - Average 1-4 → `Exposure` (needs re-teaching)
- If the score is below 7, add the topic to the **Revision Queue** with `High` priority.
