# 🎯 Learning Tracker — Full-Stack Engineering Mastery

> **Competency Stages:** `Exposure` → `Guided Practice` → `Independent Application` → `Production Mastery`
> **Program:** 72 Days | 12 Weeks | 3 Months | NexCommerce Mega-Project

---

## 📊 Progress Dashboard

| Domain | Current Level | Topics Covered | Last Active |
|--------|--------------|----------------|-------------|
| Core Java | Intermediate | 2 | 2026-07-02 |
| DSA | Beginner | 2 | 2026-07-06 |
| Spring Boot | Beginner | 1 | 2026-07-16 |
| Spring Data | Beginner | 0 | — |
| Spring Security | Beginner | 0 | — |
| Spring Cloud | Beginner | 0 | — |
| Spring AI | Beginner | 1 | 2026-07-06 |
| System Design | Beginner | 0 | — |
| Databases | Beginner | 0 | — |
| Messaging (Kafka/RabbitMQ) | Beginner | 0 | — |
| Microservices | Beginner | 0 | — |
| DevOps (Podman/Helm) | Beginner | 0 | — |
| Observability | Beginner | 0 | — |

---

## 🗓️ Sprint Progress

| Week | Phase | Status | Days Completed | Theme |
|------|-------|--------|---------------|-------|
| 1 | Foundation | 🟡 In Progress | 2/6 | Complexity + Arrays + Strings + Spring Setup |
| 2 | Foundation | Not Started | 0/6 | LinkedList + Stack + Queue + Spring MVC |
| 3 | Foundation | Not Started | 0/6 | HashMap + Trees + Spring Data JPA |
| 4 | Foundation | Not Started | 0/6 | Heaps + Sorting + Spring Data MongoDB |
| 5 | Scale | Not Started | 0/6 | Binary Search + Recursion + Spring Security |
| 6 | Scale | Not Started | 0/6 | Graphs + Kafka |
| 7 | Scale | Not Started | 0/6 | Dynamic Programming + Microservices |
| 8 | Scale | Not Started | 0/6 | Two Pointers + Sliding Window + API Gateway |
| 9 | Production | Not Started | 0/6 | Trie + Advanced Trees + Resilience |
| 10 | Production | Not Started | 0/6 | Advanced Graphs + Observability |
| 11 | Production | Not Started | 0/6 | String Algos + LRU Cache + Containerization |
| 12 | Production | Not Started | 0/6 | System Design + Production Hardening + Capstone |

---

## 📅 Daily Progress

| Day | Date | Topic | Status | Key Concepts | Gaps | Score |
|-----|------|-------|--------|--------------|------|-------|
| 1 | 2026-07-05 | Time & Space Complexity | Complete | Asymptotic Bounds, Space vs Time Tradeoffs, Heap vs Stack memory | Logarithmic division loops, Recursion space limits | 6/10 |
| 2 | 2026-07-06 | Arrays Fundamentals | Complete | Contiguous layout, dynamic resizing logic, index-based insertion/shifting | Index shifting bounds, capacity 0/1 guards, varargs primitive binding | 5/10 |

**Last Completed Day:** 2
**Current Day:** 3
**Total Progress:** 2/72 (2.7%)

---

## 📝 Session Log

### 2026-07-02 — `/trick` — Java Data Types (Integer Caching)
- **Domain:** Core Java
- **Competency Stage:** Exposure
- **Trap Type:** 🧠 Misconception Trap
- **Key Concepts:** `==` vs `.equals()` on wrapper types, `Integer.valueOf()` autoboxing, `IntegerCache` (-128 to 127)
- **Gaps Identified:** Knew `==` compares references but missed the JVM Integer cache. Did not know autoboxing uses `valueOf()` not `new`. Unaware that `Byte`, `Short`, `Long`, `Character` also cache.
- **Score:** 4/10 (Trapped)

### 2026-07-02 — `/trick` — Java Operators (String Concatenation + Associativity)
- **Domain:** Core Java
- **Competency Stage:** Exposure
- **Trap Type:** 🧠 Misconception Trap
- **Key Concepts:** `+` operator left-associativity, string concatenation vs integer addition, evaluation order
- **Gaps Identified:** Correctly evaluated `1 + 2 + "3"` as `"33"` but incorrectly evaluated `"1" + 2 + 3` as `"15"` (right-to-left). Missed that left-associativity means `"1" + 2` resolves to `"12"` before `+ 3` is considered.
- **Score:** 5/10 (Half-Trapped)

### 2026-07-05 — `/master` — Big O Notation & Complexity Analysis
- **Domain:** DSA
- **Competency Stage:** Guided Practice
- **Trap Type:** N/A (Theoretical Mastery deep-dive)
- **Key Concepts:** Asymptotic bounds, division-based logarithmic scaling, loop analysis patterns, recursion tree complexity, memory stack limits (`StackOverflowError`) vs heap limits (`OutOfMemoryError`)
- **Gaps Identified:** Missed that division loops scale logarithmically (Pattern A). Missed loop-nesting multiplication rules (Pattern B) and divide-and-conquer recurrence relations (Pattern C). Confused StackOverflowError naming conventions.
- **Score:** 6/10

