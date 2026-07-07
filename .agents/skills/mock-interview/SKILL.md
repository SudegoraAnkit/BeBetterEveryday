---
name: mock-interview
description: "Simulates a rigorous, multi-turn technical interview screen. Asks one question at a time, grades responses out of 10, and doesn't proceed until the user answers or skips. Triggered by '/mock-interview <topic>'."
---

# `/mock-interview <topic>` — Technical Interview Simulator

## Purpose
Simulate a rigorous, multi-turn technical interview screen focused on the given `<topic>`. Replicate the pressure, depth, and follow-up questioning style of FAANG/top-tier company interviews.

## Execution Rules

### Interview Protocol
1. **Ask exactly ONE question at a time.** Never batch questions.
2. **Wait for the user to respond** before proceeding. Do NOT continue, provide hints, or auto-advance.
3. The user must give a **full answer** or **explicitly type "skip"** before you move to the next question.
4. Conduct **4-5 questions** per interview session, escalating in difficulty.

### Question Design

#### For DSA/Algorithm Topics:
- Start with a medium-difficulty problem statement (LeetCode medium equivalent).
- Include constraints (input size, time complexity requirements).
- Ask for:
  1. Their approach and time/space complexity before coding
  2. The actual implementation
  3. Edge cases they'd test
  4. Follow-up: "Now the input is 10^9 elements — how does your approach change?"

#### For Java/Spring Framework Topics:
- Ask scenario-based questions that test deep framework understanding.
- Examples:
  - "You have a Spring service with `@Transactional(propagation = REQUIRES_NEW)`. A RuntimeException is thrown in the inner transaction. What happens to the outer transaction? Walk me through the proxy chain."
  - "Your Spring Boot app starts throwing `BeanCurrentlyInCreationException`. What's happening, what are the possible causes, and how do you fix it without breaking the dependency graph?"
  - "Explain how Spring Security's `FilterChainProxy` decides which security filter chain to apply to an incoming request. What happens if two `SecurityFilterChain` beans match?"

#### For System Design Topics:
- Present a real-world system to design (e.g., "Design a URL shortener that handles 100K writes/sec").
- Probe for: data model, API design, scaling strategy, failure modes, consistency model.
- Ask trade-off questions: "Why did you choose X over Y?"

### Grading Rubric (per question)
Score each response **X/10**:

| Score | Meaning |
|-------|---------|
| 10 | Flawless. Optimal solution, clean code, edge cases covered, complexity analyzed. |
| 8-9 | Strong. Correct approach with minor gaps in optimization or edge cases. |
| 6-7 | Acceptable. Working solution but suboptimal complexity or missing key considerations. |
| 4-5 | Partial. Right direction but significant gaps in implementation or understanding. |
| 2-3 | Weak. Fundamental misunderstanding of the problem or approach. |
| 0-1 | No meaningful answer or completely incorrect. |

### After Each Answer, Provide:
1. **Score: X/10**
2. **What was strong:** Specific things they got right.
3. **What was weak:** Specific gaps or errors.
4. **The ideal answer:** What a top candidate would have said (concise, not a lecture).
5. **Follow-up question** (if not the last question) OR **final summary** (if last question).

### Final Summary (after all questions)
Provide an overall interview scorecard:

| Question | Topic | Score |
|----------|-------|-------|
| Q1 | ... | X/10 |
| Q2 | ... | X/10 |
| ... | ... | ... |
| **Overall** | | **X/10** |

- **Verdict:** `Strong Hire` / `Hire` / `Lean Hire` / `No Hire` / `Strong No Hire`
- **Key strengths:** 2-3 bullet points
- **Areas to improve:** 2-3 bullet points with specific study recommendations

## Post-Execution
After the interview concludes, update `learning_tracker.md`:
- Log the session with date, topic, individual scores, and overall verdict.
- Update competency stage based on overall score (same rubric as `/revise`).
- Add weak areas to the Revision Queue.
