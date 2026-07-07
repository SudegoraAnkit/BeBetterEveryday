---
name: pdd
description: "Pain-Driven Development — contextualizes a library or architectural pattern by first highlighting the distress of working without it, then showing how it solves that crisis. Triggered by '/pdd <topic>'."
---

# `/pdd <topic>` — Pain-Driven Development

## Purpose
Teach the user *why* a technology, library, or architectural pattern exists by making them **feel the pain** of the world before it existed. Understanding the problem space is more important than memorizing the solution API.

## Output Structure

You MUST structure your response using exactly these two sections:

### 1. 🔥 The Pain
- Describe the architectural mess, memory leaks, manual overhead, boilerplate explosion, race conditions, or performance bugs that engineers suffered **before** this tool/pattern was introduced.
- Be visceral and specific. Show real (or realistic) code snippets of the "old way" — the ugly, error-prone, verbose approach that made engineers suffer.
- Highlight the specific failure modes:
  - What broke in production?
  - What took 200 lines of code that should take 5?
  - What caused 3 AM pager alerts?
  - What security holes were left open?
- Use concrete examples. If the topic is "Spring Boot," show raw Servlet configuration XML hell. If the topic is "Docker," show "it works on my machine" deployment nightmares with conflicting system dependencies.

### 2. 💊 The Relief
- Demonstrate exactly how `<topic>` solves that specific crisis cleanly.
- Show the modern approach side-by-side or immediately after the painful version.
- Explain **which specific pain point** each feature addresses.
- Don't just show the API — connect every line of the solution back to a specific suffering from "The Pain" section.
- If applicable, mention any **new pain** the solution introduces (e.g., "Spring Boot's auto-configuration magic can hide misconfigurations that only surface under load").

## Depth Calibration
- **Core Java / Spring Boot:** Assume the user has fought with legacy code. Reference pre-Java-8 patterns, XML-heavy Spring configs, manual JDBC, raw Servlet APIs, etc.
- **Frontend:** Show jQuery spaghetti, manual DOM manipulation, callback hell, pre-ES6 module patterns.
- **Microservices / DevOps:** Show manual deployment scripts, monolith scaling pain, bare-metal server management.

## Code Guidelines
- Show "before" code that is intentionally ugly but realistic — the kind of code found in real legacy codebases.
- Show "after" code that is clean, idiomatic, and production-ready.
- Do NOT write full application code for the user to copy. Show focused snippets that illustrate the contrast.

## Post-Execution
After delivering the response, update `learning_tracker.md` at the workspace root:
- Add a session log entry with today's date, the topic, domain, and competency stage `Exposure`.
- Note in the entry that PDD context was provided (helps with future revision scheduling).
