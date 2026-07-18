# 🛠️ Project Refactoring Plan: User Service Architecture & Monolith Standards

**Target Date:** 2026-07-20  
**Repository:** `BeBetterEveryday/projects/nexcommerce-parent`

This document defines the modular monolith boundaries, refactoring checklist, and code fixes compiled during the senior architecture review. 

---

## 1. Core Architecture Refactoring Goals

### 🎯 Objective
Transition the `user-service` from an open CRUD library to a strictly encapsulated module matching **Modular Monolith standards** (preventing architectural decay, entity leaks, and transaction leaks).

---

## 2. Refactoring Tasks

### Task 1: Fix Database Configurations (`application.properties`)
- **Location:** `user-service/src/main/resources/application.properties`
- **Issue:** Invalid connection string protocol and DDL-Auto values.
- **Fix:** Update property values to standard JDBC formats:
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/nexcommerce-user-service
  spring.datasource.username=nexcommerce-user
  spring.datasource.password=root
  spring.jpa.hibernate.ddl-auto=update
  ```

### Task 2: Encapsulate DB Entities (Introduce DTO Records)
- **Problem:** Exposing database JPA `User` objects outside the module leaks table structures and risks security breaches (leaking `passwordHash`).
- **Fix:** 
  1. Define public immutable Java records for API exchanges:
     - `UserResponse.java` (containing `id`, `email`, `firstName`, `lastName`, `roles`, `createdAt`)
     - `UserSignUpRequest.java`
     - `UserLoginRequest.java`
  2. Update `UserService.java` to return `UserResponse` and take request DTOs:
     ```java
     public UserResponse getUserById(UUID userId);
     public void createUser(UserSignUpRequest request);
     ```

### Task 3: Restructure Package Visibility (Modular Enclosure)
- **Problem:** Every class in `user_service` is currently `public`, allowing external components to bypass the service layer and access repositories directly.
- **Fix:** Move internal files to a package-private scope under an `internal` sub-package:
  ```text
  com.nexcommerce.user_service
  ├── UserService.java (Public Interface)
  ├── model/
  │   └── dto/ (Public records: UserResponse, Request DTOs)
  └── internal/ (Package-Private: Class declarations omit 'public' prefix)
      ├── controller/
      │   └── UserController.java
      ├── model/
      │   ├── entity/
      │   │   └── User.java
      │   └── enums/
      │       └── Role.java
      ├── repository/
      │   └── UserRepository.java
      └── service/
          └── UserServiceImpl.java
  ```

### Task 4: Enforce Transactional Boundaries & Clean Up Redundancies
- **Location:** `UserServiceImpl.java`
- **Fixes:**
  1. Annotate the `UserServiceImpl` class with `@Transactional(readOnly = true)`.
  2. Annotate modifying write methods (`createUser`, `updateUserDetailById`, `deleteUserById`) with write-active `@Transactional`.
  3. Remove the redundant `userRepository.save(existing)` calls inside the `update` methods. Let Hibernate's dirty-checking engine flush updates automatically on transaction commit.

---

## 3. Verification & Execution Checks
1.  **Compile Check:** Run `mvn clean compile` to ensure all DTO conversions, package imports, and references resolve cleanly.
2.  **Spring Boot Bootstrap:** Run the application via `mvn spring-boot:run` to confirm the PostgreSQL driver loads the corrected JDBC URL, creates tables via `ddl-auto=update`, and boots the Tomcat web container on port `8080`.
3.  **Endpoint Security Check:** Hit `GET /api/users` to verify the JSON payload maps to `UserResponse` and does **not** leak `passwordHash`.