### 2026-07-06 — `/master` — Amortized Complexity
- **Domain:** DSA
- **Competency Stage:** Guided Practice
- **Trap Type:** N/A (Theoretical Mastery deep-dive)
- **Key Concepts:** Dynamic resizing arrays, Two-stack queues, Banker's Method (charges and credits), Physicist's Method, HashMap load factor threshold, memory cache locality
- **Gaps Identified:** Missed latency variance in real-time systems under amortized guarantees. Misidentified HashMap as a low-latency alternative for sub-10µs environments (missed cache line / pointer chasing penalties).
- **Score:** 5/10

### 2026-07-06 — `/trick` — Arrays (Primitive Varargs Generic Bindings)
- **Domain:** Core Java
- **Competency Stage:** Exposure
- **Trap Type:** 🧠 Misconception Trap
- **Key Concepts:** Primitive arrays vs Object arrays in Generics, `Arrays.asList(T...)` binding rules, varargs behavior
- **Gaps Identified:** Expected `Arrays.asList(int[])` to bind to `Integer` (size 3), but it bound the entire primitive array as a single element of type `int[]` (size 1) because Generics do not support primitives.
- **Score:** 2/10 (Trapped)

### 2026-07-06 — `/master` — Spring AI: PromptTemplate and Role
- **Domain:** Spring AI
- **Competency Stage:** Guided Practice
- **Trap Type:** N/A (Theoretical Mastery deep-dive)
- **Key Concepts:** PromptTemplate formatting, MessageType roles (System, User, Assistant, Function), prompt injection risks, XML boundary delimiters
- **Gaps Identified:** Did not check if user had answers submitted. Concept logged for future verification.
- **Score:** 8/10

### 2026-07-07 — 🔀 Pause / Sync Day
- **Activity:** Created `/git` and `/notes` custom skills, fixed parent customizations paths, backdated and pushed repository history (Complexity Analysis and DynamicArray assertions) to GitHub.
- **Outcome:** Day 3 shifted to tomorrow. Tracker remains at Day 3.

### 2026-07-16 — `/revise` — CPU Cache vs JVM Cache & Varargs Generics
- **Domain:** DSA / Core Java
- **Competency Stage:** Exposure (re-teaching required)
- **Trap Type:** 🧠 Conceptual Confusion
- **Key Concepts:** CPU cache line prefetching vs JVM IntegerCache objects, Type Erasure varargs binding (`T[]` vs `int[]` object wrapper)
- **Gaps Identified:** Confused physical hardware CPU caches with Java Heap IntegerCache. Missed Generics Compilation rules regarding why primitive arrays cannot bind directly as varargs elements.
- **Score:** 2/10

### 2026-07-16 — `/master` — JPA & Lombok Class Annotations
- **Domain:** Spring Boot
- **Competency Stage:** Guided Practice
- **Trap Type:** N/A (Theoretical Mastery deep-dive)
- **Key Concepts:** Entity Persistence Context, default constructor requirement, `@Builder` default constructor suppression, PostgreSQL keyword collisions with `@Table`, `@Data` performance pitfalls.
- **Gaps Identified:** None. Aligned on clean, explicit JPA entity layouts and Enum mappings.
- **Score:** 9/10

---

## 🔄 Revision Queue

| Topic | Domain | Last Revised | Priority |
|-------|--------|-------------|----------|
| Wrapper type caching (Integer/Long/Byte cache) | Core Java | 2026-07-02 | High |
| Autoboxing/unboxing internals (`valueOf`) | Core Java | 2026-07-02 | High |
| Operator associativity & type promotion in `+` | Core Java | 2026-07-02 | High |
| Logarithmic complexity bounds & division loops | DSA | 2026-07-05 | Medium |
| Recursion call stack limit mechanics (`-Xss`) | DSA | 2026-07-05 | Medium |
| Cache locality vs Pointer chasing (low-latency systems) | DSA | 2026-07-16 | High (CRITICAL) |
| Latency jitter under amortized operations | DSA | 2026-07-06 | Medium |
| Generics & Primitive Varargs (`Arrays.asList` traps) | Core Java | 2026-07-16 | High (CRITICAL) |

---

## 🏆 Milestones

### Program Milestones
- [x] Day 1 completed — journey begins
- [ ] Week 1 completed (6 days)
- [ ] First custom data structure built from scratch
- [ ] NexCommerce project scaffold running
- [ ] Month 1 completed (24 days) — Foundation phase done
- [ ] First microservice split completed
- [ ] Month 2 completed (48 days) — Scale phase done
- [ ] All services containerized with Podman
- [ ] Month 3 completed (72 days) — Production phase done
- [ ] Full NexCommerce architecture review passed

### Skill Usage Milestones
- [x] First `/shorts` session completed
- [x] First `/today` session completed
- [ ] First `/dsa` production-context session completed
- [ ] First `/design` system design session completed
- [ ] First `/project` built and verified
- [ ] First `/mock-interview` scored 8+/10
- [ ] First `/mock-test` production incident resolved
- [ ] 10 topics at `Guided Practice` or above
- [ ] 5 topics at `Independent Application` or above
- [ ] First topic at `Production Mastery`
