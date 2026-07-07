---
name: roast
description: "Brutally critical code review of the current active file, git diff, or staged files. Points out anti-patterns, missing null checks, poor thread safety, hardcoded properties, poor naming, and lack of error handling. Triggered by '/roast'."
---

# `/roast` — Code Roast Engine

## Purpose
Analyze the current active code file, recent git diff, or staged files in the workspace and deliver a **brutally honest, technically rigorous code review**. No sugar-coating. The goal is to surface every anti-pattern, vulnerability, and design flaw before it reaches production.

## Execution Flow

### Phase 1: Code Discovery
Determine what code to review using this priority order:
1. **Currently open/active file** in the IDE (check user's cursor context).
2. **Recent git diff** (`git diff HEAD~1` or staged changes).
3. **Most recently modified files** in the workspace.
4. If no code is found, ask the user to specify which file or paste code.

### Phase 2: The Roast 🔥
Analyze the code and call out **every** issue found. Organize findings by severity:

#### 🚨 Critical (Production Breakers)
- Security vulnerabilities (SQL injection, XSS, CSRF, credential exposure)
- Race conditions and thread safety violations
- Memory leaks and resource leaks (unclosed connections, streams, executors)
- Data corruption risks (non-atomic operations, missing transaction boundaries)
- Unhandled exceptions that crash the application

#### ⚠️ Major (Technical Debt Bombs)
- Anti-patterns (God classes, circular dependencies, service locator, anemic domain model)
- Missing or improper error handling (swallowed exceptions, generic catch blocks)
- Hardcoded configuration values (URLs, ports, credentials, magic numbers)
- Poor null safety (missing null checks, Optional misuse, nullable returns)
- N+1 query problems, unbounded collections, missing pagination

#### 📝 Minor (Code Hygiene)
- Poor naming conventions (single-letter variables, misleading method names)
- Missing or misleading documentation
- Dead code, unused imports, commented-out code blocks
- Inconsistent formatting or style violations
- Overly complex methods (high cyclomatic complexity)
- Missing logging at critical decision points

### Roast Style Guidelines
- Be **specific and line-referenced**. Don't say "your error handling is bad." Say "Line 47: catching `Exception` instead of `SpecificException` swallows `InterruptedException`, which corrupts your thread pool's interrupt contract."
- Use a direct, slightly sarcastic but educational tone.
- Every criticism must include the **concrete risk** — what breaks, when, and how badly.
- Reference real-world incidents or CVEs when applicable.

### Phase 3: The Refactored Version
**Only after** completing the full roast, provide the optimized refactored code:
- Show the improved version with inline comments explaining each fix.
- Don't rewrite the entire file — focus on the sections that were roasted.
- If the issues are architectural (not just code-level), describe the structural changes needed before showing code.

### Phase 4: Scorecard
Provide a summary scorecard:

| Category | Score | Issues Found |
|----------|-------|-------------|
| Security | X/10 | Brief summary |
| Performance | X/10 | Brief summary |
| Maintainability | X/10 | Brief summary |
| Error Handling | X/10 | Brief summary |
| Naming & Style | X/10 | Brief summary |
| **Overall** | **X/10** | |

## Post-Execution
After delivering the roast, update `learning_tracker.md`:
- Log the session with the file/topic reviewed, date, and overall score.
- If specific anti-patterns were found, add those concepts to the Revision Queue.
