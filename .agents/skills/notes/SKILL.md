---
name: notes
description: "Review personal learning notes — displays the compiled list of missed concepts, code traps, and system design insights stored in learning_notes.md. Triggered by '/notes'."
---

# `/notes` — Learning Notes Viewer

## Purpose
Provide the user with quick access to their personal knowledge base of missed concepts, code reviews, and Spring AI guidelines.

## Execution Flow

### Phase 1: Locate and Read Notes
1. Locate `learning_notes.md` (general concepts) and `spring-ai-notes.md` (Spring AI tracks) in the root workspace.
2. If neither file exists, prompt the user to start learning.

### Phase 2: Render Content
Display links and summaries of the notes:
- **General Learning Notes:** [learning_notes.md](file:///d:/2026/Learning/UsingAntigravity/2.0/learning_notes.md)
- **Spring AI Integration Notes:** [spring-ai-notes.md](file:///d:/2026/Learning/UsingAntigravity/2.0/spring-ai-notes.md)

Provide the Table of Contents or key topic summaries for both.

### Phase 3: Revision Prompts
Suggest relevant commands:
- "To test memory: `/revise <topic>`."
- "To test adversarial case: `/trick <topic>`."
