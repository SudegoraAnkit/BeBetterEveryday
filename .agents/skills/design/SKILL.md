---
name: design
description: "System design whiteboard — deep architectural breakdown of a component, pattern, or system. Draws Mermaid diagrams, discusses tradeoffs (CAP, consistency vs availability), compares approaches, and maps to NexCommerce. Triggered by '/design <component>' or '/design <pattern>'."
---

# `/design <topic>` — System Design Whiteboard

## Purpose
Architecture-level deep dive. Not code — blueprints. Think of this as a whiteboard session with a principal architect who's designed systems at scale.

## Execution Flow

### Phase 1: Topic Classification
Classify the topic into one of:
- **Component Design:** A specific service or subsystem (e.g., "search service", "payment service", "notification system")
- **Pattern Design:** An architectural pattern (e.g., "CQRS", "saga pattern", "event sourcing", "rate limiter")
- **System Design:** A full system (e.g., "URL shortener", "chat application", "e-commerce platform")

### Phase 2: Architecture Breakdown

Present the design in this structure:

#### 1. 🎯 Problem Statement
- What problem does this solve?
- What breaks without it?
- Real production context in NexCommerce

#### 2. 🏗️ Architecture Diagram
- Draw a **Mermaid diagram** showing components, data flow, and interactions
- Include databases, caches, queues, external services
- Label communication patterns (sync/async, REST/gRPC/events)

#### 3. ⚖️ Design Decisions & Tradeoffs
For each major decision, present a tradeoff table:

| Decision | Option A | Option B | NexCommerce Choice | Why |
|----------|----------|----------|-------------------|-----|

Cover:
- Synchronous vs Asynchronous
- Consistency vs Availability (CAP)
- SQL vs NoSQL
- Push vs Pull
- Orchestration vs Choreography

#### 4. 📐 Data Model
- Entity/document schemas
- Relationships and cardinality
- Indexing strategy
- Partitioning/sharding approach (if applicable)

#### 5. 🔥 Failure Modes
- What happens when this component fails?
- Cascading failure risks
- Recovery strategies
- How NexCommerce handles each failure

#### 6. 📈 Scaling Strategy
- Horizontal vs Vertical scaling
- Bottleneck identification
- Caching layers
- Read/write patterns

#### 7. 🔗 Connected Concepts
- Related patterns and components
- Prerequisites to understand first
- What to study next

### Phase 3: Interactive Challenge
Ask 1-2 design questions for the user to think about:
- "What would you change if read traffic is 100x write traffic?"
- "How would you handle this component's failure without data loss?"

Wait for the user's response and evaluate their thinking.

## Post-Execution
Update `learning_tracker.md` with the session.
