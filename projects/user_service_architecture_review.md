# 📝 NexCommerce Architecture Review: User Service

This document contains the structural review, questions, and detailed answers for the **User Service** implementation, prepared for your mock interview.

---

## 🔍 Architecture Q&A & Performance Analysis

### Q1: The Boot-Time Connection Failure
**Question 1.1:** Why will your database driver fail to bootstrap with `spring.datasource.url=postgresql://...`, and what is the standard format required by JDBC?  
**Answer:** JDBC drivers require the explicit `jdbc:` protocol prefix to determine which driver class to load from the classpath. Without `jdbc:postgresql://`, Spring Boot's datasource autoconfiguration cannot match the connection string to the PostgreSQL driver. The correct format is:
`jdbc:postgresql://localhost:5432/nexcommerce-user-service`

**Question 1.2:** What is the standard value for `spring.jpa.hibernate.ddl-auto` in development, and why will setting it to `true` cause property parsing issues?  
**Answer:** `ddl-auto` accepts specific keywords: `none`, `validate`, `update`, `create`, or `create-drop`. Setting it to `true` (a boolean) is invalid and will throw a boot-time configuration parsing error. In local development, the standard configuration is `update` (to update schemas incrementally) or `create-drop` (for unit tests).

---

### Q2: The Missing Transaction Boundary
**Question:** What runtime exception will Hibernate throw when `deleteByEmail(String email)` is called, and why does Hibernate demand a transactional boundary for custom data-modifying queries?  
**Answer:** Hibernate will throw `jakarta.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call`.  
By default, standard Spring Data JpaRepository CRUD methods (like `deleteById`) are annotated with `@Transactional` internally. However, custom modifying queries (like `deleteByEmail` or anything annotated with `@Modifying`) require an active write transaction on the calling service/method to maintain ACID properties.

---

### Q3: Redundant Persistence Operations
**Question:** If your service method is wrapped in a Spring `@Transactional` context, why is calling `userRepository.save(existing)` inside `updateUserDetailById` completely redundant?  
**Answer:** In a `@Transactional` context, any entity retrieved by the `EntityManager` (such as via `findById`) enters the **Managed (Persistent)** state. At the end of the transaction boundary, Hibernate automatically performs **dirty checking** (comparing the current entity state in memory to the snapshot loaded from the DB). If changes are detected, Hibernate automatically flushes the SQL `UPDATE` statement to the database during the commit phase. Calling `.save()` manually is redundant and adds execution overhead.

---

### Q4: Security Leak & DTO Shells
**Question 4.1:** What highly sensitive credential field inside your `User` entity will be exposed to the public JSON response if a client calls `GET /api/users`?  
**Answer:** The `passwordHash` field will be serialized directly into the JSON payload and sent to the client, exposing cryptographic hashes of user passwords to potential interception or compromise.

**Question 4.2:** Aside from security leaks, why does returning Hibernate-managed entities directly from REST controllers cause issues with lazy-loaded relationships or serialization?  
**Answer:**
1.  **LazyInitializationException:** If the entity contains lazy-loaded associations (e.g., `@OneToMany` orders), the Jackson JSON serializer will attempt to call the getter methods of those associations outside of the active database session, causing serialization crashes.
2.  **Infinite Recursion:** Bi-directional relationships (e.g., User -> Order -> User) will cause Jackson to loop infinitely during serialization, leading to a `StackOverflowError`.
3.  **Tightly Coupled API Contract:** Any database schema change (renaming columns) immediately breaks the public API contract with frontend clients. DTOs decouple database representation from public payloads.

---

### Q5: Index Redundancy
**Question:** Since you marked the `email` column as `unique = true`, what does your database engine (PostgreSQL) automatically do under the hood, and why is your explicit `@Index` declaration redundant?  
**Answer:** In relational databases like PostgreSQL, declaring a column as `UNIQUE` automatically creates a corresponding unique index (e.g., a B-Tree index) on that column to enforce the constraint. Specifying `@Index(name = "idx_users_email", columnList = "email")` inside `@Table` is redundant because the index is already implicitly built. Explicit `@Index` annotations are only needed for non-unique query filters, composite index lookups, or index renaming.
