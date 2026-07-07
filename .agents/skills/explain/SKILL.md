---
name: explain
description: "Comprehensive deep dive into any engineering topic. For Java/Spring Boot, dives straight into advanced internals. For other fields, builds from fundamentals upward. Triggered by '/explain <topic>'."
---

# `/explain <topic>` — Deep Dive Engine

## Purpose
Provide a comprehensive, multi-layered deep dive into the given `<topic>`. This is the most thorough teaching mode — cover the topic from first principles to production edge cases.

## Depth Calibration

### For Core Java / Spring Boot Topics
**Skip the basics. Dive straight into advanced internals.**

The user is at an intermediate-to-advanced level. Do NOT explain what a class is or how to write a for loop. Instead:
- **Reflection API:** How `Method.invoke()` bypasses access checks via `setAccessible()`, the security manager implications, and how frameworks like Spring use `ReflectionUtils` internally.
- **Custom Annotations:** The full lifecycle from `@Retention` policies through annotation processor compilation to runtime reflection discovery. How Spring's `AnnotationUtils.findAnnotation()` traverses the meta-annotation hierarchy.
- **Transaction Propagation:** All 7 propagation types with concrete scenarios. How `TransactionSynchronizationManager` uses `ThreadLocal` to bind transactions. Why `REQUIRES_NEW` suspends the outer transaction's `EntityManager`.
- **Bytecode Generation:** How Spring creates CGLIB proxies via `Enhancer`, the `MethodInterceptor` callback chain, and why `final` methods break AOP.
- **Memory Model:** `happens-before` relationships, volatile's memory fence semantics, why `DCL` (Double-Checked Locking) was broken pre-Java 5.

### For Frontend Topics
**Start at baseline fundamentals, build upward.**
- Begin with how the browser rendering pipeline works (DOM → CSSOM → Render Tree → Layout → Paint → Composite).
- Progress to framework concepts (component lifecycle, state management, virtual DOM).
- End with advanced topics (hydration strategies, code splitting, Web Workers, service workers).

### For Microservices Topics
**Start with the architectural pattern, build to implementation.**
- Begin with the distributed systems problem being solved.
- Progress to the standard pattern/solution (saga, CQRS, circuit breaker, service mesh).
- End with production configuration, failure modes, and observability.

### For DevOps Topics
**Start with the infrastructure concept, build to orchestration.**
- Begin with the OS-level primitive (cgroups, namespaces, iptables).
- Progress to the abstraction layer (Docker, Kubernetes, Terraform).
- End with production operations (monitoring, alerting, incident response, capacity planning).

## Output Structure

### 1. 🧠 Core Concept
- What the topic IS at its most fundamental level.
- 3-5 sentences. No analogies here — pure technical definition.

### 2. 🏗️ Architecture & Internal Mechanics
- How it works internally. Diagrams described textually or via ASCII art.
- Reference specific classes, interfaces, protocols, data structures.
- Show the execution flow (what calls what, in what order, on which thread).
- For Java: include relevant JVM flags, JMX beans, or diagnostic commands.
- For Spring: include the relevant `AutoConfiguration` class, bean definition registry behavior, and condition evaluation order.

### 3. 💻 Code Deep Dive
- Show annotated code examples that demonstrate the concept.
- For Java/Spring: show advanced usage, NOT hello-world examples.
- Include:
  - The standard/idiomatic usage
  - An advanced/edge-case usage
  - A common anti-pattern (what NOT to do, and what breaks)
- Code should be snippets focused on the concept, not full applications.

### 4. ⚡ Production Considerations
- Performance characteristics (time complexity, memory footprint, I/O patterns).
- Scaling behavior (what happens at 10x, 100x, 1000x load).
- Failure modes (what breaks and how to detect it).
- Configuration tuning (key properties/flags that matter in production).
- Monitoring (what metrics to watch, what alerts to set).

### 5. 🔗 Connected Concepts
- List 3-5 related topics with one-line explanations of how they connect.
- Example: "If you understood Transaction Propagation, next explore: **Connection Pool Management** (how transactions acquire/release connections), **Distributed Transactions** (what happens when one transaction spans two databases), **Saga Pattern** (the alternative to distributed transactions in microservices)."

### 6. 🧪 Test Your Understanding
- End with 1-2 thought-provoking questions the user can reflect on (but don't demand answers — this isn't `/revise`).
- These should connect the topic to real-world scenarios.

## Formatting Guidelines
- Use headers, bullet points, and code blocks liberally for scannability.
- Bold key terms on first usage.
- Use `inline code` for class names, method names, annotations, and configuration properties.
- Keep individual sections focused — breadth comes from having many sections, not from making each section sprawl.

## Post-Execution
After delivering the explanation, update `learning_tracker.md`:
- Log the session with date, topic, domain, and competency stage.
- For Java/Spring topics: set stage to `Guided Practice` (advanced content was delivered).
- For other topics: set stage to `Exposure` or `Guided Practice` depending on the depth covered.
