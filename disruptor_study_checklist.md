# 📚 LMAX Disruptor Study Checklist — Saturday Session

Official Documentation: [LMAX Disruptor User Guide](https://lmax-exchange.github.io/disruptor/disruptor.html)

---

## 🗂️ Part 1: The Core Philosophy & Setup
- [ ] **1. Introduction**
    *   *Focus:* Why standard bounded queues (like `ArrayBlockingQueue`) cause latency spikes. Understand how lock contention and CAS overhead degrade performance at high throughput.
- [ ] **2. What is the Disruptor?**
    *   *Focus:* The basic architectural model. How it acts as a high-performance alternative to traditional producer-consumer patterns.
- [ ] **3. Getting Started (Code & Setup)**
    *   *Focus:* How to define an **Event**, create an **EventFactory**, set up an **EventHandler**, and publish to the **Ring Buffer** safely using the new `Disruptor` DSL helper.

---

## 🗂️ Part 2: Under the Hood (The Architecture)
- [ ] **4. Core Concepts Glossary**
    *   *Focus:* Memorize the roles of these key components:
        *   **Ring Buffer:** Circular array storing the event payloads.
        *   **Sequence:** The monotonically increasing counter (monitored to prevent consumer-producer collisions).
        *   **Sequencer:** Coordinates who claims which slot (claims slots for writers).
        *   **Sequence Barrier:** Coordinates progress between consumers.
        *   **Wait Strategy:** How consumers wait for new slots (busy spin vs. sleep).
- [ ] **5. Multicast Events & Consumer Dependency Graphs**
    *   *Focus:* How multiple consumers can read the same event simultaneously, and how to chain consumers (e.g., Consumer B only reads after Consumer A is done).

---

## 🗂️ Part 3: Advanced Optimization & Mechanical Sympathy
- [ ] **6. Producer Types (Single vs. Multi)**
    *   *Focus:* Why setting `ProducerType.SINGLE` is massively faster than `MULTI` (it bypasses concurrent CAS loops on slot claiming).
- [ ] **7. Choosing a Wait Strategy**
    *   *Focus:* Compare latency vs. CPU consumption tradeoffs:
        *   `BlockingWaitStrategy` (Low CPU, high latency jitter)
        *   `YieldingWaitStrategy` (Medium CPU, low latency jitter)
        *   `BusySpinWaitStrategy` (100% CPU core lock, lowest latency, sub-microsecond response)
- [ ] **8. Design and Implementation Details**
    *   *Focus:* Read the sections explaining **False Sharing** and **CPU cache-line padding** (how the Disruptor pads the `Sequence` class with empty `long` variables to align with the CPU's 64-byte L1 cache lines).
