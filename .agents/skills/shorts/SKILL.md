---
name: shorts
description: "High-density, low-fluff conceptual breakdown of any engineering topic. Triggered by '/shorts <topic>'. Provides an analogy, production impact, and under-the-hood operational breakdown."
---

# `/shorts <topic>` — Conceptual Density Shot

## Purpose
Deliver a rapid, high-signal conceptual breakdown of the given `<topic>`. No filler, no preamble. Every sentence must teach something actionable.

## Output Structure

You MUST structure your response using exactly these three sections:

### 1. 🔗 Analogy
- Provide a simple, real-world comparison that explains *what* the topic is.
- The analogy must be intuitive to a non-engineer but technically accurate enough that it maps directly to the underlying system behavior.
- Keep it to 2-3 sentences maximum.

### 2. 💥 Production Impact
- 1-2 sentences on **why a business or application breaks** without this concept being properly implemented.
- Be specific. Reference real failure modes: data corruption, memory leaks, cascading failures, security breaches, user-facing latency spikes, etc.
- Do NOT be vague. Bad: "Things might slow down." Good: "Without connection pooling, each request opens a raw TCP socket to the database, exhausting file descriptors under load and causing `java.net.SocketException: Too many open files` across all pods."

### 3. ⚙️ Under the Hood
- A bulleted, low-level operational breakdown of how the topic **actually executes** in memory, on the JVM, over the network, or inside the framework.
- Target 4-8 bullets depending on complexity.
- Reference specific classes, protocols, data structures, or algorithms where applicable.
- For Java/Spring topics: include JVM internals, bytecode behavior, or Spring container lifecycle details.
- For Frontend topics: include browser rendering pipeline, event loop, or DOM reconciliation details.
- For DevOps topics: include kernel-level, network-level, or container runtime details.

## Depth Calibration
- **Core Java / Spring Boot:** Go deep immediately. Assume intermediate-to-advanced knowledge. Reference internal APIs, JVM flags, class hierarchies.
- **Frontend / Microservices / DevOps:** Start at baseline fundamentals but build up to production-relevant depth within the same response.

## Post-Execution
After delivering the response, update `learning_tracker.md` at the workspace root:
- Add a session log entry with today's date, the topic, domain, and competency stage `Exposure`.
- If the topic has been covered before, escalate the competency stage if the user is revisiting it.
