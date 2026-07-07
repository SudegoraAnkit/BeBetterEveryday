# 🤖 Spring AI Integration Track — NexCommerce

> This document defines the Spring AI learning track integrated into the NexCommerce mega-project.
> Days listed here are **supplementary** to the core 72-day plan. They can be done as bonus days or swapped with theory-lighter days.

---

## Why Spring AI in NexCommerce?

NexCommerce isn't just CRUD — it's a platform that competes with Amazon, Swiggy, and Flipkart.
These platforms use AI for: search, recommendations, support, content, fraud detection, and pricing.
Spring AI gives you **framework-native LLM integration** without leaving the Spring ecosystem.

---

## NexCommerce AI Use Cases

| Use Case | Service | AI Capability | Complexity |
|----------|---------|--------------|------------|
| 🔍 Natural Language Product Search | Search Service | Embeddings + Vector Search | Intermediate |
| 💬 Customer Support Chatbot | Support Service | Chat Model + RAG | Intermediate |
| 📝 Auto Product Descriptions | Product Service | Text Generation | Beginner |
| ⭐ Review Summarization | Product Service | Summarization | Beginner |
| 🛡️ Content Moderation | Product Service | Classification | Intermediate |
| 🎯 Personalized Recommendations | Recommendation Service | Embeddings + Similarity | Advanced |
| 🕵️ Fraud Detection | Payment Service | Anomaly Detection Prompt | Advanced |
| 💰 Dynamic Pricing Insights | Analytics Service | Analysis + Structured Output | Advanced |
| 📊 Sales Report Generation | Analytics Service | Structured Output | Intermediate |
| 🔔 Smart Notifications | Notification Service | Personalized Text Generation | Beginner |

---

## Learning Progression (12 Topics — Beginner to Advanced)

### Phase 1: Foundations (Beginner)

#### 1. Spring AI Setup & First Call
- **Theory:** What is Spring AI? Model abstraction, provider-agnostic design, ChatClient API
- **First Principle:** LLMs are stateless text-in/text-out functions. Spring AI wraps them in Spring's dependency injection model.
- **Practical:** Add spring-ai-starter dependency, configure API key, make first ChatClient call
- **NexCommerce:** Generate a product tagline from product name + category
- **Tradeoff:** Vendor lock-in vs abstraction overhead. When to use Spring AI vs raw HTTP calls.

#### 2. Prompt Engineering & Templates [x]
- **Status:** Completed on 2026-07-06 (Ref: `/master PromptTemplate and Role`)
- **Theory:** System prompts, user prompts, PromptTemplate, variable substitution, few-shot prompting
- **First Principle:** Prompts are programs for LLMs. Structure determines output quality.
- **Practical:** Create PromptTemplate for product description generation with style/tone parameters
- **NexCommerce:** Product Service — auto-generate SEO-optimized descriptions
- **Tradeoff:** Rigid templates vs flexible prompts. Token cost vs output quality.

#### 3. Structured Output Parsing
- **Theory:** BeanOutputConverter, ListOutputConverter, MapOutputConverter, custom parsers
- **First Principle:** LLMs output text. Structured output parsing bridges text → typed Java objects.
- **Practical:** Parse LLM response into `ProductReview` record, handle parse failures gracefully
- **NexCommerce:** Review summarization — extract sentiment, key pros/cons, rating into structured object
- **Tradeoff:** Parsing reliability vs flexibility. Schema enforcement vs natural language.

### Phase 2: Integration Patterns (Intermediate)

#### 4. Embeddings & Vector Stores
- **Theory:** What are embeddings? Vector space, cosine similarity, EmbeddingClient, VectorStore interface
- **First Principle:** Embeddings convert text to numbers. Similar meanings = nearby vectors. This enables semantic search.
- **Practical:** Generate embeddings for product descriptions, store in vector store, query by similarity
- **NexCommerce:** Search Service — semantic product search ("find warm winter jacket under ₹2000")
- **Tradeoff:** Embedding model size vs quality. In-memory vs persistent vector store. Dimensionality.

#### 5. RAG (Retrieval Augmented Generation)
- **Theory:** Why RAG? Retriever → Context stuffing → LLM generation. Document loaders, text splitters, chunking strategies
- **First Principle:** LLMs have knowledge cutoffs and hallucinate. RAG grounds them in YOUR data.
- **Practical:** Build RAG pipeline: load product FAQ docs → chunk → embed → store → retrieve → generate answer
- **NexCommerce:** Support Service — customer chatbot that answers from product FAQ, return policy, shipping info
- **Tradeoff:** Chunk size vs context quality. Retrieval accuracy vs latency. Cost of embedding all docs.

#### 6. Chat Memory & Conversation Management
- **Theory:** ChatMemory, MessageChatMemoryAdvisor, token window management, conversation history
- **First Principle:** LLMs are stateless. Memory must be managed externally. Every message costs tokens.
- **Practical:** Add conversation memory to Support chatbot, implement token-window truncation
- **NexCommerce:** Support Service — multi-turn customer conversations with context retention
- **Tradeoff:** Memory window size vs cost. Full history vs summarized history. Per-user vs shared memory.

