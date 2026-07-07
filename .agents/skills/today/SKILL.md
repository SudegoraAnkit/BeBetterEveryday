---
name: today
description: "Daily learning scheduler — reads the master daily_plan.md to show today's 2-hour structured session. Includes 10-min revision warmup of yesterday's concepts, 1.5 hours of new concept + practical hands-on, and 30-min cool-down revision. Tracks day progress so concepts never repeat. Triggered by '/today'."
---

# `/today` — Daily Learning Scheduler

## Purpose
Show the user their structured 2-hour learning session for today. This is the user's personal mentor scheduling their day. Never repeat concepts already completed. Always maintain continuity from the previous session.

## Execution Flow

### Phase 1: Determine Current Day
1. Read `learning_tracker.md` at the workspace root.
2. Check the `## 📅 Daily Progress` section for the last completed day number.
3. The current day = last completed day + 1.
4. If no days are completed, start at Day 1.

### Phase 2: Load Today's Plan
1. Read `daily_plan.md` at the workspace root.
2. Find the entry for the current day number.
3. Extract: Topic, Concept details, Practical task, NexCommerce mapping, Revision focus.

### Phase 3: Load Yesterday's Concepts (for Revision Warmup)
1. From `learning_tracker.md`, find the previous day's entry.
2. Extract the key concepts that were covered.
3. Prepare 2-3 active recall questions from those concepts.

### Phase 4: Present the Daily Schedule

Format the output as:

---

**📅 Day [X] of 72 — [Date] — Week [W] of 12**

**🎯 Theme:** [Today's overarching theme]

---

### ⏰ Session Schedule (2 Hours)

#### 🔄 Block 1: Yesterday's Revision (10 min)
*Quick active recall from Day [X-1]: [Previous topic]*

1. [Active recall question 1]
2. [Active recall question 2]
3. [Active recall question 3]

> Answer these in your head or out loud before moving on. If you can't answer confidently, note it as a gap.

---

#### 📖 Block 2: Concept Deep-Dive (50 min)
**Topic:** [Today's concept]

**What to learn:**
- [Bullet 1 — core concept]
- [Bullet 2 — internal mechanics]
- [Bullet 3 — production relevance]
- [Bullet 4 — common mistakes]

**Recommended skill commands:**
- `/shorts [topic]` — Quick concept overview (10 min)
- `/explain [topic]` — Deep internals (20 min)
- Read/research remaining (20 min)

---

#### 🔨 Block 3: Practical Hands-On (40 min)
**Task:** [What to build/code]

**In NexCommerce:** [How this maps to the project]

**Steps:**
1. [Step 1 — file/class to create]
2. [Step 2 — what to implement]
3. [Step 3 — how to test/verify]

> ⚠️ Build this yourself. Don't copy-paste. Use `/guide [topic]` if you're stuck on setup.

---

#### 🧊 Block 4: Cool-Down Revision (20 min)
**Revise today's concepts:**
- Write down the 3 most important things you learned today (in your own words).
- Use `/trick [topic]` to test if you really understood (10 min).
- Use `/revise [topic]` for active recall scoring (10 min).

---

**✅ Day [X] Complete?** Tell me when you're done and I'll log your progress.

---

### Phase 5: After Session Completion

When the user indicates they've completed the day:

1. **Update `learning_tracker.md`:**
   - Add an entry to `## 📅 Daily Progress` with: Day number, Date, Topic, Key concepts, Gaps noted, Status (Complete/Partial)
   - Update the `## 📊 Progress Dashboard` domain counters
   - Update competency stages based on accumulated practice

2. **Acknowledge completion:**
   - Show a brief summary: "Day X complete. [Topic] covered. Tomorrow: [Next day's topic preview]."
   - If gaps were noted, add them to the Revision Queue.

3. **Never repeat a completed day.** If the user calls `/today` and the current day is already done, show the next uncompleted day.

## Rules
- **Never skip days.** Days must be completed in order.
- **Never repeat concepts.** Once a day is marked complete, it's done.
- **Always show yesterday's revision** (except Day 1).
- **The user controls completion.** Don't auto-mark days as done. Wait for explicit confirmation.
- **If a day is partially done**, show remaining items from that day, not the next day.
- **Weekend handling:** The plan has 6 learning days per week. Day 7 is rest. If the user calls `/today` on what would be day 7, remind them it's rest day and preview next week.
