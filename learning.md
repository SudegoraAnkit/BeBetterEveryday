# 🗺️ Full-Stack Engineering Learning Roadmap

> **Legend:** `[ ]` = Not started · `[~]` = In Progress · `[x]` = Completed
> **Competency:** `E` = Exposure · `GP` = Guided Practice · `IA` = Independent Application · `PM` = Production Mastery

---

## 1. 🟡 Core Java (Intermediate → Advanced)

### 1.1 Language Fundamentals
- [ ] Data types, operators, type casting, type promotion
- [ ] Control flow (if/else, switch expressions, loops, labeled breaks)
- [ ] Arrays and multi-dimensional arrays
- [ ] Strings — `String`, `StringBuilder`, `StringBuffer`, string pool internals
- [ ] Methods — varargs, method overloading rules, pass-by-value semantics
- [ ] Enums — methods, fields, abstract methods in enums, `EnumSet`, `EnumMap`
- [ ] Wrapper classes, autoboxing/unboxing pitfalls, caching (`Integer.valueOf`)

### 1.2 Object-Oriented Programming
- [ ] Classes, objects, constructors, constructor chaining
- [ ] Inheritance — method overriding rules, covariant return types
- [ ] Polymorphism — compile-time vs runtime, virtual method dispatch
- [ ] Abstraction — abstract classes vs interfaces, when to use which
- [ ] Encapsulation — access modifiers, immutable objects, defensive copying
- [ ] `final`, `static`, `this`, `super` — deep behavior in inheritance chains
- [ ] Inner classes — static nested, non-static inner, local, anonymous
- [ ] Sealed classes and interfaces (Java 17+)
- [ ] Records (Java 16+) — canonical constructors, compact constructors

### 1.3 Exception Handling
- [ ] Checked vs unchecked exceptions, `Error` hierarchy
- [ ] `try-with-resources` and `AutoCloseable` contract
- [ ] Custom exception hierarchies for domain modeling
- [ ] Exception handling anti-patterns (swallowing, generic catch, exception as flow control)
- [ ] Multi-catch, exception chaining, `suppressed` exceptions

### 1.4 Collections Framework (Deep Dive)
- [ ] `List` — `ArrayList` vs `LinkedList` internal structures, amortized resizing
- [ ] `Set` — `HashSet` (bucket/tree), `LinkedHashSet`, `TreeSet` (Red-Black tree)
- [ ] `Map` — `HashMap` internals (hashing, collision resolution, treeification at threshold 8)
- [ ] `Map` — `LinkedHashMap` (access-order for LRU), `TreeMap`, `ConcurrentHashMap`
- [ ] `Queue`/`Deque` — `PriorityQueue` (binary heap), `ArrayDeque`
- [ ] `Collections` utility — unmodifiable wrappers, synchronized wrappers, `Collections.singletonList`
- [ ] `Comparable` vs `Comparator` — natural ordering, multi-field sorting
- [ ] Fail-fast vs fail-safe iterators, `ConcurrentModificationException`

### 1.5 Generics
- [ ] Generic classes, methods, bounded type parameters (`extends`, `super`)
- [ ] Wildcards — `? extends T`, `? super T`, PECS principle
- [ ] Type erasure — what the compiler does, bridge methods
- [ ] Generic limitations — no primitive types, no `instanceof`, no generic arrays
- [ ] Recursive type bounds (`<T extends Comparable<T>>`)

### 1.6 Streams & Functional Programming
- [ ] Lambda expressions — functional interfaces, effectively final, closure behavior
- [ ] `java.util.function` — `Predicate`, `Function`, `Consumer`, `Supplier`, `BiFunction`
- [ ] Stream API — lazy evaluation, intermediate vs terminal operations
- [ ] Stream collectors — `groupingBy`, `partitioningBy`, `toMap`, custom collectors
- [ ] Parallel streams — `ForkJoinPool`, when to use, when they HURT performance
- [ ] `Optional` — correct usage, anti-patterns (`.get()` without check, `Optional` in fields)
- [ ] Method references — static, instance, constructor, bound vs unbound

### 1.7 Concurrency & Multithreading
- [ ] Thread lifecycle — `NEW`, `RUNNABLE`, `BLOCKED`, `WAITING`, `TIMED_WAITING`, `TERMINATED`
- [ ] `Runnable` vs `Callable` vs `Thread`
- [ ] `synchronized` — monitor locks, object-level vs class-level, reentrant locking
- [ ] `volatile` — visibility guarantee, memory fences, when it's NOT enough
- [ ] `java.util.concurrent.locks` — `ReentrantLock`, `ReadWriteLock`, `StampedLock`
- [ ] `ExecutorService` — thread pool types, `ThreadPoolExecutor` parameters, rejection policies
- [ ] `CompletableFuture` — chaining, combining, exception handling, async pipelines
- [ ] `CountDownLatch`, `CyclicBarrier`, `Semaphore`, `Phaser`
- [ ] `ConcurrentHashMap` — segment locking (pre-Java 8), CAS operations (Java 8+)
- [ ] `AtomicInteger`, `AtomicReference`, CAS (Compare-And-Swap) operations
- [ ] Java Memory Model — happens-before, visibility, ordering, data races
- [ ] Virtual Threads (Java 21+) — Project Loom, structured concurrency
- [ ] Deadlock detection, prevention, and avoidance strategies

### 1.8 JVM Internals
- [ ] JVM architecture — class loader, runtime data areas, execution engine
- [ ] Class loading — bootstrap, extension, application loaders, delegation model
- [ ] Memory model — heap (young/old gen), metaspace, stack, direct memory
- [ ] Garbage collection — Serial, Parallel, G1, ZGC, Shenandoah — when to pick which
- [ ] GC tuning — `-Xms`, `-Xmx`, `-XX:+UseG1GC`, GC logs analysis
- [ ] JIT compilation — C1/C2 compilers, tiered compilation, code cache
- [ ] JVM diagnostic tools — `jstack`, `jmap`, `jstat`, `jcmd`, `jfr` (Flight Recorder)
- [ ] Bytecode basics — `javap -c`, understanding method dispatch (`invokevirtual`, `invokeinterface`)

### 1.9 I/O & Serialization
- [ ] `java.io` — byte streams, character streams, buffered streams
- [ ] `java.nio` — `Path`, `Files`, `ByteBuffer`, channels, `WatchService`
- [ ] Serialization — `Serializable`, `serialVersionUID`, `transient`, security risks
- [ ] JSON processing — Jackson `ObjectMapper`, annotations, custom serializers/deserializers

### 1.10 Reflection & Annotations
- [ ] Reflection API — `Class`, `Method`, `Field`, `Constructor` access
- [ ] `setAccessible(true)` — security implications, module system restrictions (Java 9+)
- [ ] Custom annotations — `@Retention`, `@Target`, `@Inherited`, `@Repeatable`
- [ ] Annotation processing — compile-time vs runtime, how frameworks discover annotations
- [ ] Dynamic proxies — `java.lang.reflect.Proxy`, `InvocationHandler`

### 1.11 Java Module System (Java 9+)
- [ ] Module declarations — `module-info.java`, `requires`, `exports`, `opens`
- [ ] Strong encapsulation — what breaks, how frameworks use `--add-opens`
- [ ] Service provider interface (SPI) — `provides...with`, `uses`

### 1.12 Design Patterns
- [ ] Creational — Singleton (thread-safe), Factory Method, Abstract Factory, Builder, Prototype
- [ ] Structural — Adapter, Decorator, Proxy, Facade, Composite, Bridge
- [ ] Behavioral — Strategy, Observer, Template Method, Chain of Responsibility, Command, State
- [ ] Patterns in JDK — where Java itself uses these patterns
- [ ] Anti-patterns — God Object, Spaghetti Code, Golden Hammer, Premature Optimization

---

## 2. 🔧 Build Tools

