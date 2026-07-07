---
name: roadmap
description: "Shows the user's position on the 72-day NexCommerce mastery roadmap. Calculates completion by phase (Foundation/Scale/Production), tracks sprint progress, identifies gaps, and shows distance to becoming a production-grade top 10% developer. Triggered by '/roadmap'."
---

# `/roadmap` — 72-Day Mastery Roadmap Navigator

## Purpose
Visualize the user's position in the 3-month NexCommerce mega-project journey. Show phase completion, sprint progress, domain mastery, and distance to the "Top 10%" threshold.

## Execution Flow

### Phase 1: Read Current State
1. Read `learning_tracker.md` — gather daily progress, session logs, scores, competency stages.
2. Read `daily_plan.md` — get the full 72-day schedule.
3. Determine: Last completed day, current week, current phase.

### Phase 2: Calculate Progress

#### A. Daily Progress
- Days completed out of 72
- Current phase: Foundation (Days 1-24), Scale (Days 25-48), Production (Days 49-72)
- Percentage through program: `(completed_days / 72) × 100`

#### B. Domain Progress
For each domain (DSA, Spring Boot, System Design, Databases, Messaging, DevOps, etc.):
- Count topics covered at each competency stage
- Weighted completion:
  - Uncovered = 0%, Exposure = 25%, Guided Practice = 50%, Independent Application = 75%, Production Mastery = 100%

#### C. Sprint Progress
For each week (1-12), show days completed out of 6.

### Phase 3: Generate Roadmap Report

#### 1. 📊 Program Overview

```
Phase 1: Foundation ████████░░░░░░░░░░░░ 33% (Days 1-24)
Phase 2: Scale      ░░░░░░░░░░░░░░░░░░░░  0% (Days 25-48)
Phase 3: Production ░░░░░░░░░░░░░░░░░░░░  0% (Days 49-72)

Overall: ██░░░░░░░░░░░░░░░░░░ 11% (8/72 days)
```

Use Unicode block characters to render progress bars.

#### 2. 🗓️ Sprint Status Table

| Week | Phase | Days Done | Status | Theme |
|------|-------|-----------|--------|-------|
| 1 | Foundation | 3/6 | 🟡 In Progress | Arrays + Strings + Setup |
| 2 | Foundation | 0/6 | ⚪ Not Started | LinkedList + Stack + Queue |
| ... | ... | ... | ... | ... |

Status indicators: 🟢 Complete, 🟡 In Progress, ⚪ Not Started

#### 3. 📈 Domain Mastery

| Domain | Topics | Exposure | Guided | Independent | Mastery | Score |
|--------|--------|----------|--------|-------------|---------|-------|
| DSA | 40 | 5 | 2 | 0 | 0 | 15% |
| Spring Boot | 15 | 1 | 0 | 0 | 0 | 2% |
| ... | ... | ... | ... | ... | ... | ... |

#### 4. 📏 Distance to Top 10%

Define the "Top 10%" production-grade developer bar:
- **DSA:** `Guided Practice` on ALL 40+ data structures/algorithms, `Independent Application` on 20+ core ones
- **Spring Ecosystem:** `Independent Application` on Boot, MVC, JPA, Security, Cloud
- **System Design:** Can whiteboard 5+ systems from scratch with tradeoffs
- **Microservices:** `Production Mastery` on at least one end-to-end distributed system
- **DevOps:** Can containerize, deploy, and monitor a multi-service application
- **Overall:** 70%+ weighted completion across ALL domains

Show:
- Current % vs 70% target
- Days remaining in the program
- Estimated completion date at current pace
- If behind schedule: how many days per week needed to catch up

#### 5. 🎯 What's Next

Based on current day, recommend:
- **Today:** "Start Day X — [topic]" or "Continue Day X — [remaining items]"
- **This Week:** Summary of week's remaining topics
- **Critical Gaps:** Any high-priority items in the Revision Queue
- **Recommended commands:** Which `/today`, `/shorts`, `/trick`, `/revise` to run next

#### 6. 🏆 Milestone Tracker

Show progress toward key milestones:

**Foundation Phase:**
- [ ] Day 1 completed — journey begins
- [ ] First custom data structure built from scratch
- [ ] NexCommerce project scaffold running
- [ ] Week 4 done — Foundation complete

**Scale Phase:**
- [ ] First graph algorithm implemented
- [ ] Kafka producer/consumer working
- [ ] Microservice split completed
- [ ] Week 8 done — Scale complete

**Production Phase:**
- [ ] All services containerized with Podman
- [ ] Distributed tracing implemented
- [ ] Full system design interview passed
- [ ] Day 72 — Program complete 🎓

**Mastery Milestones:**
- [ ] 10 topics at `Guided Practice` or above
- [ ] 5 topics at `Independent Application` or above
- [ ] First `/mock-interview` scored 8+/10
- [ ] First `/mock-test` production incident resolved
- [ ] First topic at `Production Mastery`

### Phase 4: Sync learning.md
- Cross-reference `learning_tracker.md` daily progress with `learning.md` checkboxes
- Update any checkboxes that should be marked based on completed days

## Post-Execution
Update `learning_tracker.md` with a session entry noting the roadmap review, current day, overall %, and priorities.
