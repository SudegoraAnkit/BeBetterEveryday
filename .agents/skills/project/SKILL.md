---
name: project
description: "Design a hyper-focused, targeted micro-project for hands-on practice in the active workspace. Triggered by '/project <scenario>'. Provides objective, workspace architecture, step-by-step build instructions, and verification commands."
---

# `/project <scenario>` — Micro-Project Generator

## Purpose
Design exactly **ONE** hyper-focused, targeted micro-project based on the given `<scenario>`. The user will build it out in the active workspace with their own hands. You guide architecture and verification — they write the code.

## Output Structure

You MUST structure your response using exactly these sections:

### 1. 🎯 Objective
- A clear, 2-3 sentence description of what the user will build and why it matters in production.
- Frame it as a real-world engineering task, not an academic exercise.
- Example: "Build a rate-limited REST API with Redis-backed sliding window counters that rejects excess traffic with proper 429 responses and Retry-After headers."

### 2. 🏗️ Workspace Architecture
- List the **exact directory structure** the user must create.
- Use a tree diagram format.
- Mark each file with a brief annotation of its purpose.
- Example:
  ```
  project-root/
  ├── src/main/java/com/example/
  │   ├── config/
  │   │   └── RateLimitConfig.java       // Redis + Bucket4j configuration
  │   ├── filter/
  │   │   └── RateLimitFilter.java       // Servlet filter for rate limiting
  │   ├── controller/
  │   │   └── ApiController.java         // Sample endpoint
  │   └── Application.java              // Spring Boot entry point
  ├── src/main/resources/
  │   └── application.yml                // Redis connection + rate limit properties
  ├── docker-compose.yml                 // Redis container
  └── pom.xml                           // Dependencies
  ```

### 3. 📦 Dependencies & Configuration
- List the exact dependencies (Maven/Gradle/npm) the user must add, with group IDs, artifact IDs, and versions.
- Provide skeleton configuration files (`application.yml`, `pom.xml`, `docker-compose.yml`, `package.json`, etc.) with the structure filled in but **key implementation logic left as TODOs**.
- Tell the user what to configure, not just what to copy.

### 4. 🔨 Build Steps
- Numbered, sequential instructions for what the user must implement.
- For each step:
  - Which file to work in
  - What concept to implement (with hints, not full solutions)
  - What to test after completing that step
- Do NOT provide complete implementation code. Provide:
  - Method signatures
  - Key annotations or decorators
  - Brief pseudocode or logic hints
  - The specific classes/interfaces they need to use

### 5. ✅ Verification Steps
- The exact terminal commands needed to verify their work.
- Include commands for:
  - Building the project (`mvn clean install`, `npm run build`, etc.)
  - Starting dependencies (`docker compose up -d`)
  - Running the application
  - Testing with `curl`, `httpie`, or browser
  - Running automated tests
- Provide expected output for each verification command so the user knows what "success" looks like.

## Project Scoping Rules
- Each project should be completable in **30-90 minutes**.
- Focus on ONE core concept. Don't try to teach 5 things in one project.
- The project must be self-contained — runnable entirely from the workspace without external services beyond what Docker can provide.
- Include at least one "stretch goal" for advanced users.

## No Blind Copying Rule
- NEVER provide a complete, runnable codebase. The user must write the core logic themselves.
- You provide: structure, dependencies, method signatures, hints, and verification.
- They provide: the actual implementation.

## Post-Execution
After delivering the project brief, update `learning_tracker.md` at the workspace root:
- Add a session log entry with today's date, the scenario/topic, domain, and competency stage `Guided Practice`.
- Track whether the user completed verification successfully in subsequent interactions.