### 2.1 Maven
- [ ] Project structure — `src/main/java`, `src/test/java`, `src/main/resources`
- [ ] `pom.xml` anatomy — `groupId`, `artifactId`, `version`, `packaging`
- [ ] Dependency management — scopes (`compile`, `provided`, `runtime`, `test`), transitive deps
- [ ] Dependency conflicts — `mvn dependency:tree`, exclusions, BOM imports
- [ ] Build lifecycle — `validate → compile → test → package → verify → install → deploy`
- [ ] Plugins — `maven-compiler-plugin`, `maven-surefire-plugin`, `maven-failsafe-plugin`, `spring-boot-maven-plugin`
- [ ] Profiles — environment-specific builds, activation strategies
- [ ] Multi-module projects — parent POM, `<modules>`, dependency version management
- [ ] Maven Wrapper — `mvnw`, ensuring consistent build tool versions
- [ ] Settings — `settings.xml`, repository mirrors, credentials

---

## 3. 🍃 Spring Ecosystem

### 3.1 Spring Core (IoC & DI)
- [ ] Inversion of Control — what it is, why it matters
- [ ] `ApplicationContext` — types, lifecycle, refresh process
- [ ] Bean definition — `@Component`, `@Service`, `@Repository`, `@Controller` stereotypes
- [ ] Dependency injection — constructor, setter, field injection — why constructor is preferred
- [ ] Bean scopes — `singleton`, `prototype`, `request`, `session` — lifecycle implications
- [ ] Bean lifecycle — `@PostConstruct`, `@PreDestroy`, `InitializingBean`, `DisposableBean`
- [ ] `@Configuration` and `@Bean` — programmatic bean registration, lite mode vs full mode
- [ ] `@Qualifier`, `@Primary` — resolving ambiguous dependencies
- [ ] `@Conditional` — `@ConditionalOnProperty`, `@ConditionalOnClass`, custom conditions
- [ ] `@Value` and `@ConfigurationProperties` — externalized configuration binding
- [ ] Profiles — `@Profile`, `spring.profiles.active`, profile-specific beans
- [ ] `@Lazy` — deferred initialization, proxy implications
- [ ] Circular dependency — detection, `@Lazy` resolution, why it's a design smell
- [ ] Spring Expression Language (SpEL) — `#{}` expressions in annotations and configs
- [ ] Event system — `ApplicationEvent`, `@EventListener`, `@Async` events

### 3.2 Spring AOP (Aspect-Oriented Programming)
- [ ] AOP concepts — aspect, advice, pointcut, join point, weaving
- [ ] Advice types — `@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around`
- [ ] Pointcut expressions — `execution()`, `within()`, `@annotation()`, combinations
- [ ] Proxy mechanism — JDK dynamic proxy vs CGLIB proxy, `@EnableAspectJAutoProxy`
- [ ] Self-invocation problem — why calling `this.method()` skips AOP, workarounds
- [ ] Real-world AOP — logging, security, transaction management, caching, retry

### 3.3 Spring Boot
- [ ] Auto-configuration — how `spring.factories` / `AutoConfiguration.imports` works
- [ ] `@SpringBootApplication` = `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`
- [ ] Starter dependencies — what they include, how to inspect (`mvn dependency:tree`)
- [ ] `application.yml` / `application.properties` — hierarchical config, relaxed binding
- [ ] Profile-specific config — `application-{profile}.yml`, activation, precedence order
- [ ] Embedded server — Tomcat, Jetty, Undertow — configuration, thread pool tuning
- [ ] Spring Boot Actuator — `/health`, `/info`, `/metrics`, `/env`, `/beans`, custom endpoints
- [ ] Actuator security — exposing endpoints selectively, securing with Spring Security
- [ ] Custom auto-configuration — creating your own starter with `@AutoConfiguration`
- [ ] `CommandLineRunner` and `ApplicationRunner` — startup tasks
- [ ] Spring Boot DevTools — auto-restart, LiveReload, remote debugging
- [ ] Graceful shutdown — `server.shutdown=graceful`, in-flight request handling
- [ ] Fat JAR / layered JAR — how Spring Boot packages, container image optimization
- [ ] Banner customization, logging configuration (`logback-spring.xml`)
- [ ] Error handling — `@ControllerAdvice`, `@ExceptionHandler`, `ProblemDetail` (RFC 7807)

### 3.4 Spring MVC
- [ ] DispatcherServlet — front controller pattern, request processing pipeline
- [ ] `@RestController` vs `@Controller` — response body semantics
- [ ] Request mapping — `@GetMapping`, `@PostMapping`, path variables, query params
- [ ] Request/response body — `@RequestBody`, `@ResponseBody`, `HttpMessageConverter`
- [ ] Validation — `@Valid`, `@Validated`, Bean Validation annotations, custom validators
- [ ] Exception handling — `@ExceptionHandler`, `@ControllerAdvice`, `ResponseEntityExceptionHandler`
- [ ] Content negotiation — JSON, XML, custom media types
- [ ] Filters and interceptors — `OncePerRequestFilter`, `HandlerInterceptor`, ordering
- [ ] CORS — `@CrossOrigin`, global CORS configuration, preflight requests
- [ ] File upload/download — `MultipartFile`, streaming large files
- [ ] `ResponseEntity` — status codes, headers, body construction
- [ ] HATEOAS basics — `RepresentationModel`, link building
- [ ] API versioning — URI, header, media type strategies

