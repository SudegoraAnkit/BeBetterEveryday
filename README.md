# 🚀 BeBetterEveryday: Elite Full-Stack & System Design Mastery

Welcome to **BeBetterEveryday**—a production-focused engineering repository tracking hands-on training across Data Structures & Algorithms (DSA), Core Java, Spring Boot, Microservices, and System Design. 

The entire curriculum is designed to build, optimize, and scale **NexCommerce**, a distributed, high-performance, local-first e-commerce engine.

---

## 🗺️ Project Architecture & Repository Map

```text
├── .agents/                    # Custom Antigravity 2.0 Automation Skills
│   ├── AGENTS.md               # Environment Rules (Podman, native databases, Maven)
│   └── skills/                 # Custom Slash Command scripts (/today, /master, /revise, /git)
├── Code/                       # Production-Grade Code Base
│   ├── array/                  # Arrays & Custom Structures (DynamicArray, assertions)
│   ├── traps/                  # Java Traps and Misconception Verification
│   └── smallprojects/          # Console-based utilities & mini-projects (ToDo app)
├── scratch/                    # Sandbox for algorithmic verification and analysis
│   └── ComplexityAnalysis.java # Day 1: Complexity analysis & big-O verification
├── daily_plan.md               # Complete 72-Day Master Curriculum (Month 1-3)
├── learning_tracker.md         # Active Progress Dashboard, Competency Tracker, & Logs
├── learning_notes.md           # Missed concept catalog, traps, & active-recall revision notes
├── spring_ai_track.md          # 12-Topic Spring AI & LLM Integration Curriculum
├── spring-ai-notes.md          # Core Prompt APIs, Message Roles, & Guardrails
└── disruptor_study_checklist.md# LMAX Disruptor memory architecture study syllabus
```

---

## 🛠️ The 72-Day NexCommerce Learning Path

The repository operates on a strict **2-Hour Daily Block** pattern split into:
1.  **Warmup (10 min):** Active Recall revision from the previous day.
2.  **Concept Deep-Dive (50 min):** Architectural and systems-level internals (`/master`).
3.  **Practical Building (40 min):** Code implementation inside the workspace (no library copy-pasting).
4.  **Cool-down Revision (20 min):** Adversarial edge cases (`/trick`) and scoring.

### 📅 Current Phase: Month 1 — Foundation (Complexity & Core Java Internals)
*   **Day 1:** Big O Notation, Time/Space Complexity & Stack/Heap Overflows.
*   **Day 2:** Array Layouts, Contiguous memory, and Custom `DynamicArray` builders.
*   **Day 3 (Active):** Array Algorithms (Two Sum, Kadane's Algorithm, Rotate Array).
*   **Spring AI Track (Concurrent):** PromptTemplates, Roles (`MessageType`), Prompt Injection Mitigations, and Multimodal Vision API wrappers.

---

## 🧠 Core Engineering Principles Enforced

*   **Mechanical Sympathy:** Designing software that works efficiently with hardware. We prioritize contiguous primitive arrays (`int[]`) over heap-scattered object arrays (`Integer[]`) to optimize **CPU L1/L2 cache prefetching** and eliminate pointer-chasing latency.
*   **Type Safety & Generics:** Understanding Type Erasure compiler limits, such as primitive array varargs binding constraints in `Arrays.asList(int[])` vs. `Integer[]`.
*   **Defensive Prompt Engineering:** Enforcing XML delimiters (`<product_data>`) and strict system prompt guidelines to prevent prompt injection and model jailbreaking.
*   **Production Constraints:** All local code runs on a **Docker-free container runtime (Podman)**, uses native pre-installed PostgreSQL/MongoDB (no container overhead), and compiles using Maven.

---

## ⚡ Custom Interactive Commands (Slash Commands)

If you are pair programming with an assistant in this workspace, you can execute the following automated commands:

*   **`/today`** — Automatically load today's scheduled topic, yesterday's revision questions, and practical tasks.
*   **`/master <topic>`** — Open a principal-architect level deep-dive detailing design decisions, tradeoffs, and sample implementations.
*   **`/revise`** — Trigger a two-question active recall interview on recently covered concepts.
*   **`/notes`** — Open the unified index of your learning notes and Spring AI reference manuals.
*   **`/git <message>`** — Automatically stage, commit, and push all workspace changes to GitHub.
