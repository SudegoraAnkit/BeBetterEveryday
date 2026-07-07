---
name: dsa
description: "Teaches a data structure or algorithm through its real production use case, not abstract LeetCode style. Shows the production problem first, reveals which DSA concept solves it, guides building a custom implementation from scratch, then maps it to NexCommerce. Triggered by '/dsa <topic>'."
---

# `/dsa <topic>` — DSA in Production Context

## Purpose
Bridge the gap between "I know what a Trie is" and "I know WHERE and WHY to use a Trie in production." Every data structure and algorithm exists because someone had a real problem. Teach through that problem.

## Execution Flow

### Phase 1: The Production Crisis
Present a **real production scenario** from NexCommerce where this DSA concept is needed:

---

**🔥 Production Problem**

*[Describe a realistic production issue]*

Example for Trie:
> "NexCommerce's search bar takes 800ms to return autocomplete suggestions for 100K products. Users see a visible delay after every keystroke. Product has filed a P1 bug. The current implementation does `LIKE '%query%'` against MongoDB on every keystroke. Fix it."

---

### Phase 2: Why This DSA Concept
- Explain why the naive approach fails (O(n) scan, memory bloat, latency)
- Introduce the DSA concept as the solution
- Show time/space complexity comparison: before vs after

| Metric | Naive Approach | With [DSA Concept] |
|--------|---------------|--------------------|
| Time | O(n) per query | O(m) where m = query length |
| Space | O(1) extra | O(N × L) for the structure |
| Latency | 800ms | <5ms |

### Phase 3: Build It From Scratch
Guide the user to implement the data structure from scratch in Java:

1. **Define the Node class** — describe fields, don't give code
2. **Implement core operations** — insert, search, delete (give method signatures, not bodies)
3. **Test with sample data** — provide test cases
4. **Optimize** — discuss memory optimization, thread safety

> ⚠️ Do NOT write the full implementation. Give the structure, method signatures, and hints. The user must write the code.

### Phase 4: Integrate into NexCommerce
- Show WHERE in the NexCommerce codebase this would live
- Which service owns it
- How it interfaces with other components
- Production considerations: persistence, cache warming, concurrent access, memory limits

### Phase 5: LeetCode Bridge
List 3-5 LeetCode problems that use this concept, ordered by difficulty:
1. Easy — [Problem name] (LeetCode #XXX)
2. Medium — [Problem name] (LeetCode #XXX)
3. Hard — [Problem name] (LeetCode #XXX)

> "If you can solve these, the concept is locked in."

### Phase 6: Production Edge Cases
Present 2-3 edge cases that only matter in production (not in LeetCode):
- Memory pressure under high cardinality
- Concurrent modification
- Serialization/deserialization for persistence
- Hot-path optimization

## Post-Execution
Update `learning_tracker.md`:
- Log topic, date, whether they built the implementation successfully
- Set competency to `Guided Practice` if they built it, `Exposure` if they only studied theory