### 3.5 Spring Data JPA
- [ ] JPA basics — entities, `@Entity`, `@Table`, `@Id`, `@GeneratedValue` strategies
- [ ] Field mappings — `@Column`, `@Enumerated`, `@Temporal`, `@Lob`
- [ ] Relationships — `@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@OneToOne`
- [ ] Fetch types — `LAZY` vs `EAGER`, the N+1 problem, `@EntityGraph`
- [ ] Cascade types — `PERSIST`, `MERGE`, `REMOVE`, `ALL` — orphan removal
- [ ] Repository interfaces — `JpaRepository`, `CrudRepository`, `PagingAndSortingRepository`
- [ ] Query methods — derived queries, `@Query` (JPQL & native), `@Modifying`
- [ ] Pagination and sorting — `Pageable`, `Sort`, `Page` vs `Slice`
- [ ] Specifications — `Specification<T>`, dynamic query building, criteria API
- [ ] Projections — interface-based, class-based, dynamic projections
- [ ] Auditing — `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, `AuditorAware`
- [ ] Transaction management — `@Transactional`, propagation, isolation levels, rollback rules
- [ ] `EntityManager` — persistence context, first-level cache, flush modes
- [ ] Database migration — Flyway or Liquibase integration
- [ ] Connection pooling — HikariCP configuration, pool sizing, leak detection
- [ ] PostgreSQL-specific — `@Type` for JSONB, array columns, full-text search

### 3.6 Spring Data MongoDB
- [ ] MongoDB document mapping — `@Document`, `@Field`, `@Id`
- [ ] MongoRepository — CRUD, query methods, `@Query` with MongoDB query syntax
- [ ] MongoTemplate — advanced queries, aggregation pipeline, bulk operations
- [ ] Indexing — `@Indexed`, `@CompoundIndex`, TTL indexes
- [ ] Embedded documents vs references — `@DBRef`, manual references
- [ ] Document schema evolution — versioning, migration strategies
- [ ] Aggregation framework — `Aggregation`, `$match`, `$group`, `$project`, `$lookup`
- [ ] Change streams — real-time event processing
- [ ] MongoDB transactions — multi-document ACID (replica set required)

### 3.7 Spring Security
- [ ] Security filter chain — `SecurityFilterChain`, filter ordering
- [ ] Authentication — `AuthenticationManager`, `AuthenticationProvider`, `UserDetailsService`
- [ ] Password encoding — `BCryptPasswordEncoder`, `Argon2PasswordEncoder`
- [ ] Authorization — `@PreAuthorize`, `@PostAuthorize`, `@Secured`, method security
- [ ] Role-based access control (RBAC) — roles vs authorities
- [ ] JWT authentication — token generation, validation, stateless sessions
- [ ] OAuth2 Resource Server — bearer token validation, JWT decoder
- [ ] OAuth2 Client — authorization code flow, social login
- [ ] CSRF protection — when to enable/disable, token mechanics
- [ ] CORS with security — configuring `CorsConfigurationSource`
- [ ] Security testing — `@WithMockUser`, `@WithUserDetails`, `SecurityMockMvcRequestPostProcessors`
- [ ] Rate limiting and brute force protection
- [ ] Custom authentication filters

### 3.8 Spring Cloud
- [ ] Config Server — centralized configuration, Git/file backend, encryption
- [ ] Config Client — `bootstrap.yml`, `@RefreshScope`, bus refresh
- [ ] Service Discovery — Eureka Server/Client, service registration, health checks
- [ ] API Gateway — Spring Cloud Gateway, route definitions, filters, predicates
- [ ] Circuit Breaker — Resilience4j integration, `@CircuitBreaker`, fallback methods
- [ ] Resilience4j — retry, rate limiter, bulkhead, time limiter
- [ ] Load balancing — Spring Cloud LoadBalancer, `@LoadBalanced RestTemplate`
- [ ] OpenFeign — declarative REST clients, `@FeignClient`, error handling
- [ ] Distributed configuration refresh — Spring Cloud Bus
- [ ] Sleuth / Micrometer Tracing — distributed tracing, trace propagation, span management

### 3.9 Spring Modulith
- [ ] What is Modulith — modular monolith architecture, when to use vs microservices
- [ ] Module structure — package-based modules, `@ApplicationModule`
- [ ] Module boundaries — API exposure, internal encapsulation
- [ ] Module verification — `ApplicationModules.of()`, architecture tests
- [ ] Inter-module events — `ApplicationModuleListener`, `@Async` events
- [ ] Module documentation — auto-generated module diagrams
- [ ] Observability — module-level metrics and tracing
- [ ] Transition strategy — evolving a modulith into microservices

---

## 4. 🗄️ Databases

### 4.1 PostgreSQL
- [ ] SQL fundamentals — DDL, DML, joins, subqueries, CTEs (Common Table Expressions)
- [ ] Indexing — B-tree, hash, GIN, GiST — when to use which
- [ ] `EXPLAIN ANALYZE` — reading query plans, identifying seq scans, index usage
- [ ] Transactions — ACID, isolation levels (`READ COMMITTED`, `REPEATABLE READ`, `SERIALIZABLE`)
- [ ] Locking — row-level, table-level, advisory locks, deadlock detection
- [ ] Constraints — primary key, foreign key, unique, check, exclusion
- [ ] Views and materialized views — refresh strategies, query performance
- [ ] Stored procedures and functions — PL/pgSQL basics
- [ ] JSONB — storage, indexing, querying, operators (`->`, `->>`, `@>`)
- [ ] Full-text search — `tsvector`, `tsquery`, `GIN` index for text search
- [ ] Partitioning — range, list, hash partitioning strategies
- [ ] Connection management — `pg_stat_activity`, connection limits, `pgbouncer` concepts
- [ ] Backup and restore — `pg_dump`, `pg_restore`, point-in-time recovery concepts
- [ ] Performance tuning — `shared_buffers`, `work_mem`, `effective_cache_size`

### 4.2 MongoDB
- [ ] Document model — BSON, document size limits, embedded vs referenced design
- [ ] CRUD operations — `insertOne`, `find`, `updateOne`, `deleteOne`, operators
- [ ] Query operators — comparison, logical, element, array operators
- [ ] Aggregation pipeline — stages, expressions, `$lookup` for joins
- [ ] Indexing — single field, compound, multikey, text, wildcard, partial indexes
- [ ] Schema design patterns — bucket, outlier, subset, extended reference
- [ ] Replica sets — primary/secondary, read preferences, write concerns
- [ ] Sharding concepts — shard keys, chunks, balancer
- [ ] Monitoring — `db.serverStatus()`, `db.currentOp()`, slow query log

---

## 5. 📨 Messaging Systems

### 5.1 Apache Kafka
- [ ] Core concepts — topics, partitions, offsets, consumer groups, brokers
- [ ] Producer API — `KafkaProducer`, `ProducerRecord`, acknowledgments (`acks`)
- [ ] Consumer API — `KafkaConsumer`, polling, commit strategies (auto vs manual)
- [ ] Partitioning — partition assignment, custom partitioners, key-based ordering
- [ ] Consumer groups — rebalancing, group coordinator, `session.timeout.ms`
- [ ] Delivery guarantees — at-most-once, at-least-once, exactly-once (idempotent producer + transactions)
- [ ] Spring Kafka — `@KafkaListener`, `KafkaTemplate`, `ConsumerFactory`, `ProducerFactory`
- [ ] Schema registry concepts — Avro, schema evolution, compatibility modes
- [ ] Error handling — Dead Letter Topics (DLT), retry topics, `DefaultErrorHandler`
- [ ] Kafka Streams basics — stateless/stateful transformations, KTable, windowing
- [ ] Monitoring — consumer lag, `kafka-consumer-groups.sh`, JMX metrics
- [ ] Production tuning — `batch.size`, `linger.ms`, `buffer.memory`, compression

### 5.2 RabbitMQ
- [ ] Core concepts — exchanges, queues, bindings, routing keys, virtual hosts
- [ ] Exchange types — direct, topic, fanout, headers
- [ ] Message acknowledgment — manual ack, nack, reject, prefetch count
- [ ] Durability — durable queues, persistent messages, publisher confirms
- [ ] Dead Letter Exchange (DLX) — routing failed messages, retry patterns
- [ ] Spring AMQP — `RabbitTemplate`, `@RabbitListener`, `MessageConverter`
- [ ] Connection and channel management — connection pooling, channel caching
- [ ] TTL, priority queues, delayed messages
- [ ] Clustering and high availability — mirrored queues, quorum queues
- [ ] Monitoring — Management UI, `rabbitmqctl`, Prometheus plugin
- [ ] Kafka vs RabbitMQ — when to choose which, architectural trade-offs

---

## 6. 🐳 Containerization & Orchestration

### 6.1 Podman (Container Runtime)
- [ ] Podman basics — `podman run`, `podman build`, `podman ps`, `podman logs`
- [ ] Podman vs Docker — rootless containers, daemonless architecture, compatibility
- [ ] Containerfile/Dockerfile — `FROM`, `COPY`, `RUN`, `ENTRYPOINT`, `CMD`, multi-stage builds
- [ ] Image layers — layer caching, minimizing image size, `.containerignore`
- [ ] Networking — `podman network create`, container-to-container communication
- [ ] Volumes — bind mounts, named volumes, data persistence
- [ ] Podman Compose — `podman-compose` for multi-container apps
- [ ] Building Spring Boot images — layered JARs, Jib, Buildpacks
- [ ] Health checks — `HEALTHCHECK` instruction, readiness vs liveness
- [ ] Container security — rootless mode, user namespaces, seccomp profiles

### 6.2 Helm (Kubernetes Package Manager)
- [ ] Helm concepts — charts, releases, values, templates
- [ ] Chart structure — `Chart.yaml`, `values.yaml`, `templates/` directory
- [ ] Template syntax — Go templates, `{{ .Values }}`, `{{ include }}`, `{{ if }}`
- [ ] Built-in objects — `.Release`, `.Chart`, `.Values`, `.Capabilities`
- [ ] Values files — default values, overrides, `--set` flags
- [ ] Chart dependencies — `requirements.yaml`, sub-charts
- [ ] Helm commands — `install`, `upgrade`, `rollback`, `uninstall`, `template`, `lint`
- [ ] Helm hooks — pre-install, post-install, pre-upgrade, jobs
- [ ] Chart repositories — creating, publishing, pulling charts
- [ ] Helmfile — managing multiple releases declaratively

### 6.3 Kubernetes Basics
- [ ] Core objects — Pod, Deployment, Service, ConfigMap, Secret
- [ ] Pod lifecycle — init containers, readiness/liveness probes, restart policies
- [ ] Deployments — rolling updates, rollback, replicas, strategy
- [ ] Services — ClusterIP, NodePort, LoadBalancer, Ingress
- [ ] ConfigMaps and Secrets — environment variables, volume mounts
- [ ] Resource management — requests, limits, QoS classes
- [ ] Namespaces — isolation, resource quotas, `LimitRange`
- [ ] `kubectl` essentials — `get`, `describe`, `logs`, `exec`, `port-forward`, `apply`
- [ ] YAML manifests — writing deployments, services, ingress from scratch

---

## 7. 🏛️ Architecture & Design

### 7.1 REST API Design
- [ ] REST constraints — stateless, cacheable, uniform interface, layered system
- [ ] Resource naming — nouns not verbs, plural vs singular, nesting
- [ ] HTTP methods — `GET`, `POST`, `PUT`, `PATCH`, `DELETE` — idempotency
- [ ] Status codes — 2xx, 3xx, 4xx, 5xx — when to use which
- [ ] Pagination — offset-based, cursor-based, HATEOAS links
- [ ] Versioning — URI, header, media type, query parameter
- [ ] Error responses — RFC 7807 Problem Detail, consistent error structure
- [ ] API documentation — OpenAPI/Swagger, SpringDoc integration
- [ ] Rate limiting — token bucket, sliding window, response headers

### 7.2 Microservices Patterns
- [ ] Decomposition — domain-driven, by business capability, by subdomain
- [ ] API Gateway pattern — routing, authentication, rate limiting, aggregation
- [ ] Service communication — synchronous (REST, gRPC) vs asynchronous (events)
- [ ] Circuit breaker pattern — states (closed, open, half-open), failure thresholds
- [ ] Retry pattern — exponential backoff, jitter, max retries
- [ ] Bulkhead pattern — thread pool isolation, semaphore isolation
- [ ] Saga pattern — choreography vs orchestration, compensation
- [ ] CQRS — Command Query Responsibility Segregation, separate read/write models
- [ ] Event sourcing — event store, projections, snapshots
- [ ] Strangler fig pattern — incremental migration from monolith
- [ ] Sidecar pattern — cross-cutting concerns, service mesh concepts
- [ ] Database per service — data ownership, eventual consistency

### 7.3 Domain-Driven Design (DDD)
- [ ] Strategic DDD — bounded contexts, ubiquitous language, context maps
- [ ] Tactical DDD — entities, value objects, aggregates, aggregate roots
- [ ] Domain events — publishing, subscribing, event-driven architecture
- [ ] Repositories — DDD repository pattern vs Spring Data Repository
- [ ] Application services vs domain services — responsibility separation
- [ ] Anti-corruption layer — translating between bounded contexts

### 7.4 Event-Driven Architecture
- [ ] Event types — domain events, integration events, notification events
- [ ] Event choreography vs orchestration — trade-offs
- [ ] Event schemas — versioning, backward/forward compatibility
- [ ] Eventual consistency — accepting and handling it
- [ ] Outbox pattern — reliable event publishing, polling publisher, CDC
- [ ] Idempotency — ensuring safe event reprocessing, idempotency keys

---

## 8. 🧪 Testing

### 8.1 Unit Testing
- [ ] JUnit 5 — `@Test`, `@BeforeEach`, `@AfterEach`, `@DisplayName`, `@Nested`
- [ ] Assertions — `assertEquals`, `assertThrows`, `assertAll`, `assertTimeout`
- [ ] Parameterized tests — `@ParameterizedTest`, `@ValueSource`, `@CsvSource`, `@MethodSource`
- [ ] Test lifecycle — `@TestInstance`, execution order, conditional execution
- [ ] Mockito — `@Mock`, `@InjectMocks`, `when().thenReturn()`, `verify()`
- [ ] Mockito advanced — `ArgumentCaptor`, `@Spy`, `doAnswer`, stubbing void methods
- [ ] Testing anti-patterns — testing implementation not behavior, brittle mocks

### 8.2 Integration Testing
- [ ] Spring Boot Test — `@SpringBootTest`, `@WebMvcTest`, `@DataJpaTest`, `@DataMongoTest`
- [ ] Test slicing — loading only relevant context, `@MockBean`, `@SpyBean`
- [ ] `MockMvc` — testing controllers without server, request builders, result matchers
- [ ] `WebTestClient` — reactive endpoint testing
- [ ] `TestRestTemplate` — full server integration tests
- [ ] Test configuration — `@TestConfiguration`, `@ActiveProfiles("test")`
- [ ] Database testing — `@Sql`, `@DirtiesContext`, test transactions
- [ ] Testcontainers — spinning up PostgreSQL, MongoDB, Kafka in tests (via Podman)

### 8.3 Advanced Testing
- [ ] Contract testing — Spring Cloud Contract, consumer-driven contracts
- [ ] Performance testing — JMH (Java Microbenchmark Harness)
- [ ] Architecture testing — ArchUnit, enforcing package dependencies
- [ ] Mutation testing — PIT, measuring test effectiveness
- [ ] End-to-end testing strategy — test pyramid, cost of different test types

---

## 9. 📊 Observability & Monitoring

### 9.1 Logging
- [ ] SLF4J + Logback — configuration, log levels, appenders
- [ ] Structured logging — JSON format, MDC (Mapped Diagnostic Context)
- [ ] Correlation IDs — tracing requests across services
- [ ] Log aggregation concepts — ELK stack (Elasticsearch, Logstash, Kibana)
- [ ] Logging best practices — what to log, what NOT to log, PII concerns

### 9.2 Metrics & Monitoring
- [ ] Micrometer — `Counter`, `Gauge`, `Timer`, `DistributionSummary`
- [ ] Spring Boot Actuator metrics — JVM, HTTP, custom business metrics
- [ ] Prometheus — pull-based metrics, PromQL basics, alerting rules
- [ ] Grafana — dashboard creation, visualization, alerting
- [ ] Application health monitoring — health indicators, readiness groups

### 9.3 Distributed Tracing
- [ ] Trace and span concepts — trace ID, span ID, parent span
- [ ] Micrometer Tracing — automatic instrumentation, baggage propagation
- [ ] Zipkin / Jaeger — trace visualization, latency analysis
- [ ] Tracing across async boundaries — Kafka, RabbitMQ message tracing

---

## 10. 🚀 DevOps & CI/CD

### 10.1 CI/CD Concepts
- [ ] Continuous Integration — build on every commit, fast feedback
- [ ] Continuous Delivery vs Deployment — manual vs automatic release
- [ ] Pipeline stages — build, test, static analysis, package, deploy
- [ ] GitHub Actions / GitLab CI basics — workflow YAML, triggers, jobs
- [ ] Artifact management — Maven Central, private registries, container registries

### 10.2 Deployment Strategies
- [ ] Blue-green deployment — zero-downtime, instant rollback
- [ ] Canary deployment — gradual traffic shifting, monitoring
- [ ] Rolling update — Kubernetes rolling strategy, max surge, max unavailable
- [ ] Feature flags — trunk-based development, gradual rollout
- [ ] Database migration in CI/CD — Flyway/Liquibase in pipelines, rollback strategies

### 10.3 Infrastructure as Code
- [ ] Infrastructure concepts — immutable infrastructure, cattle vs pets
- [ ] Kubernetes manifests — declarative deployment, GitOps concepts
- [ ] Helm for deployment — chart customization, environment-specific values
- [ ] Secret management — Kubernetes secrets, sealed secrets, vault concepts

---

## 11. 🔒 Security

### 11.1 Application Security
- [ ] OWASP Top 10 — injection, broken auth, XSS, CSRF, SSRF
- [ ] Input validation — server-side validation, sanitization
- [ ] SQL injection prevention — parameterized queries, JPA protection
- [ ] XSS prevention — output encoding, Content Security Policy headers
- [ ] Authentication — session-based vs token-based, JWT structure and validation
- [ ] Authorization — RBAC, ABAC, resource-level permissions
- [ ] Secrets management — never hardcode, environment variables, vaults
- [ ] HTTPS/TLS — certificate management, HSTS, secure cookies
- [ ] Dependency vulnerability scanning — OWASP Dependency Check, Snyk concepts

---

## 12. 📐 DSA & Problem Solving (Beginner → Advanced)

> **Learning path:** Foundations → Build from Scratch → Core Algorithms → Problem Patterns → Advanced
> **For each data structure:** Understand it → Build it in raw Java → Solve problems using it
> **For each algorithm:** Trace it by hand → Code it → Analyze complexity → Recognize when to apply it

---

### Phase 1: Foundations (Do This FIRST)

#### 12.1 Complexity Analysis
- [ ] Big-O notation — O(1), O(log n), O(n), O(n log n), O(n²), O(2ⁿ), O(n!)
- [ ] Big-Omega (Ω) and Big-Theta (Θ) — best case, average case, worst case
- [ ] How to count operations — loops, nested loops, recursive calls
- [ ] Space complexity — auxiliary space vs total space, stack frames in recursion
- [ ] Amortized analysis — why `ArrayList.add()` is O(1) amortized despite resizing
- [ ] Common traps — O(n) string concatenation in loops, hidden O(n) in `list.contains()`
- [ ] **Practice:** Analyze the time/space complexity of 10 code snippets without running them

#### 12.2 Recursion (The Backbone of DSA)
- [ ] What is recursion — base case, recursive case, call stack visualization
- [ ] Stack frames — how each call gets its own variable scope, stack overflow risk
- [ ] Linear recursion — factorial, fibonacci, sum of array
- [ ] Tail recursion — what it is, why Java doesn't optimize it (no TCO)
- [ ] Recursion vs iteration — converting between them, when recursion is cleaner
- [ ] Recursive thinking — how to decompose a problem into smaller subproblems
- [ ] **Build:** Write recursive versions of: power(x, n), reverse string, palindrome check, binary search
- [ ] **Practice:** Print all subsequences of a string, Tower of Hanoi, count paths in grid

---

### Phase 2: Build Data Structures from Scratch (Custom Java Implementation)

> **Rule:** Do NOT use `java.util` collections. Build each from raw arrays/nodes. This is how you truly understand them.

#### 12.3 Arrays (The Foundation)
- [ ] How arrays work in memory — contiguous allocation, index-based access O(1)
- [ ] Static arrays — fixed size, declaration, initialization, bounds checking
- [ ] Array operations — insert (shift right), delete (shift left), search — understand the O(n) cost
- [ ] **Build: `DynamicArray<T>`** — your own ArrayList from scratch:
  - Internal `Object[]` with initial capacity 10
  - `add(T)` — append, auto-resize (double capacity) when full
  - `add(int index, T)` — insert at position, shift elements right
  - `get(int index)` — bounds check + return
  - `remove(int index)` — shift elements left, nullify last
  - `size()`, `isEmpty()`, `contains(T)`
  - Understand: why doubling gives O(1) amortized, why 1.5x (ArrayList) vs 2x (Vector)
- [ ] 2D arrays — matrix representation, row-major order, spiral traversal
- [ ] **Practice problems:**
  - Rotate array by K positions
  - Find missing number in 1..n
  - Move zeroes to end (in-place)
  - Kadane's algorithm (maximum subarray sum)
  - Merge two sorted arrays (without extra space)
  - Dutch National Flag (sort 0s, 1s, 2s)

#### 12.4 Strings
- [ ] String immutability — why `String` is immutable, string pool, `==` vs `.equals()`
- [ ] `char[]` manipulation — when to convert for in-place modification
- [ ] StringBuilder internals — mutable, amortized O(1) append, capacity doubling
- [ ] **Key operations to implement manually:**
  - Reverse a string (in-place on char[])
  - Check palindrome
  - Count character frequencies (using `int[26]` or `int[128]`)
  - String compression ("aabcccaaa" → "a2b1c3a3")
  - Anagram check (sort or frequency array)
- [ ] **Practice problems:**
  - Longest substring without repeating characters
  - Valid anagram
  - Group anagrams
  - Longest palindromic substring
  - String to integer (atoi) — handle edge cases

#### 12.5 Linked Lists
- [ ] Singly linked list — node structure (`data` + `next` pointer), head reference
- [ ] Why linked lists — O(1) insert/delete at head vs O(n) for arrays, but O(n) access
- [ ] Memory layout — non-contiguous, each node is a heap object (16 bytes header + fields)
- [ ] **Build: `SinglyLinkedList<T>`** from scratch:
  - Inner class `Node<T>` with `data` and `next`
  - `addFirst(T)`, `addLast(T)`, `add(int index, T)`
  - `removeFirst()`, `removeLast()`, `remove(int index)`
  - `get(int index)`, `contains(T)`, `size()`
  - `reverse()` — iterative (3-pointer technique)
  - `printList()` — traverse and print
- [ ] **Build: `DoublyLinkedList<T>`** from scratch:
  - `Node<T>` with `data`, `next`, `prev`
  - Sentinel head/tail nodes (simplifies edge cases)
  - `addFirst()`, `addLast()`, `remove(Node)` — all O(1)
  - Used internally by: `LinkedHashMap`, `LRU Cache`
- [ ] Circular linked list — last node points to head, detecting the join point
- [ ] **Practice problems:**
  - Reverse a linked list (iterative + recursive)
  - Detect cycle — Floyd's tortoise and hare (slow/fast pointer)
  - Find cycle start node — mathematical proof of why it works
  - Merge two sorted linked lists
  - Remove Nth node from end (two-pointer, one-pass)
  - Find middle node (slow/fast pointer)
  - Check if palindrome linked list
  - Add two numbers represented as linked lists
  - Intersection of two linked lists (length difference technique)
  - Flatten a multilevel doubly linked list

#### 12.6 Stacks
- [ ] Stack concept — LIFO (Last In, First Out), push, pop, peek
- [ ] Real-world stacks — JVM call stack, browser back button, undo/redo
- [ ] **Build: `ArrayStack<T>`** — stack using an array:
  - Internal `Object[]` with `top` index
  - `push(T)`, `pop()`, `peek()`, `isEmpty()`, `size()`
  - Auto-resize when full
- [ ] **Build: `LinkedStack<T>`** — stack using linked list:
  - Push/pop at head — both O(1)
  - No capacity limit, but more memory per element (node overhead)
- [ ] **When to use stacks:**
  - Matching parentheses / brackets
  - Expression evaluation (postfix/infix)
  - Undo operations
  - DFS (iterative using explicit stack)
- [ ] **Practice problems:**
  - Valid parentheses — `()[]{}` matching
  - Min stack — O(1) push, pop, AND getMin
  - Evaluate reverse polish notation (postfix)
  - Daily temperatures — next greater element (monotonic stack)
  - Largest rectangle in histogram (monotonic stack — classic hard)
  - Implement queue using two stacks
  - Decode string — `"3[a2[bc]]"` → `"abcbcabcbcabcbc"`
  - Trapping rain water (stack approach)

#### 12.7 Queues & Deques
- [ ] Queue concept — FIFO (First In, First Out), enqueue, dequeue, peek
- [ ] Real-world queues — task scheduling, BFS, message queues (Kafka, RabbitMQ)
- [ ] **Build: `CircularArrayQueue<T>`** from scratch:
  - Internal `Object[]` with `front`, `rear`, `size`
  - Circular indexing: `rear = (rear + 1) % capacity`
  - `enqueue(T)`, `dequeue()`, `peek()`, `isEmpty()`, `isFull()`
  - Auto-resize when full (copy to new array, reset front/rear)
- [ ] **Build: `LinkedQueue<T>`** — using linked list with head and tail:
  - `enqueue()` at tail, `dequeue()` at head — both O(1)
- [ ] **Deque (Double-Ended Queue):**
  - Add/remove from both front and rear — O(1)
  - Java's `ArrayDeque` — circular array, faster than `LinkedList` for queue/stack
- [ ] **Priority Queue (preview — detailed in Heaps):**
  - Not FIFO — highest priority element comes out first
  - Backed by a heap
- [ ] **Practice problems:**
  - Implement stack using two queues
  - Sliding window maximum (deque — monotonic deque technique)
  - Number of recent calls (queue with time window)
  - Rotting oranges (multi-source BFS using queue)
  - Design circular queue

#### 12.8 Hash Maps & Hash Sets
- [ ] Hashing concept — hash function maps key → index, O(1) average lookup
- [ ] Hash functions — `hashCode()` in Java, why `31` is used, distribution quality
- [ ] Collision handling — **chaining** (linked list per bucket) vs **open addressing** (linear/quadratic probing)
- [ ] Load factor — ratio of entries to buckets, Java's default 0.75, why it matters
- [ ] Rehashing — when load factor exceeded, double bucket array, re-insert all entries
- [ ] **Build: `MyHashMap<K, V>`** from scratch (chaining):
  - Internal `Node<K,V>[] buckets` array
  - `hash(key)` — `key.hashCode() & (capacity - 1)` (bitwise AND for power-of-2 capacity)
  - `put(K, V)` — hash → find bucket → traverse chain → insert or update
  - `get(K)` — hash → find bucket → traverse chain → return value
  - `remove(K)` — hash → find bucket → unlink node from chain
  - `containsKey(K)`, `size()`, `keySet()`
  - Resize when load factor > 0.75
- [ ] **Build: `MyHashSet<T>`** — a `MyHashMap<T, Boolean>` wrapper
- [ ] Java's `HashMap` internals:
  - Treeification — when chain length > 8, converts to Red-Black tree (O(log n) worst case)
  - De-treeification — when chain shrinks below 6, converts back to linked list
  - Why capacity is always power of 2 — enables bitwise AND instead of modulo
- [ ] `equals()` and `hashCode()` contract — why both must be overridden together
- [ ] **Practice problems:**
  - Two Sum (hash map for complement lookup)
  - Contains Duplicate
  - Group Anagrams (sorted string as key)
  - Longest Consecutive Sequence (hash set, O(n))
  - Subarray Sum Equals K (prefix sum + hash map)
  - Valid Sudoku
  - LRU Cache (HashMap + DoublyLinkedList — **must-know design problem**)
  - First non-repeating character

#### 12.9 Trees
- [ ] Tree terminology — root, parent, child, leaf, height, depth, level, subtree
- [ ] Binary tree — each node has at most 2 children
- [ ] **Build: `BinaryTree<T>`** from scratch:
  - Inner class `Node<T>` with `data`, `left`, `right`
  - Traversals — implement ALL four:
    - **Inorder** (Left → Root → Right) — gives sorted order for BST
    - **Preorder** (Root → Left → Right) — useful for serialization/copying
    - **Postorder** (Left → Right → Root) — useful for deletion/cleanup
    - **Level-order** (BFS using queue) — level by level
  - Implement each traversal both **recursively** and **iteratively** (using stack/queue)
- [ ] **Build: `BinarySearchTree<T extends Comparable<T>>`** from scratch:
  - `insert(T)` — recursive, maintain BST property
  - `search(T)` — O(log n) average, O(n) worst (degenerate/skewed tree)
  - `delete(T)` — three cases: leaf, one child, two children (inorder successor)
  - `findMin()`, `findMax()` — leftmost and rightmost nodes
  - `height()`, `size()`, `isValidBST()` — recursive computation
  - Inorder traversal gives sorted output — prove it
- [ ] Balanced BSTs — why balance matters (O(log n) vs O(n)):
  - AVL trees — balance factor, rotations (LL, RR, LR, RL)
  - Red-Black trees — coloring rules, Java's `TreeMap`/`TreeSet` use this
  - Understand the concept — don't need to implement from scratch for interviews
- [ ] **Practice problems:**
  - Maximum depth of binary tree
  - Invert/mirror a binary tree
  - Check if two trees are identical
  - Validate BST (inorder check or min/max range)
  - Lowest Common Ancestor (BST and generic binary tree)
  - Level order traversal → zigzag level order
  - Serialize and deserialize binary tree
  - Diameter of binary tree
  - Path sum / all root-to-leaf paths
  - Construct binary tree from inorder + preorder/postorder
  - Kth smallest element in BST
  - Binary tree right side view
  - Count complete tree nodes (O(log²n))

#### 12.10 Heaps & Priority Queues
- [ ] Heap concept — complete binary tree with heap property (max-heap or min-heap)
- [ ] Array representation — parent at `i`, left child at `2i+1`, right child at `2i+2`
- [ ] **Build: `MinHeap<T extends Comparable<T>>`** from scratch:
  - Internal `Object[]` array representation
  - `insert(T)` — add at end, **sift up** (bubble up) — O(log n)
  - `extractMin()` — remove root, move last to root, **sift down** (heapify down) — O(log n)
  - `peek()` — return root without removing — O(1)
  - `siftUp(int index)` — swap with parent while smaller
  - `siftDown(int index)` — swap with smallest child while larger
  - `heapify(T[])` — build heap from array in O(n) using bottom-up sift-down
- [ ] **Build: `MaxHeap<T>`** — same but reverse comparison
- [ ] Java's `PriorityQueue` — min-heap by default, custom `Comparator` for max-heap
- [ ] Heap sort — build max-heap, repeatedly extract max — O(n log n), in-place
- [ ] **When to think "heap":**
  - "Find the Kth largest/smallest"
  - "Top K frequent elements"
  - "Merge K sorted things"
  - "Median of a stream"
- [ ] **Practice problems:**
  - Kth largest element in array (min-heap of size K, or QuickSelect)
  - Top K frequent elements
  - Merge K sorted linked lists (min-heap of K nodes)
  - Find median from data stream (two heaps: max-heap + min-heap)
  - Sort a nearly sorted (K-sorted) array
  - Last stone weight
  - K closest points to origin
  - Task scheduler (greedy + max-heap)
  - Reorganize string (max-heap for most frequent char)

#### 12.11 Graphs
- [ ] Graph terminology — vertex, edge, directed/undirected, weighted/unweighted, degree
- [ ] Graph representations:
  - **Adjacency matrix** — `boolean[V][V]`, O(V²) space, O(1) edge check
  - **Adjacency list** — `List<List<Integer>>` or `Map<Integer, List<Integer>>`, O(V+E) space
  - When to use which — dense vs sparse graphs
- [ ] **Build: `Graph`** from scratch (adjacency list):
  - `addVertex(int v)`, `addEdge(int u, int v)` (directed), `addEdge` (undirected)
  - `getNeighbors(int v)`, `hasEdge(int u, int v)`
  - `printGraph()`
- [ ] **Graph Traversals — implement both:**
  - **BFS (Breadth-First Search):**
    - Queue-based, level-by-level exploration
    - Finds shortest path in unweighted graphs
    - `visited[]` array to prevent revisiting
    - **Build:** BFS from source, return level-order visit list
  - **DFS (Depth-First Search):**
    - Stack-based (recursive or iterative)
    - Explores as deep as possible before backtracking
    - **Build:** DFS from source, return visit order
    - DFS for cycle detection (directed: back edge, undirected: parent check)
- [ ] Connected components — BFS/DFS on all unvisited nodes, count components
- [ ] **Practice problems:**
  - Number of islands (2D grid BFS/DFS)
  - Clone graph (BFS/DFS + HashMap)
  - Course schedule (cycle detection in directed graph — topological sort)
  - Course schedule II (topological ordering)
  - Rotting oranges (multi-source BFS)
  - Word ladder (BFS, each word is a node)
  - Pacific Atlantic water flow (reverse BFS/DFS from edges)
  - Number of provinces (union-find or DFS)
  - Graph valid tree (connected + no cycle + V-1 edges)
  - Surrounded regions (border DFS)

#### 12.12 Tries (Prefix Trees)
- [ ] Trie concept — tree where each node represents a character, paths form words
- [ ] **Build: `Trie`** from scratch:
  - Inner class `TrieNode` with `TrieNode[26] children` and `boolean isEndOfWord`
  - `insert(String word)` — create nodes along the path, mark end
  - `search(String word)` — traverse, check `isEndOfWord`
  - `startsWith(String prefix)` — traverse, return true if prefix path exists
  - `delete(String word)` — recursive, prune unnecessary nodes
- [ ] Time complexity — O(L) for insert/search where L = word length
- [ ] Space tradeoff — 26 pointers per node (wasteful for sparse data) vs HashMap children
- [ ] **Practice problems:**
  - Implement Trie (LeetCode 208 — classic)
  - Word Search II (Trie + backtracking on grid)
  - Design Add and Search Words (Trie + DFS with `.` wildcard)
  - Longest common prefix
  - Auto-complete system (Trie + DFS to collect all words under prefix)

---

### Phase 3: Core Algorithms (Master Each Family)

#### 12.13 Sorting Algorithms
- [ ] **Implement each in Java, trace by hand, analyze complexity:**

| Algorithm | Time (Best/Avg/Worst) | Space | Stable? | When to Use |
|-----------|----------------------|-------|---------|-------------|
| Bubble Sort | O(n)/O(n²)/O(n²) | O(1) | Yes | Never in prod. Learning only. |
| Selection Sort | O(n²)/O(n²)/O(n²) | O(1) | No | Never in prod. Learning only. |
| Insertion Sort | O(n)/O(n²)/O(n²) | O(1) | Yes | Small arrays, nearly sorted data. |
| Merge Sort | O(n log n)/O(n log n)/O(n log n) | O(n) | Yes | When stability needed, linked lists. |
| Quick Sort | O(n log n)/O(n log n)/O(n²) | O(log n) | No | General purpose, cache-friendly. |
| Heap Sort | O(n log n)/O(n log n)/O(n log n) | O(1) | No | When O(1) space needed. |
| Counting Sort | O(n+k)/O(n+k)/O(n+k) | O(k) | Yes | Small integer range (k). |
| Radix Sort | O(d·(n+k))/same/same | O(n+k) | Yes | Fixed-length integers/strings. |
| Bucket Sort | O(n+k)/O(n+k)/O(n²) | O(n+k) | Yes | Uniform distribution. |

- [ ] **Deep implementations:**
  - Merge Sort — divide array, recursively sort halves, merge — understand the merge step
  - Quick Sort — partition (Lomuto vs Hoare), pivot selection, why random pivot prevents O(n²)
  - Quick Select — find Kth element in O(n) average without fully sorting
  - Counting Sort — when values are in a small range, count occurrences
- [ ] Java's `Arrays.sort()` internals:
  - Primitives: Dual-Pivot Quicksort (Vladimir Yaroslavskiy)
  - Objects: TimSort (merge sort + insertion sort hybrid, exploits natural runs)
  - Why different? Objects need stability, primitives don't.
- [ ] **Practice problems:**
  - Sort an array (implement each algorithm)
  - Sort Colors / Dutch National Flag (3-way partition)
  - Merge Intervals
  - Meeting Rooms I & II (sort + sweep line)
  - Largest Number (custom comparator sorting)
  - Kth Largest Element (QuickSelect)

#### 12.14 Searching Algorithms
- [ ] Linear search — O(n), when to use (unsorted, small data)
- [ ] **Binary search — the most important algorithm to master:**
  - Classic binary search — sorted array, find target
  - **Build:** Implement with `while (lo <= hi)` AND `while (lo < hi)` — understand the difference
  - Lower bound — first occurrence of target (leftmost)
  - Upper bound — last occurrence of target (rightmost)
  - Binary search on answer space — "what's the minimum X such that condition(X) is true?"
  - **Mental model:** Binary search works whenever you have a monotonic predicate — left side is false, right side is true (or vice versa). Find the boundary.
- [ ] **Practice problems:**
  - Search in rotated sorted array
  - Find first and last position in sorted array
  - Search a 2D matrix
  - Find peak element
  - Sqrt(x) — binary search on answer
  - Koko eating bananas — binary search on speed
  - Minimum in rotated sorted array
  - Median of two sorted arrays (hard — binary search on partition)
  - Capacity to ship packages within D days (binary search on answer)
  - Split array largest sum (binary search on answer)

#### 12.15 Two Pointers
- [ ] Concept — two indices moving through data, reducing O(n²) to O(n)
- [ ] Opposite direction — start/end moving inward (sorted arrays, palindrome)
- [ ] Same direction — fast/slow (linked list cycle, remove duplicates)
- [ ] **Practice problems:**
  - Two Sum II (sorted array, opposite pointers)
  - 3Sum (sort + fix one + two pointers)
  - Container with most water
  - Remove duplicates from sorted array (in-place)
  - Move zeroes
  - Trapping rain water (two-pointer approach)
  - Valid palindrome
  - Sort colors (three pointers / Dutch National Flag)

#### 12.16 Sliding Window
- [ ] Concept — maintain a window [left, right] over array/string, expand right, shrink left
- [ ] Fixed-size window — max sum of subarray of size K
- [ ] Variable-size window — expand until condition breaks, then shrink
- [ ] **Template:**
  ```
  int left = 0;
  for (int right = 0; right < n; right++) {
      // add arr[right] to window state
      while (window is invalid) {
          // remove arr[left] from window state
          left++;
      }
      // update answer
  }
  ```
- [ ] **Practice problems:**
  - Maximum sum subarray of size K
  - Longest substring without repeating characters
  - Minimum window substring (hard)
  - Permutation in string / find all anagrams
  - Longest repeating character replacement
  - Fruit into baskets (longest subarray with at most 2 distinct)
  - Maximum number of vowels in substring of given size
  - Sliding window maximum (deque technique)

#### 12.17 Prefix Sum
- [ ] Concept — precompute cumulative sums to answer range sum queries in O(1)
- [ ] `prefix[i] = prefix[i-1] + arr[i]`, range sum `[l, r] = prefix[r] - prefix[l-1]`
- [ ] 2D prefix sums — matrix region sum queries
- [ ] **Practice problems:**
  - Range sum query (immutable)
  - Subarray sum equals K (prefix sum + hash map)
  - Product of array except self
  - Contiguous array (0s and 1s — prefix sum with hash map)
  - Find pivot index

---

### Phase 4: Advanced Algorithms

#### 12.18 Recursion & Backtracking
- [ ] Backtracking template — choose, explore, unchoose
- [ ] Generating all possibilities — permutations, combinations, subsets
- [ ] Constraint satisfaction — place queens, fill sudoku, form words
- [ ] Pruning — skip invalid branches early to reduce search space
- [ ] **Practice problems:**
  - Subsets (power set)
  - Subsets II (with duplicates — skip duplicates)
  - Permutations
  - Permutations II (with duplicates)
  - Combinations
  - Combination Sum (can reuse elements)
  - Combination Sum II (each element once)
  - Letter combinations of phone number
  - Palindrome partitioning
  - N-Queens
  - Sudoku solver
  - Word search (grid backtracking)
  - Generate parentheses

#### 12.19 Dynamic Programming (DP)
- [ ] What is DP — optimal substructure + overlapping subproblems
- [ ] Top-down (memoization) — recursive + cache, easier to think about
- [ ] Bottom-up (tabulation) — iterative, fill table from base cases, often more space-efficient
- [ ] Space optimization — when only previous row/state is needed, reduce from O(n²) to O(n)
- [ ] **DP Pattern 1: Linear DP (1D)**
  - [ ] Climbing stairs — `dp[i] = dp[i-1] + dp[i-2]`
  - [ ] House robber — can't rob adjacent houses
  - [ ] Maximum subarray (Kadane's)
  - [ ] Decode ways
  - [ ] Word break — `dp[i] = true if any dp[j] && s[j..i] is in dict`
  - [ ] Coin change — minimum coins to make amount
  - [ ] Longest increasing subsequence (LIS) — O(n²) DP, O(n log n) with binary search
- [ ] **DP Pattern 2: Grid/2D DP**
  - [ ] Unique paths (grid traversal)
  - [ ] Minimum path sum
  - [ ] Maximal square
  - [ ] Dungeon game
- [ ] **DP Pattern 3: String DP**
  - [ ] Longest Common Subsequence (LCS) — classic 2D DP
  - [ ] Edit distance (Levenshtein)
  - [ ] Longest palindromic subsequence
  - [ ] Distinct subsequences
  - [ ] Interleaving string
- [ ] **DP Pattern 4: Knapsack**
  - [ ] 0/1 Knapsack — include or exclude each item
  - [ ] Unbounded Knapsack — unlimited copies of each item
  - [ ] Subset sum — special case of 0/1 knapsack
  - [ ] Partition equal subset sum
  - [ ] Target sum (+ and - assignment)
  - [ ] Coin change (unbounded knapsack variant)
- [ ] **DP Pattern 5: Interval DP**
  - [ ] Matrix chain multiplication
  - [ ] Burst balloons
  - [ ] Palindrome partitioning II (minimum cuts)
- [ ] **DP Pattern 6: State Machine DP**
  - [ ] Best time to buy and sell stock (I, II, III, IV, with cooldown, with fee)

#### 12.20 Greedy Algorithms
- [ ] Greedy concept — make locally optimal choice at each step, hope for global optimum
- [ ] Greedy vs DP — greedy doesn't reconsider, DP explores all states
- [ ] Proof technique — exchange argument (swapping a non-greedy choice can't improve result)
- [ ] **Practice problems:**
  - Jump game I & II
  - Gas station (circular route)
  - Assign cookies
  - Non-overlapping intervals (sort by end time)
  - Merge intervals
  - Task scheduler
  - Partition labels
  - Minimum number of arrows to burst balloons
  - Queue reconstruction by height

#### 12.21 Graph Algorithms (Advanced)
- [ ] **Topological Sort:**
  - Kahn's algorithm (BFS, in-degree tracking)
  - DFS-based (reverse post-order)
  - Only for DAGs (Directed Acyclic Graphs)
  - Practice: Course Schedule II, Alien Dictionary
- [ ] **Shortest Path:**
  - BFS — unweighted graphs, O(V+E)
  - Dijkstra's — non-negative weights, O((V+E) log V) with min-heap
  - Bellman-Ford — handles negative weights, O(V·E), detects negative cycles
  - Floyd-Warshall — all-pairs shortest path, O(V³)
  - Practice: Network Delay Time, Cheapest Flights Within K Stops
- [ ] **Union-Find (Disjoint Set Union):**
  - **Build: `UnionFind`** from scratch:
    - `parent[]` array, `rank[]` array
    - `find(x)` — with **path compression** (point directly to root)
    - `union(x, y)` — with **union by rank** (attach shorter tree under taller)
    - Nearly O(1) amortized (inverse Ackermann function)
  - Practice: Number of Connected Components, Redundant Connection, Accounts Merge
- [ ] **Minimum Spanning Tree:**
  - Kruskal's — sort edges, union-find, add if no cycle, O(E log E)
  - Prim's — grow tree from node, min-heap, O((V+E) log V)
  - Practice: Min Cost to Connect All Points
- [ ] **Bipartite Graph:** 2-coloring using BFS/DFS
- [ ] **Practice problems:**
  - Network delay time (Dijkstra)
  - Cheapest flights within K stops (modified Bellman-Ford / BFS)
  - Redundant connection (Union-Find)
  - Accounts merge (Union-Find)
  - Evaluate division (weighted graph + BFS/DFS)
  - Min cost to connect all points (Prim's/Kruskal's)
  - Is graph bipartite?

#### 12.22 Bit Manipulation
- [ ] Bitwise operators — `&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`
- [ ] Common tricks:
  - Check if power of 2: `n & (n-1) == 0`
  - Count set bits: Brian Kernighan's algorithm
  - XOR properties: `a ^ a = 0`, `a ^ 0 = a`
  - Get/set/clear bit at position i
- [ ] **Practice problems:**
  - Single number (XOR all elements)
  - Number of 1 bits
  - Counting bits (dp + bit manipulation)
  - Reverse bits
  - Missing number (XOR approach)
  - Power of two

---

### Phase 5: Advanced Data Structures

#### 12.23 Advanced Trees
- [ ] Segment tree — range queries and point updates in O(log n)
- [ ] Binary Indexed Tree (Fenwick Tree) — prefix sums with updates
- [ ] AVL tree rotations — understand LL, RR, LR, RL (conceptual, not implementation-heavy)
- [ ] Red-Black tree properties — understand why Java uses it in `TreeMap`, `HashMap` (treeification)
- [ ] When to use `TreeMap`/`TreeSet` — sorted order, `floor()`, `ceiling()`, range queries

#### 12.24 Advanced Graph Concepts
- [ ] Strongly connected components — Tarjan's / Kosaraju's algorithm
- [ ] Bridges and articulation points — critical connections in a network
- [ ] Euler path / circuit — conditions and finding algorithms
- [ ] A* search — heuristic-guided shortest path (game development, map routing)

#### 12.25 String Algorithms
- [ ] KMP (Knuth-Morris-Pratt) — pattern matching in O(n+m), failure function
- [ ] Rabin-Karp — rolling hash for pattern matching, O(n) average
- [ ] Trie variations — compressed trie (radix tree), suffix trie

---

### Phase 6: System Design Fundamentals

#### 12.26 System Design Building Blocks
- [ ] Load balancing — algorithms (round-robin, least connections, consistent hashing)
- [ ] Caching — strategies (write-through, write-back, write-around), eviction (LRU, LFU)
- [ ] Database scaling — replication (master-slave), sharding (range, hash), read replicas
- [ ] Message queues — decoupling, backpressure, ordering guarantees
- [ ] CAP theorem — consistency, availability, partition tolerance — pick 2 out of 3
- [ ] Consistent hashing — virtual nodes, ring-based distribution, minimal redistribution
- [ ] Rate limiting — token bucket, sliding window, leaky bucket
- [ ] CDN — caching static assets close to users, cache invalidation
- [ ] Database types — SQL vs NoSQL, when to use which, polyglot persistence

---

### 📋 DSA Study Order (Recommended Sequence)

| Week | Focus | Commands to Use |
|------|-------|----------------|
| 1 | Complexity Analysis + Recursion | `/shorts` → `/revise` |
| 2 | Arrays + Strings (build DynamicArray) | `/explain` → `/project` |
| 3 | Linked Lists (build from scratch) | `/explain` → `/project` → `/trick` |
| 4 | Stacks + Queues (build from scratch) | `/explain` → `/project` → `/revise` |
| 5 | Hash Maps (build MyHashMap) | `/pdd` → `/explain` → `/project` |
| 6 | Sorting algorithms (implement all) | `/explain` → `/trick` → `/revise` |
| 7 | Binary Search mastery | `/shorts` → `/trick` → `/mock-interview` |
| 8 | Two Pointers + Sliding Window | `/explain` → practice problems |
| 9 | Trees + BST (build from scratch) | `/explain` → `/project` → `/trick` |
| 10 | Heaps (build MinHeap) | `/explain` → `/project` → `/revise` |
| 11 | Graphs + BFS/DFS | `/explain` → `/project` → `/trick` |
| 12 | Recursion & Backtracking problems | `/explain` → practice |
| 13-15 | Dynamic Programming (pattern by pattern) | `/explain` → `/pdd` → `/mock-interview` |
| 16 | Greedy + Advanced Graph algorithms | `/explain` → `/revise` |
| 17 | Tries + Union-Find + Bit Manipulation | `/explain` → `/project` |
| 18+ | Mixed practice + Mock interviews | `/mock-interview` → `/trick` → `/revise` |

---

## 🎯 Capstone Projects

### Project Track (Build these as you progress)
- [ ] **P1:** REST CRUD API — Spring Boot + PostgreSQL + JPA + validation + error handling
- [ ] **P2:** Secured API — Add Spring Security + JWT + role-based access to P1
- [ ] **P3:** Mongo Service — Spring Boot + MongoDB + aggregation pipeline
- [ ] **P4:** Event Pipeline — Kafka producer/consumer between two Spring Boot services
- [ ] **P5:** Modular Monolith — Spring Modulith with 3+ modules, inter-module events
- [ ] **P6:** Microservice System — 3 services + API Gateway + Service Discovery + Config Server
- [ ] **P7:** Resilient System — Add circuit breaker, retry, bulkhead to P6
- [ ] **P8:** Observable System — Add metrics, tracing, health checks, Grafana dashboards
- [ ] **P9:** Containerized Deployment — Package P6 with Podman, deploy with Helm charts
- [ ] **P10:** Production Simulation — Load test, identify bottlenecks, tune, resolve mock incidents
