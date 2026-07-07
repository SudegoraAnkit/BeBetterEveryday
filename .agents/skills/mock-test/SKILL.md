---
name: mock-test
description: "Production SRE & Scale Engine — simulates real-world production incidents, system outages, or critical scaling constraints. Tests the user's ability to triage, diagnose, and resolve production failures. Triggered by '/mock-test <scenario>'."
---

# `/mock-test <scenario>` — Production Incident Simulator

## Purpose
Simulate a real-world production incident, system outage, or critical scaling constraint based on the given `<scenario>` or current topic. Train the user's production debugging instincts and incident response skills.

## Output Structure

### Phase 1: The Situation 🚨
Present a detailed production failure scenario that includes:
- **Service context:** What the service does, its traffic volume, and its position in the architecture.
- **Symptom description:** The exact error messages, metrics anomalies, or user complaints being observed.
- **Timeline:** When the issue started, any recent deployments or config changes, and how it's progressing (stable? worsening?).
- **Available data:** Relevant log snippets, metric graphs (described textually), dashboard alerts, and any initial triage already performed by the on-call engineer.

#### Scenario Depth Examples:
- "Your Spring Boot microservice is throwing `java.lang.OutOfMemoryError: Metaspace` after deploying a new version that added 47 new auto-configured beans. The service restarts every 12 minutes. Customer-facing API latency is at 4.2 seconds (SLA: 200ms)."
- "Your PostgreSQL connection pool is reporting `HikariPool-1 - Connection is not available, request timed out after 30000ms` during peak hours. Active connections are stuck at maximum (10). The database CPU is at 15%."
- "After enabling distributed tracing with Jaeger, your microservice mesh latency increased by 340ms per request. The trace collector pod is OOMKilled every 30 minutes."
- "Your Kubernetes deployment rollout is stuck at 2/5 ready pods. The new pods are in `CrashLoopBackOff` with exit code 137. The old pods are serving traffic but the HPA is trying to scale down."

### Phase 2: The Prompt 🔍
Ask the user:
1. **Root Cause Analysis:** What architectural or configuration choices caused this issue?
2. **Immediate Triage:** What are the first 3 commands or actions you'd take right now to diagnose this?
3. **Resolution Strategy:** How would you fix this — both the immediate patch and the permanent structural fix?

**STOP here and wait for the user's response.** Do NOT provide answers until they respond.

### Phase 3: Evaluation (after user responds)
Break down their strategy using these three pillars:

#### 1. 💰 Production Impact Analysis
- How does their proposed fix affect:
  - Infrastructure costs (compute, memory, network bandwidth)
  - Data integrity (any risk of data loss or corruption?)
  - User experience (downtime duration, degraded service period)
  - SLA compliance (will this breach contractual obligations?)
- Score their impact awareness: did they consider blast radius?

#### 2. ⚖️ Trade-off Analysis
- What did their solution sacrifice?
- Example: "Using an in-memory Redis cache speeds up latency but creates eventual consistency challenges and adds a new failure domain."
- Did they acknowledge the trade-offs, or did they present their solution as having no downsides?
- What alternative approaches exist and why might they be better/worse?

#### 3. 🔧 Patch vs. Fix Analysis
- **Immediate patch:** The quick, safe action to stop the bleeding (e.g., rollback, increase pool size, add circuit breaker).
- **Permanent fix:** The structural change that prevents recurrence (e.g., connection leak audit, proper resource lifecycle management, capacity planning).
- Did the user distinguish between these two? A senior engineer always does.

### Phase 4: The Full Diagnosis
After evaluation, provide:
1. **The actual root cause** with technical precision.
2. **The exact commands** for diagnosis (e.g., `jmap -dump:format=b,file=heap.hprof <pid>`, `kubectl describe pod`, `EXPLAIN ANALYZE` for slow queries).
3. **The production-grade fix** — both immediate and permanent.
4. **Prevention measures:** Monitoring, alerting, and architectural guardrails to prevent recurrence.

### Scoring
Score the user's response:

| Category | Score | Weight |
|----------|-------|--------|
| Root Cause Identification | X/10 | 30% |
| Triage Speed & Accuracy | X/10 | 25% |
| Trade-off Awareness | X/10 | 20% |
| Patch vs. Fix Distinction | X/10 | 15% |
| Communication Clarity | X/10 | 10% |
| **Weighted Total** | **X/10** | |

## Post-Execution
After evaluation, update `learning_tracker.md`:
- Log the session with date, scenario, scores by category, and weighted total.
- Update competency stage. Mock-test success directly maps to `Independent Application` or `Production Mastery`.
- Add weak categories to the Revision Queue.