#### 7. Function Calling / Tool Use
- **Theory:** @Description, FunctionCallback, how LLMs decide to call tools, tool result injection
- **First Principle:** LLMs can't access real-time data. Function calling lets them invoke your APIs to fetch live info.
- **Practical:** Register order lookup, product search, and delivery status as callable functions
- **NexCommerce:** Support chatbot can now say "Let me check your order #12345" and actually look it up
- **Tradeoff:** Security of exposed functions. Hallucinated function calls. Latency of tool round-trips.

### Phase 3: Production Hardening (Advanced)

#### 8. Guardrails & Content Filtering
- **Theory:** Input sanitization, output validation, content classifiers, prompt injection attacks
- **First Principle:** User input to an LLM is code injection by nature. Every user prompt is potentially adversarial.
- **Practical:** Build input sanitizer (block SQL/code injection in prompts), output validator (check for harmful content), prompt injection test suite
- **NexCommerce:** All AI endpoints — prevent users from jailbreaking the support chatbot
- **Tradeoff:** Strict filtering vs user experience. False positives vs security. Latency of validation pipeline.

#### 9. Observability & Cost Management
- **Theory:** Token counting, cost tracking, latency monitoring, prompt/response logging, A/B testing prompts
- **First Principle:** Every LLM call costs money and time. Without observability, costs spiral and quality degrades silently.
- **Practical:** Add Micrometer metrics for token usage, response latency, error rates. Build cost dashboard.
- **NexCommerce:** Analytics Service — track AI costs per service, per endpoint, per customer tier
- **Tradeoff:** Logging verbosity vs storage cost. Sampling vs full logging. Privacy of logged prompts.

#### 10. Caching & Optimization
- **Theory:** Semantic caching (cache by meaning, not exact match), response caching, embedding caching, model fallbacks
- **First Principle:** Many user queries are semantically identical. Caching prevents redundant expensive LLM calls.
- **Practical:** Implement semantic cache using embeddings + similarity threshold. Add model fallback chain (GPT-4 → GPT-3.5 → cached response)
- **NexCommerce:** Search Service — cache common search queries, reduce API costs by 60-80%
- **Tradeoff:** Cache staleness vs cost savings. Similarity threshold tuning. Cold start problem.

### Phase 4: Advanced Patterns (Expert)

#### 11. Multi-Model Orchestration & Advisors
- **Theory:** Advisor chain pattern, request/response advisors, model routing, multi-model pipelines
- **First Principle:** Different tasks need different models. Orchestration lets you route to the right model at the right cost.
- **Practical:** Build advisor chain: InputSanitizer → RateLimiter → ModelRouter → OutputValidator → ResponseLogger
- **NexCommerce:** AI Gateway — route simple queries to cheap models, complex ones to powerful models
- **Tradeoff:** Pipeline complexity vs flexibility. Latency of chain vs single call. Error propagation.

#### 12. Evaluation & Testing AI Features
- **Theory:** AI output evaluation, golden datasets, automated testing of prompts, regression detection
- **First Principle:** AI outputs are non-deterministic. Testing AI requires statistical evaluation, not assertion equality.
- **Practical:** Build evaluation framework: golden Q&A dataset, automated scoring, prompt regression tests
- **NexCommerce:** CI/CD pipeline — run AI evaluation suite before deploying prompt changes
- **Tradeoff:** Evaluation cost (LLM-as-judge) vs manual review. Test coverage vs test speed. Flaky tests from non-determinism.

---

## Integration into 72-Day Plan

These topics weave into the existing daily plan at these points:

| Day Range | Spring AI Topic | Pairs With |
|-----------|----------------|------------|
| Day 6 (Week 1) | Setup & First Call | Spring Boot setup |
| Day 12 (Week 2) | Prompt Templates | REST APIs |
| Day 24 (Week 4) | Structured Output | MongoDB integration |
| Day 30 (Week 5) | Embeddings intro | Spring Security |
| Day 36 (Week 6) | RAG basics | Kafka (event-driven AI) |
| Day 42 (Week 7) | Chat Memory | Microservices architecture |
| Day 48 (Week 8) | Function Calling | API Gateway |
| Day 53 (Week 9) | Guardrails | Rate Limiting |
| Day 60 (Week 10) | Observability & Cost | Distributed Tracing |
| Day 63 (Week 11) | Caching & Optimization | LRU Cache |
| Day 66 (Week 11) | Multi-Model Orchestration | Helm Charts |
| Day 72 (Week 12) | Evaluation & Testing | Capstone Review |

> Each Spring AI topic adds ~30 min to the paired day's session (extending from 2h to 2.5h on those days),
> OR can be done as a standalone bonus session on rest days.

---

## Dependencies

```xml
<!-- Add to nexcommerce-parent/pom.xml -->
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
</dependency>

<!-- For embeddings + vector store -->
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-pgvector-store-spring-boot-starter</artifactId>
</dependency>

<!-- For document loading (RAG) -->
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-tika-document-reader</artifactId>
</dependency>
```

> ⚠️ Spring AI requires an API key for the model provider (OpenAI, Ollama for local, etc.)
> For local/free development, use **Ollama** with Podman to run models locally.
