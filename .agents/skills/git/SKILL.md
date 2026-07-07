---
name: git
description: "Git push utility — automates adding, committing, and pushing modifications to GitHub. Triggered by '/git <commit_message>' or '/git'."
---

# `/git` — Git Push Utility

## Purpose
Automate saving your progress. This skill adds all modified files, commits them with a structured message, and pushes them to your remote GitHub repository directly.

## Execution Flow

### Phase 1: Determine Workspace Context
1. Identify the active project subdirectory: `d:\2026\Learning\UsingAntigravity\2.0\BeBetterEveryday`.
2. Check for modifications or untracked changes by executing:
   ```powershell
   git status --short
   ```

### Phase 2: Staging & Committing
1. If no commit message is provided, auto-generate one based on today's completed logs (e.g., `"docs: update learning notes and tracker for Day X"`).
2. Stage all modifications:
   ```powershell
   git add -A
   ```
3. Commit the changes:
   ```powershell
   git commit -m "<message>"
   ```

### Phase 3: Push to GitHub
1. Push the commit to the active branch (e.g., `main` or `master`):
   ```powershell
   git push
   ```
2. If using GitHub CLI (`gh`), it can also authenticate or manage the PR if needed, but standard `git push` is preferred.
3. Display the commit hash and status to the user.
