# 🗓️ NexCommerce 72-Day Full-Stack Engineering Plan

> **Source of truth for `/today`.** 2 hours/day × 6 days/week × 12 weeks = 72 learning days.
> Every concept is mapped to **NexCommerce** — a distributed e-commerce platform you build from scratch.

---

## How to Use This Plan

1. Run `/today` — it reads this file, finds your current day, and generates the session.
2. Each day has a **Concept** (what to learn), **Practical** (what to build), and **NexCommerce** mapping.
3. Use the listed **Skills** commands (`/shorts`, `/pdd`, `/explain`, etc.) to deepen understanding.
4. After each session, the `learning_tracker.md` is updated automatically.
5. **Rest days** fall every 7th calendar day (after every 6 learning days). Use them for light revision only.

---

## Table of Contents

| Week | Theme | Days |
|------|-------|------|
| **1** | Complexity + Arrays + Strings + Spring Boot Setup | 1–6 |
| **2** | LinkedList + Stack + Queue + Spring MVC | 7–12 |
| **3** | HashMap + Trees + Spring Data JPA | 13–18 |
| **4** | Heaps + Sorting + Spring Data MongoDB | 19–24 |
| **5** | Binary Search + Recursion + Spring Security | 25–30 |
| **6** | Graphs + Kafka | 31–36 |
| **7** | Dynamic Programming + Microservices Architecture | 37–42 |
| **8** | Two Pointers + Sliding Window + API Gateway | 43–48 |
| **9** | Trie + Advanced Trees + Resilience | 49–54 |
| **10** | Advanced Graphs + Observability | 55–60 |
| **11** | String Algorithms + LRU Cache + Containerization | 61–66 |
| **12** | System Design + Production Hardening + Capstone | 67–72 |

---

# MONTH 1: FOUNDATION (Weeks 1–4)

---

## Week 1 — Complexity + Arrays + Strings + Spring Boot Setup

### Day 1 | Week 1 | Complexity Fundamentals
**Topic:** Big O Notation — Time & Space Complexity
**Concept:**
- Analyze single loops (O(n)), nested loops (O(n²)), logarithmic (O(log n))
- Space complexity: auxiliary vs input space
- Best / Average / Worst case distinctions
- Amortized complexity intuition (ArrayList resize)
**Practical:** Analyze the time & space complexity of 5 provided code snippets — write your reasoning for each.
**NexCommerce:** N/A — foundational theory day.
**Skills:** `/shorts Big O Notation`, `/explain Amortized Complexity`
**Revision Focus:** O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ). Always identify the dominant term. Drop constants.
**LeetCode Bridge:** N/A (theory day)

---

### Day 2 | Week 1 | Arrays Fundamentals
**Topic:** Arrays — Declaration, Traversal, Insertion, Deletion
**Concept:**
- Contiguous memory layout, index-based O(1) access
- Insertion/deletion at arbitrary index costs O(n) due to shifting
- System.arraycopy and manual copy patterns
- ArrayList internals: initial capacity, grow factor (1.5x)
**Practical:** Implement `DynamicArray<T>` from scratch — add, get, remove, resize, size, isEmpty.
**NexCommerce:** Foundation for product list storage in catalog service.
**Skills:** `/pdd ArrayList`, `/shorts Array vs LinkedList`
**Revision Focus:** Arrays give O(1) random access but O(n) insert/delete. ArrayList grows by 50% on resize. Always prefer ArrayList over raw arrays in production.
**LeetCode Bridge:** #217 Contains Duplicate (Easy), #238 Product of Array Except Self (Medium)

---

### Day 3 | Week 1 | Array Algorithms
**Topic:** Two Sum, Kadane's Algorithm, Rotate Array
**Concept:**
- Two Sum: brute O(n²) vs HashMap O(n) approach
- Kadane's: max subarray sum in O(n), track currentMax vs globalMax
- Rotate array: reverse-based approach O(n) in-place
- Recognizing "scan once, decide" patterns
**Practical:** Solve Two Sum, Kadane's Max Subarray, and Rotate Array from scratch — no library calls.
**NexCommerce:** Max profit calculation in analytics dashboard (Kadane's pattern).
**Skills:** `/shorts Kadane's Algorithm`, `/trick Arrays`
**Revision Focus:** Two Sum = HashMap lookup pattern. Kadane's = "extend current or start fresh." Rotate = three-reverse trick.
**LeetCode Bridge:** #1 Two Sum (Easy), #53 Maximum Subarray (Medium)

---

### Day 4 | Week 1 | String Fundamentals
**Topic:** String Immutability, StringBuilder, String Pool
**Concept:**
- String immutability: every modification creates a new object
- String pool (interning) and `==` vs `.equals()` trap
- StringBuilder for O(n) concatenation vs O(n²) with `+` in loops
- char[] operations: manual traversal, case conversion
**Practical:** Implement string reversal, palindrome check, and anagram check — all using char arrays only.
**NexCommerce:** Input validation layer for user registration and search queries.
**Skills:** `/shorts String Pool`, `/explain String Immutability`
**Revision Focus:** Never concatenate strings in a loop with `+`. String pool only caches literals and `.intern()` calls. `.equals()` for content, `==` for reference.
**LeetCode Bridge:** #125 Valid Palindrome (Easy), #242 Valid Anagram (Easy)

---

### Day 5 | Week 1 | String Algorithms
**Topic:** Substring Search, Character Frequency, Longest Unique Substring
**Concept:**
- Brute-force substring search O(n×m) — understand before optimizing
- Character frequency with `int[26]` or `int[128]` arrays
- Sliding window for longest substring without repeating characters
- Two-pointer technique preview
**Practical:** Implement character frequency counter using `int[26]` array and solve longest unique substring.
**NexCommerce:** Search query preprocessing — normalize, deduplicate, extract keywords.
**Skills:** `/shorts Sliding Window`, `/trick Strings`
**Revision Focus:** Frequency arrays beat HashMaps for fixed alphabets. Sliding window = expand right, shrink left. Longest unique substring is a classic variable-width window.
**LeetCode Bridge:** #3 Longest Substring Without Repeating Characters (Medium), #387 First Unique Character (Easy)

---

### Day 6 | Week 1 | Spring Boot + Maven Setup
**Topic:** NexCommerce Multi-Module Maven Project
**Concept:**
- Maven multi-module: parent POM, child modules, dependency management
- Spring Boot starters: what `spring-boot-starter-web` auto-configures
- `application.yml` vs `application.properties`, profiles (dev/prod)
- Spring Boot Actuator `/health` endpoint
**Practical:** Create `nexcommerce-parent` with `user-service` module. Configure application.yml, add Actuator, hit `/actuator/health`.
**NexCommerce:** Project scaffold — the skeleton that every future service builds on.
**Skills:** `/guide Spring Boot Multi-Module Maven`, `/pdd Spring Boot Auto-Configuration`
**Revision Focus:** Parent POM manages versions, children inherit. Spring Boot auto-configures based on classpath. Actuator is your production lifeline.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Light revision of Week 1. Review your DynamicArray and string algorithm implementations. Re-read complexity notes.

---

## Week 2 — LinkedList + Stack + Queue + Spring MVC

### Day 7 | Week 2 | Singly LinkedList
**Topic:** Singly LinkedList — Node, Insert, Delete, Traverse
**Concept:**
- Node class: `data` + `next` pointer
- Insert at head O(1), at tail O(n) without tail pointer, at index O(n)
- Delete by value vs by index — pointer rewiring
- Traversal pattern: `while (current != null)`
**Practical:** Build complete `SinglyLinkedList<T>` — addFirst, addLast, add(index), remove, get, size, toString.
**NexCommerce:** Order history chain — each order points to the previous one.
**Skills:** `/shorts LinkedList vs ArrayList`, `/explain Node-based Data Structures`
**Revision Focus:** LinkedList = O(1) insert/delete at known position, O(n) access. Always handle edge cases: empty list, single node, head/tail operations.
**LeetCode Bridge:** #206 Reverse Linked List (Easy), #21 Merge Two Sorted Lists (Easy)

---

### Day 8 | Week 2 | Doubly LinkedList + Circular
**Topic:** Doubly LinkedList, Circular LinkedList, Cycle Detection
**Concept:**
- DoublyLinkedList: `prev` + `next` pointers, O(1) delete with node reference
- Sentinel nodes (dummy head/tail) to eliminate edge cases
- Circular LinkedList: tail.next → head
- Floyd's cycle detection (slow/fast pointers) preview
**Practical:** Build `DoublyLinkedList<T>` with sentinel nodes — addFirst, addLast, remove(node), iterator.
**NexCommerce:** Browser-style navigation — back/forward through pages using prev/next.
**Skills:** `/pdd Doubly LinkedList`, `/trick LinkedList`
**Revision Focus:** Doubly linked = bidirectional traversal + O(1) delete with node ref. Sentinel nodes eliminate null checks. Cost: 2x pointer overhead.
**LeetCode Bridge:** #141 Linked List Cycle (Easy), #142 Linked List Cycle II (Medium)

---

### Day 9 | Week 2 | LinkedList Algorithms
**Topic:** Reverse, Cycle Detection, Find Middle, Merge Sorted
**Concept:**
- Reverse in-place: three-pointer technique (prev, current, next)
- Floyd's algorithm: slow (1 step) + fast (2 steps) → cycle detection
- Find middle: slow/fast — when fast reaches end, slow is at middle
- Merge two sorted lists: dummy head + compare-and-append
**Practical:** Solve all 4 problems from scratch — reverse, detect cycle, find middle, merge sorted.
**NexCommerce:** Merge sorted order lists from two vendor feeds into unified timeline.
**Skills:** `/shorts Floyd's Cycle Detection`, `/revise LinkedList`
**Revision Focus:** Reverse = rewire prev/current/next in loop. Floyd's = if fast meets slow, cycle exists. Middle = slow/fast trick.
**LeetCode Bridge:** #206 Reverse Linked List (Easy), #876 Middle of the Linked List (Easy)

---

### Day 10 | Week 2 | Stack
**Topic:** Stack — Array-based, LinkedList-based, Applications
**Concept:**
- LIFO principle: push, pop, peek, isEmpty — all O(1)
- Array-based: use top index; LinkedList-based: push/pop at head
- Balanced parentheses: push open, pop on close, match types
- Postfix evaluation: operand → push, operator → pop two, compute, push result
**Practical:** Build `Stack<T>` from scratch (array-based) + solve balanced brackets checker.
**NexCommerce:** Expression evaluator for discount rules engine — "BUY 2 GET (50% OFF)".
**Skills:** `/shorts Stack`, `/explain Call Stack vs Data Stack`
**Revision Focus:** Stack = undo/redo, expression parsing, DFS. If you need LIFO, use a Stack. Java's `Deque` (ArrayDeque) is preferred over legacy `Stack` class.
**LeetCode Bridge:** #20 Valid Parentheses (Easy), #155 Min Stack (Medium)

---

### Day 11 | Week 2 | Queue + Deque
**Topic:** Circular Queue, LinkedList Queue, Deque
**Concept:**
- FIFO: enqueue at rear, dequeue at front
- Circular array queue: avoid shifting with `(index + 1) % capacity`
- Deque (double-ended): addFirst, addLast, removeFirst, removeLast
- Java's ArrayDeque: resizable circular array, faster than LinkedList for both stack and queue
**Practical:** Build `CircularQueue<T>` (fixed-size) and `Deque<T>` (resizable) from scratch.
**NexCommerce:** Order processing pipeline — FIFO queue ensures fair processing order.
**Skills:** `/pdd Queue`, `/shorts Deque`
**Revision Focus:** Circular queue wraps index with modulo. Deque = Stack + Queue in one. ArrayDeque > LinkedList for most use cases (cache-friendly).
**LeetCode Bridge:** #232 Implement Queue using Stacks (Easy), #239 Sliding Window Maximum (Hard — preview)

---

### Day 12 | Week 2 | Spring MVC + REST
**Topic:** @RestController, Request Mapping, ResponseEntity
**Concept:**
- @RestController = @Controller + @ResponseBody
- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
- @RequestBody (JSON → object), @PathVariable, @RequestParam
- ResponseEntity for explicit HTTP status control (201 Created, 404 Not Found)
**Practical:** Build User Service REST API — `POST /users`, `GET /users/{id}`, `GET /users`, `PUT /users/{id}`, `DELETE /users/{id}`.
**NexCommerce:** User Service CRUD endpoints — the first real service API.
**Skills:** `/guide Spring MVC REST`, `/explain ResponseEntity vs @ResponseBody`
**Revision Focus:** REST = resources as URLs, HTTP verbs as actions. Always return proper status codes. Use ResponseEntity for control. Validate input with @Valid.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Revisit your LinkedList and Stack implementations. Trace through the cycle detection algorithm on paper.

---

## Week 3 — HashMap + Trees + Spring Data JPA

### Day 13 | Week 3 | HashMap Internals
**Topic:** Hashing, Bucket Array, Collision Handling
**Concept:**
- Hash function: key → hashCode → bucket index via `hash % capacity`
- Collision handling: separate chaining (LinkedList per bucket)
- Load factor (0.75 default): when `size/capacity > loadFactor`, resize
- Why good distribution matters: clustered hashes → O(n) degradation
**Practical:** Build `HashMap<K,V>` from scratch with separate chaining — put, get, remove, containsKey, size.
**NexCommerce:** Product SKU → details O(1) lookup in inventory service.
**Skills:** `/explain HashMap Internals`, `/shorts Hashing`
**Revision Focus:** HashMap = array of buckets + hash function. Collisions degrade to O(n). Load factor triggers rehash. Always override both hashCode() AND equals().
**LeetCode Bridge:** #1 Two Sum (Easy — HashMap approach), #49 Group Anagrams (Medium)

---

### Day 14 | Week 3 | HashMap Advanced
**Topic:** Rehashing, hashCode/equals Contract, TreeNode Promotion
**Concept:**
- Rehashing: double capacity, re-distribute all entries (expensive O(n))
- Contract: if `a.equals(b)` then `a.hashCode() == b.hashCode()` (must hold)
- Java 8+: bucket converts LinkedList → Red-Black Tree at 8 nodes (TREEIFY_THRESHOLD)
- Designing good hash functions: distribute evenly, use prime multipliers
**Practical:** Add rehashing to your custom HashMap. Test with bad hash function to observe O(n) degradation.
**NexCommerce:** Inventory stock tracking by warehouse — warehouses as keys.
**Skills:** `/pdd hashCode equals Contract`, `/trick HashMap`
**Revision Focus:** Rehash doubles capacity and redistributes. Breaking hashCode/equals contract = silent data corruption. TreeNode promotion saves worst-case.
**LeetCode Bridge:** #146 LRU Cache (Medium — preview), #380 Insert Delete GetRandom O(1) (Medium)

---

### Day 15 | Week 3 | HashSet + LinkedHashMap + TreeMap
**Topic:** Set Semantics, Insertion Order, Sorted Keys
**Concept:**
- HashSet: HashMap with dummy values — only keys matter
- LinkedHashMap: HashMap + doubly linked list for insertion/access order
- TreeMap: Red-Black Tree, sorted keys, O(log n) operations
- When to use which: unique checks → HashSet, order → LinkedHashMap, sorted → TreeMap
**Practical:** Implement `HashSet<T>` using your HashMap. Explore LinkedHashMap access-order mode for LRU.
**NexCommerce:** Unique category tags (HashSet), LRU recently viewed products (LinkedHashMap).
**Skills:** `/shorts HashSet vs TreeSet`, `/explain LinkedHashMap Access Order`
**Revision Focus:** HashSet = HashMap with dummy values. LinkedHashMap(capacity, loadFactor, true) = access-order mode = LRU basis. TreeMap = NavigableMap with sorted iteration.
**LeetCode Bridge:** #217 Contains Duplicate (Easy), #347 Top K Frequent Elements (Medium)

---

### Day 16 | Week 3 | Binary Tree Fundamentals
**Topic:** Binary Tree — Node, Insert, Traversals
**Concept:**
- TreeNode: `data`, `left`, `right`
- Traversals: Inorder (L-Root-R), Preorder (Root-L-R), Postorder (L-R-Root)
- Level-order: BFS using Queue
- Tree height, node count, leaf count — recursive patterns
**Practical:** Build `BinaryTree<T>` with insert (level-order) and all 4 traversals (recursive + iterative inorder).
**NexCommerce:** Product category hierarchy — Electronics → Phones → Android/iOS.
**Skills:** `/shorts Tree Traversals`, `/explain Recursion in Trees`
**Revision Focus:** Inorder on BST = sorted output. Preorder = serialize. Postorder = delete (children first). Level-order = BFS with queue.
**LeetCode Bridge:** #94 Binary Tree Inorder Traversal (Easy), #102 Binary Tree Level Order Traversal (Medium)

---

### Day 17 | Week 3 | Binary Search Tree
**Topic:** BST — Search, Insert, Delete, Validate
**Concept:**
- BST property: left < root < right (for all subtrees)
- Search/Insert: O(h) — follow left/right based on comparison
- Delete 3 cases: leaf, one child, two children (replace with inorder successor)
- Validate BST: in-range technique (min, max bounds)
**Practical:** Build `BST<T extends Comparable<T>>` — insert, search, delete, validate, findMin, findMax.
**NexCommerce:** Price-range product filtering — find all products between ₹100–₹500.
**Skills:** `/explain BST Deletion`, `/trick BST`
**Revision Focus:** BST degrades to O(n) if unbalanced (sorted insert → linked list). Delete with two children: find inorder successor (smallest in right subtree), swap, delete. Validate with min/max bounds.
**LeetCode Bridge:** #98 Validate Binary Search Tree (Medium), #230 Kth Smallest Element in BST (Medium)

---

### Day 18 | Week 3 | Spring Data JPA + PostgreSQL
**Topic:** Entity, Repository, Custom Queries
**Concept:**
- @Entity, @Id, @GeneratedValue(strategy = IDENTITY/SEQUENCE)
- JpaRepository<T, ID>: save, findById, findAll, deleteById — free CRUD
- Custom queries: @Query (JPQL / native), derived query methods (findByEmail)
- PostgreSQL connection: spring.datasource.url, HikariCP pool
**Practical:** Create User @Entity + UserRepository, wire to local PostgreSQL, test full CRUD via REST endpoints.
**NexCommerce:** User Service persistence layer — users stored in PostgreSQL.
**Skills:** `/guide Spring Data JPA`, `/pdd JPA vs JDBC`
**Revision Focus:** JpaRepository gives free CRUD. @GeneratedValue IDENTITY = DB auto-increment. Always use `Optional<T>` from findById. HikariCP is the default pool — tune `maximumPoolSize`.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Review HashMap internals. Draw the BST deletion cases on paper. Verify User Service CRUD works end-to-end.

---

## Week 4 — Heaps + Sorting + Spring Data MongoDB

### Day 19 | Week 4 | Heap Fundamentals
**Topic:** MinHeap — Complete Binary Tree, Heapify Up/Down
**Concept:**
- Complete binary tree stored in array: parent = (i-1)/2, left = 2i+1, right = 2i+2
- MinHeap property: parent ≤ children at every level
- Heapify up (after insert): bubble new element up to restore property
- Heapify down (after extract-min): sink root replacement down
**Practical:** Build `MinHeap<T extends Comparable<T>>` from scratch — insert, extractMin, peek, size.
**NexCommerce:** Priority-based order processing queue — VIP orders processed first.
**Skills:** `/shorts Heap`, `/explain Heap vs BST`
**Revision Focus:** Heap = complete binary tree in array. Insert = add at end + heapify up O(log n). Extract = swap root with last + heapify down O(log n). Heapify array = O(n) not O(n log n).
**LeetCode Bridge:** #703 Kth Largest Element in a Stream (Easy), #215 Kth Largest Element in Array (Medium)

---

### Day 20 | Week 4 | PriorityQueue + Top-K
**Topic:** Java PriorityQueue, Top-K Pattern
**Concept:**
- Java PriorityQueue: MinHeap by default, Comparator for MaxHeap
- Top-K largest: use MinHeap of size K — if new element > heap.peek(), replace
- Top-K smallest: use MaxHeap of size K
- Why K-sized heap beats sorting: O(n log K) vs O(n log n)
**Practical:** Implement top-K popular products using your MinHeap — feed 10K products, get top 10 by sales count.
**NexCommerce:** "Trending Products" feature on homepage.
**Skills:** `/shorts Top-K Pattern`, `/trick PriorityQueue`
**Revision Focus:** Top-K largest = MinHeap of size K (counterintuitive). PriorityQueue is NOT sorted — only peek/poll guarantee min. O(n log K) beats O(n log n) when K << n.
**LeetCode Bridge:** #347 Top K Frequent Elements (Medium), #692 Top K Frequent Words (Medium)

---

### Day 21 | Week 4 | Basic Sorting
**Topic:** Bubble Sort, Selection Sort, Insertion Sort
**Concept:**
- Bubble Sort: repeated adjacent swaps, O(n²), stable, adaptive with flag
- Selection Sort: find min in unsorted portion, swap to front, O(n²), unstable
- Insertion Sort: shift elements right to make room, O(n²), stable, best for nearly sorted O(n)
- Stability: preserves relative order of equal elements
**Practical:** Implement all 3 from scratch. Benchmark with 10K random, sorted, and reverse-sorted arrays.
**NexCommerce:** Understanding why O(n²) sorts fail at scale — motivation for merge/quick sort.
**Skills:** `/shorts Sorting Stability`, `/explain When Insertion Sort Wins`
**Revision Focus:** Insertion sort = best for small/nearly-sorted data (used inside TimSort). Selection sort = minimum swaps. Bubble sort = rarely practical. Stability matters for multi-key sorting.
**LeetCode Bridge:** #912 Sort an Array (Medium — use as benchmark)

---

### Day 22 | Week 4 | Merge Sort
**Topic:** Divide & Conquer, Merge Step, O(n log n)
**Concept:**
- Split array in half recursively until size 1 (base case)
- Merge two sorted halves: two-pointer comparison into temp array
- Time: O(n log n) always. Space: O(n) for temp array
- Stable sort. Excellent for linked lists (no extra space needed)
**Practical:** Implement merge sort from scratch for arrays. Test with 100K elements.
**NexCommerce:** External sort pattern for large order export files that don't fit in memory.
**Skills:** `/explain Merge Sort`, `/shorts Divide and Conquer`
**Revision Focus:** Merge sort = guaranteed O(n log n) but costs O(n) space. The merge step is the core — practice it until automatic. Great for external sorting (disk-based).
**LeetCode Bridge:** #912 Sort an Array (Medium), #148 Sort List (Medium)

---

### Day 23 | Week 4 | Quick Sort
**Topic:** Partition, Pivot Selection, Randomized Quick Sort
**Concept:**
- Partition: rearrange so elements < pivot go left, ≥ pivot go right
- Lomuto partition: single pointer, simpler but more swaps
- Hoare partition: two pointers converging, fewer swaps
- Worst case O(n²) on sorted data with bad pivot → randomized pivot fixes
**Practical:** Implement quicksort with Lomuto partition + randomized pivot. Compare with merge sort on 100K elements.
**NexCommerce:** In-memory product ranking sort — quicksort's cache-friendly nature wins.
**Skills:** `/explain QuickSort Partitioning`, `/trick Sorting`
**Revision Focus:** QuickSort is O(n log n) average, O(n²) worst. Randomized pivot makes worst case astronomically unlikely. In-place (O(log n) stack) vs merge sort's O(n) space. Java's Arrays.sort uses dual-pivot quicksort for primitives.
**LeetCode Bridge:** #215 Kth Largest Element (Medium — quickselect), #75 Sort Colors (Medium)

---

### Day 24 | Week 4 | Spring Data MongoDB
**Topic:** @Document, MongoRepository, Embedded vs Referenced
**Concept:**
- @Document: maps class to MongoDB collection
- MongoRepository<T, ID>: same interface pattern as JpaRepository
- Embedded documents vs $ref (referenced): denormalize for reads, normalize for writes
- MongoTemplate: complex queries, aggregations, $match/$group/$sort
**Practical:** Create Product @Document + ProductRepository, wire to local MongoDB. Implement CRUD + search by category.
**NexCommerce:** Product catalog persistence — products stored in MongoDB (flexible schema for attributes).
**Skills:** `/guide Spring Data MongoDB`, `/pdd SQL vs NoSQL`
**Revision Focus:** MongoDB = document store, schema-flexible. Embed when data is read together. Reference when data changes independently. MongoTemplate for anything JpaRepository can't express.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Implement merge sort for a linked list (no extra space). Review heap operations. Verify Product Service CRUD works.

---

# MONTH 2: SCALE (Weeks 5–8)

---

## Week 5 — Binary Search + Recursion + Spring Security

### Day 25 | Week 5 | Binary Search Standard
**Topic:** Sorted Array Search — Iterative & Recursive
**Concept:**
- Precondition: array MUST be sorted
- Iterative: `while (low <= high)`, compute `mid = low + (high - low) / 2` (avoid overflow)
- Recursive: base case `low > high`, recurse on left or right half
- Edge cases: empty array, single element, target not found, duplicates
**Practical:** Implement binary search (both forms) + find first and last occurrence of a target in sorted array.
**NexCommerce:** Paginated product search optimization — binary search on sorted price index.
**Skills:** `/shorts Binary Search`, `/explain Binary Search Edge Cases`
**Revision Focus:** Always use `low + (high - low) / 2` to prevent integer overflow. `low <= high` (inclusive) is the standard template. First/last occurrence: don't return immediately on match, keep searching.
**LeetCode Bridge:** #704 Binary Search (Easy), #34 Find First and Last Position (Medium)

---

### Day 26 | Week 5 | Binary Search Variations
**Topic:** Lower/Upper Bound, Rotated Array, Peak Element
**Concept:**
- Lower bound: first index where `arr[i] >= target`
- Upper bound: first index where `arr[i] > target`
- Rotated sorted array: find pivot, then binary search in correct half
- Peak element: if `mid > mid+1`, peak is left-or-mid; else peak is right
**Practical:** Solve search in rotated sorted array + find peak element.
**NexCommerce:** Finding price thresholds — "cheapest product above ₹500" = lower bound.
**Skills:** `/trick Binary Search`, `/revise Binary Search`
**Revision Focus:** Rotated array = one half is always sorted — check which half, decide direction. Peak element = binary search on slope. These patterns appear everywhere in interviews.
**LeetCode Bridge:** #33 Search in Rotated Sorted Array (Medium), #162 Find Peak Element (Medium)

---

### Day 27 | Week 5 | Recursion Fundamentals
**Topic:** Call Stack, Base Case, Recursive Case
**Concept:**
- Each recursive call pushes a new frame onto the call stack
- Base case: terminates recursion (prevents stack overflow)
- Recursive case: reduces problem size and calls itself
- Stack overflow: too deep recursion (default ~10K frames in JVM)
**Practical:** Implement factorial, fibonacci (naive + memoized), power(x, n) with O(log n), tower of Hanoi.
**NexCommerce:** Recursive category tree building — root → subcategories → sub-subcategories.
**Skills:** `/explain Recursion`, `/shorts Call Stack`
**Revision Focus:** Every recursion can be converted to iteration (with explicit stack). Always define base case FIRST. Fibonacci naive = O(2ⁿ), memoized = O(n). Power = divide exponent by 2 each step.
**LeetCode Bridge:** #50 Pow(x, n) (Medium), #509 Fibonacci Number (Easy)

---

### Day 28 | Week 5 | Recursion Patterns
**Topic:** Subsets, Permutations, Combinations
**Concept:**
- Subsets: include/exclude decision tree → 2ⁿ subsets
- Permutations: choose each unused element for current position → n! results
- Backtracking pattern: choose → explore → un-choose
- State space tree visualization
**Practical:** Implement subset generation (iterative + recursive) + permutation generation.
**NexCommerce:** Generate all possible discount combinations — "10% + free shipping" or "20% only."
**Skills:** `/explain Backtracking Pattern`, `/shorts Subsets vs Permutations`
**Revision Focus:** Subsets = 2ⁿ (include/exclude). Permutations = n! (order matters). The backtracking template: add to path → recurse → remove from path. This pattern is universal.
**LeetCode Bridge:** #78 Subsets (Medium), #46 Permutations (Medium)

---

### Day 29 | Week 5 | Backtracking
**Topic:** N-Queens, Constraint Satisfaction, Pruning
**Concept:**
- N-Queens: place N queens on N×N board so none attack each other
- Column tracking, diagonal tracking (row-col, row+col)
- Pruning: skip invalid placements early → dramatically reduce search space
- Backtracking = DFS + constraint checking + undo
**Practical:** Implement N-Queens solver that prints all valid configurations for N=8.
**NexCommerce:** Constraint-based delivery slot scheduling — no overlapping drivers in same zone.
**Skills:** `/explain N-Queens`, `/shorts Pruning in Backtracking`
**Revision Focus:** Backtracking = "try → validate → continue or undo." Pruning avoids exploring dead-end branches. Track attacks with sets/arrays, not by scanning the board.
**LeetCode Bridge:** #51 N-Queens (Hard), #37 Sudoku Solver (Hard — bonus)

---

### Day 30 | Week 5 | Spring Security + JWT
**Topic:** Authentication, Authorization, JWT, SecurityFilterChain
**Concept:**
- Authentication (who are you) vs Authorization (what can you do)
- JWT structure: Header.Payload.Signature — stateless token
- SecurityFilterChain: define which endpoints are public vs protected
- @PreAuthorize("hasRole('ADMIN')") for method-level security
**Practical:** Add JWT authentication to User Service — login endpoint returns token, protected endpoints require valid Bearer token.
**NexCommerce:** Secure all service endpoints — no unauthenticated access to user data.
**Skills:** `/guide Spring Security JWT`, `/pdd Stateful Sessions vs JWT`
**Revision Focus:** JWT = stateless auth, no server-side session. Always validate signature + expiry. Never store sensitive data in JWT payload (it's base64, not encrypted). SecurityFilterChain replaces deprecated WebSecurityConfigurerAdapter.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Review recursion tree diagrams. Trace N-Queens for N=4 on paper. Test JWT flow end-to-end with Postman/curl.

---

## Week 6 — Graphs + Kafka

### Day 31 | Week 6 | Graph Representations + BFS
**Topic:** Adjacency List/Matrix, BFS Implementation
**Concept:**
- Adjacency list: `Map<V, List<V>>` — space O(V+E), good for sparse graphs
- Adjacency matrix: `boolean[V][V]` — space O(V²), good for dense graphs
- BFS: level-by-level exploration using Queue, O(V+E)
- BFS gives shortest path in unweighted graphs
**Practical:** Build `Graph<T>` class with adjacency list, addVertex, addEdge, BFS traversal.
**NexCommerce:** Vendor delivery network — vendors as nodes, delivery routes as edges.
**Skills:** `/shorts Graph Representations`, `/explain BFS`
**Revision Focus:** Adjacency list for sparse (most real-world graphs), matrix for dense. BFS = Queue + visited set. BFS finds shortest path in unweighted graphs.
**LeetCode Bridge:** #200 Number of Islands (Medium), #133 Clone Graph (Medium)

---

### Day 32 | Week 6 | DFS + Applications
**Topic:** DFS Iterative/Recursive, Cycle Detection
**Concept:**
- DFS recursive: visit → mark → recurse on neighbors
- DFS iterative: use explicit Stack instead of call stack
- Connected components: run DFS/BFS from each unvisited node
- Cycle detection: directed (back edge via recursion stack), undirected (visited + parent check)
**Practical:** Implement DFS + detect cycle in directed graph (vendor dependency graph).
**NexCommerce:** Circular dependency detection between microservices.
**Skills:** `/explain DFS vs BFS`, `/shorts Cycle Detection`
**Revision Focus:** DFS = Stack (implicit/explicit). Cycle in directed graph: track "in current recursion stack" (gray nodes). Cycle in undirected: visited neighbor that isn't parent.
**LeetCode Bridge:** #207 Course Schedule (Medium), #547 Number of Provinces (Medium)

---

### Day 33 | Week 6 | Dijkstra's Algorithm
**Topic:** Shortest Path in Weighted Graph
**Concept:**
- Greedy approach: always expand the nearest unvisited node
- PriorityQueue of (distance, node), relaxation: if `dist[u] + weight < dist[v]`, update
- Cannot handle negative weights (use Bellman-Ford)
- Time: O((V+E) log V) with binary heap
**Practical:** Implement Dijkstra's from scratch using PriorityQueue.
**NexCommerce:** Optimal delivery route calculation — find cheapest path from warehouse to customer.
**Skills:** `/explain Dijkstra's Algorithm`, `/shorts Greedy vs DP`
**Revision Focus:** Dijkstra = BFS + PriorityQueue + relaxation. No negative weights. Process each node only once. dist[] array starts at Integer.MAX_VALUE except source = 0.
**LeetCode Bridge:** #743 Network Delay Time (Medium), #787 Cheapest Flights Within K Stops (Medium)

---

### Day 34 | Week 6 | Topological Sort
**Topic:** DAG Ordering — Kahn's (BFS) and DFS-based
**Concept:**
- Topological sort: linear ordering where u comes before v for every edge u→v
- Only possible on DAGs (Directed Acyclic Graphs)
- Kahn's: start with in-degree 0 nodes, remove edges, repeat
- DFS-based: post-order reversal gives topological order
**Practical:** Implement topological sort using Kahn's algorithm.
**NexCommerce:** Microservice startup order — user-service before order-service before payment-service.
**Skills:** `/shorts Topological Sort`, `/explain Kahn's Algorithm`
**Revision Focus:** Topological sort = dependency resolution. Kahn's detects cycles (if result size < V, cycle exists). Every DAG has at least one topological ordering.
**LeetCode Bridge:** #210 Course Schedule II (Medium), #269 Alien Dictionary (Hard — bonus)

---

### Day 35 | Week 6 | Union-Find (Disjoint Set)
**Topic:** Find + Path Compression, Union by Rank
**Concept:**
- Each element has a parent; root = representative of the set
- Find(x): follow parent pointers to root; path compression flattens tree
- Union(x, y): merge sets by linking roots; union by rank keeps tree shallow
- Near O(1) amortized per operation (inverse Ackermann)
**Practical:** Build `UnionFind` class — find, union, isConnected, component count.
**NexCommerce:** Fraud ring detection — cluster connected user accounts that share IPs/devices.
**Skills:** `/explain Union-Find`, `/pdd Union-Find`
**Revision Focus:** Path compression: point every node directly to root during find. Union by rank: attach shorter tree under taller. Together = nearly O(1). Use for dynamic connectivity queries.
**LeetCode Bridge:** #684 Redundant Connection (Medium), #547 Number of Provinces (Medium — UF approach)

---

### Day 36 | Week 6 | Kafka Fundamentals
**Topic:** Producer, Consumer, Topics, Partitions, Consumer Groups
**Concept:**
- Topic = named stream of events. Partition = ordered, immutable log within topic
- Producer: writes events to topic (key-based partitioning)
- Consumer: reads events, tracks offset. Consumer Group: parallel consumption
- At-least-once vs exactly-once semantics
**Practical:** Set up Kafka (via Podman), create `order-events` topic, write producer (send OrderCreated) + consumer (log received events).
**NexCommerce:** Order event streaming — Order Service publishes, Inventory/Notification services consume.
**Skills:** `/guide Kafka Setup`, `/pdd Kafka`
**Revision Focus:** Partition = unit of parallelism. One partition → one consumer per group. Offset = consumer's read position. Kafka retains events (not a queue — events aren't deleted on read).
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Draw Dijkstra's step-by-step on a 6-node graph. Review Union-Find operations. Verify Kafka producer/consumer works.

---

## Week 7 — Dynamic Programming + Microservices Architecture

### Day 37 | Week 7 | DP Introduction
**Topic:** Memoization vs Tabulation, Overlapping Subproblems
**Concept:**
- Overlapping subproblems: same subproblem solved repeatedly (fibonacci tree)
- Optimal substructure: optimal solution contains optimal sub-solutions
- Memoization (top-down): recurse + cache in HashMap/array
- Tabulation (bottom-up): fill table iteratively, no recursion overhead
**Practical:** Implement fibonacci with memoization (top-down) and tabulation (bottom-up). Compare call counts.
**NexCommerce:** Understanding optimization patterns used in pricing and logistics algorithms.
**Skills:** `/explain Dynamic Programming`, `/shorts Memoization vs Tabulation`
**Revision Focus:** Memoization = recursion + cache (easier to write). Tabulation = iterative + no stack overflow (better for production). If problem has overlapping subproblems + optimal substructure → try DP.
**LeetCode Bridge:** #70 Climbing Stairs (Easy), #509 Fibonacci Number (Easy)

---

### Day 38 | Week 7 | DP 1D Problems
**Topic:** Climbing Stairs, House Robber, Coin Change, LIS
**Concept:**
- Climbing stairs: dp[i] = dp[i-1] + dp[i-2] (fibonacci variant)
- House robber: dp[i] = max(dp[i-1], dp[i-2] + nums[i]) — rob or skip
- Coin change: dp[amount] = min(dp[amount - coin] + 1) for each coin
- LIS: dp[i] = max(dp[j] + 1) where j < i and nums[j] < nums[i], O(n²)
**Practical:** Solve climbing stairs + coin change (minimum coins).
**NexCommerce:** Minimum coins for payment change — exact change calculation in POS system.
**Skills:** `/revise Dynamic Programming`, `/trick DP`
**Revision Focus:** 1D DP = "current state depends on previous states." Coin change = classic unbounded DP. LIS has O(n log n) solution with patience sorting (advanced).
**LeetCode Bridge:** #70 Climbing Stairs (Easy), #322 Coin Change (Medium)

---

### Day 39 | Week 7 | DP 2D Problems
**Topic:** Grid Paths, Minimum Path Sum, LCS
**Concept:**
- Unique paths: dp[i][j] = dp[i-1][j] + dp[i][j-1] (can only go right/down)
- Minimum path sum: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
- LCS: if chars match, dp[i][j] = dp[i-1][j-1] + 1; else max(dp[i-1][j], dp[i][j-1])
- Space optimization: 2D → 1D by using only previous row
**Practical:** Solve unique grid paths + Longest Common Subsequence.
**NexCommerce:** Product similarity matching — LCS on feature/tag lists to find related products.
**Skills:** `/explain LCS`, `/shorts 2D DP Grid`
**Revision Focus:** 2D DP = fill table row by row. LCS is foundational — used in diff tools, DNA alignment, plagiarism detection. Space optimization reduces O(n×m) → O(min(n,m)).
**LeetCode Bridge:** #62 Unique Paths (Medium), #1143 Longest Common Subsequence (Medium)

---

### Day 40 | Week 7 | DP Knapsack
**Topic:** 0/1 Knapsack, Unbounded Knapsack, Subset Sum
**Concept:**
- 0/1 knapsack: each item used at most once. dp[i][w] = max(skip, take)
- Unbounded: each item unlimited. dp[w] = max(dp[w], dp[w - weight[i]] + value[i])
- Subset sum: boolean dp — "can we make sum S from this set?"
- 0/1 knapsack: iterate weight BACKWARDS (to prevent re-use)
**Practical:** Solve 0/1 knapsack + subset sum.
**NexCommerce:** Optimal coupon stacking — maximize discount within budget constraints.
**Skills:** `/explain Knapsack Problem`, `/trick Knapsack`
**Revision Focus:** 0/1 knapsack: reverse iteration on weight prevents item reuse. Subset sum = boolean knapsack. These patterns appear in resource allocation, scheduling, and budgeting problems.
**LeetCode Bridge:** #416 Partition Equal Subset Sum (Medium), #494 Target Sum (Medium)

---

### Day 41 | Week 7 | Greedy Algorithms
**Topic:** Activity Selection, Fractional Knapsack, Interval Scheduling
**Concept:**
- Greedy: make locally optimal choice at each step, hope for global optimum
- Activity selection: sort by end time, pick non-overlapping activities
- Fractional knapsack: sort by value/weight ratio, take greedily
- Greedy works when problem has greedy-choice property + optimal substructure
**Practical:** Solve activity selection + interval scheduling (maximum non-overlapping intervals).
**NexCommerce:** Delivery time slot allocation — greedily assign maximum non-overlapping deliveries.
**Skills:** `/shorts Greedy vs DP`, `/explain When Greedy Fails`
**Revision Focus:** Greedy ≠ always correct. Prove greedy works by exchange argument or contradiction. Activity selection = sort by end time. If greedy fails, try DP.
**LeetCode Bridge:** #435 Non-overlapping Intervals (Medium), #56 Merge Intervals (Medium)

---

### Day 42 | Week 7 | Spring Modulith → Microservices
**Topic:** Module Boundaries, @ApplicationModule, Service Splitting
**Concept:**
- Modulith: monolith with enforced module boundaries (Spring Modulith)
- @ApplicationModule: declare module dependencies, verify at test time
- Inter-module communication: ApplicationEvents (in-process), Kafka (cross-service)
- When to split: independent scaling, team ownership, different data stores
**Practical:** Refactor NexCommerce into modules — user, product, order, payment — with clear API boundaries.
**NexCommerce:** Architecture evolution — from monolith to modular monolith to microservices.
**Skills:** `/explain Monolith to Microservices`, `/pdd Microservices`
**Revision Focus:** Start monolith, modularize, then split. Premature microservices = distributed monolith = worst of both worlds. Module boundaries = future service boundaries.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Trace the knapsack DP table on paper. Review all DP patterns (1D, 2D, knapsack). Validate module boundaries in code.

---

## Week 8 — Two Pointers + Sliding Window + API Gateway

### Day 43 | Week 8 | Two Pointers
**Topic:** Pair Sum, Three Sum, Container With Most Water
**Concept:**
- Two pointers on sorted array: start from both ends, converge
- Pair sum: if sum < target, move left++; if sum > target, move right--
- Three sum: fix one, two-pointer on rest. Skip duplicates
- Container with most water: move the shorter pointer inward
**Practical:** Solve pair sum (sorted) + container with most water.
**NexCommerce:** Data deduplication — two pointers on sorted duplicate records in analytics pipeline.
**Skills:** `/shorts Two Pointers`, `/explain Two Pointer Technique`
**Revision Focus:** Two pointers work on SORTED data (or when order has meaning). Container with most water: width decreases, so we need height to increase — move shorter side.
**LeetCode Bridge:** #167 Two Sum II (Medium), #11 Container With Most Water (Medium)

---

### Day 44 | Week 8 | Sliding Window Fixed
**Topic:** Max Sum of K-size Window, Max of All K-size Windows
**Concept:**
- Fixed window: add right element, remove left element as window slides
- Max sum of size K: maintain running sum, update max
- Max of all windows (sliding window maximum): use Deque to maintain decreasing order
- Deque approach: remove smaller elements from back, remove expired from front
**Practical:** Solve max sum of K-size subarray + sliding window maximum using Deque.
**NexCommerce:** Rolling average order value — dashboard shows 7-day rolling average.
**Skills:** `/shorts Sliding Window Fixed`, `/explain Monotonic Deque`
**Revision Focus:** Fixed window = add right, remove left, O(n). Monotonic deque keeps candidates in decreasing order — O(n) for max of all windows. Deque front = current window max.
**LeetCode Bridge:** #643 Maximum Average Subarray (Easy), #239 Sliding Window Maximum (Hard)

---

### Day 45 | Week 8 | Sliding Window Variable
**Topic:** Min Window Substring, Longest Unique Substring, Smallest Subarray ≥ Target
**Concept:**
- Variable window: expand right until condition met, shrink left while condition holds
- Template: `while (right < n) { expand; while (valid) { update answer; shrink left; } }`
- Min window substring: frequency map matching, track "formed" count
- Smallest subarray with sum ≥ target: running sum, shrink when sum ≥ target
**Practical:** Solve longest substring without repeating + smallest subarray with sum ≥ target.
**NexCommerce:** Rate limiting window calculation — count requests in variable time windows.
**Skills:** `/explain Variable Sliding Window`, `/revise Sliding Window`
**Revision Focus:** Variable window template is universal — memorize it. Expand right always, shrink left conditionally. Use HashMap for character counts. Two pointers never backtrack → O(n).
**LeetCode Bridge:** #3 Longest Substring Without Repeating (Medium), #76 Minimum Window Substring (Hard)

---

### Day 46 | Week 8 | Prefix Sum
**Topic:** Range Sum, Subarray Sum = K, Product Except Self
**Concept:**
- Prefix sum array: `prefix[i] = sum(arr[0..i])`. Range sum(l,r) = prefix[r] - prefix[l-1]
- Subarray sum = K: for each prefix[i], check if `prefix[i] - K` exists in HashMap → O(n)
- Product except self: left-product array × right-product array, no division
- Prefix technique transforms range queries from O(n) to O(1)
**Practical:** Solve range sum query + subarray sum equals K.
**NexCommerce:** Revenue calculation for date ranges — "total revenue from March to May" in O(1).
**Skills:** `/shorts Prefix Sum`, `/explain Prefix Sum Applications`
**Revision Focus:** Prefix sum = precompute cumulative sums. Subarray sum = K uses HashMap of prefix sums — key insight is `prefix[j] - prefix[i] = K`. O(n) time, O(n) space.
**LeetCode Bridge:** #303 Range Sum Query (Easy), #560 Subarray Sum Equals K (Medium)

---

### Day 47 | Week 8 | System Design Fundamentals
**Topic:** Load Balancing, Caching, CAP Theorem
**Concept:**
- Load balancing: round robin, least connections, consistent hashing, health checks
- Caching: write-through (write to cache + DB), write-back (write to cache, async to DB), write-around (write to DB only)
- CAP theorem: Consistency + Availability + Partition tolerance — pick 2 (really: CP or AP during partition)
- Cache invalidation strategies: TTL, event-based, LRU eviction
**Practical:** No code — whiteboard/diagram session. Design NexCommerce's caching and load balancing strategy.
**NexCommerce:** Platform-level architecture decisions — where to cache, how to balance load.
**Skills:** `/explain CAP Theorem`, `/shorts Caching Strategies`
**Revision Focus:** CAP: during network partition, choose consistency (reject writes) or availability (serve stale). Write-through = safe but slow. Write-back = fast but risk data loss. Most systems are AP with eventual consistency.
**LeetCode Bridge:** N/A

---

### Day 48 | Week 8 | API Gateway + Spring Cloud Gateway
**Topic:** Routes, Predicates, Filters, Rate Limiting
**Concept:**
- API Gateway: single entry point, handles cross-cutting concerns
- Spring Cloud Gateway: route = predicate (when to match) + filters (what to modify)
- Filters: AddRequestHeader, RewritePath, CircuitBreaker, RequestRateLimiter
- Rate limiting with Redis: token bucket per API key
**Practical:** Build API Gateway service — route `/api/users/**` to User Service, `/api/products/**` to Product Service.
**NexCommerce:** Single entry point for all client requests — mobile, web, third-party.
**Skills:** `/guide Spring Cloud Gateway`, `/pdd API Gateway`
**Revision Focus:** Gateway handles: routing, auth, rate limiting, logging, CORS — don't duplicate in services. Predicates match requests. Filters transform requests/responses. Gateway is the chokepoint — must be resilient.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Review all sliding window patterns. Draw the NexCommerce architecture diagram with API Gateway. Revisit prefix sum.

---

# MONTH 3: PRODUCTION (Weeks 9–12)

---

## Week 9 — Trie + Advanced Trees + Resilience

### Day 49 | Week 9 | Trie
**Topic:** TrieNode, Insert, Search, Autocomplete
**Concept:**
- TrieNode: `children[26]` (or HashMap), `isEndOfWord` flag
- Insert: traverse/create nodes character by character, mark end
- Search: traverse nodes, return true only if end-of-word reached
- Autocomplete: find prefix node, DFS to collect all words below it
**Practical:** Build `Trie` from scratch — insert, search, startsWith, autocomplete(prefix) returning top results.
**NexCommerce:** Product search autocomplete — type "lap" → suggest "laptop", "laptop stand", "laptop bag."
**Skills:** `/explain Trie`, `/shorts Trie vs HashMap for Prefix Search`
**Revision Focus:** Trie = O(m) per operation where m = word length. Space-intensive but unbeatable for prefix operations. Autocomplete = prefix traversal + DFS collection.
**LeetCode Bridge:** #208 Implement Trie (Medium), #211 Design Add and Search Words (Medium)

---

### Day 50 | Week 9 | Segment Tree
**Topic:** Build, Range Query, Point Update
**Concept:**
- Segment tree: binary tree where each node stores aggregate of a range
- Build: recursive, split range in half, O(n)
- Range query (sum/min/max): traverse relevant segments, O(log n)
- Point update: update leaf, propagate up, O(log n)
**Practical:** Build `SegmentTree` for range sum queries + point updates.
**NexCommerce:** Price range aggregate queries — "sum of all product prices in Electronics category" with real-time updates.
**Skills:** `/explain Segment Tree`, `/shorts Segment Tree vs Prefix Sum`
**Revision Focus:** Segment tree = O(n) build, O(log n) query + update. Use when you need BOTH range queries AND updates. If only queries (no updates), prefix sum is simpler.
**LeetCode Bridge:** #307 Range Sum Query - Mutable (Medium), #303 Range Sum Query - Immutable (Easy — comparison)

---

### Day 51 | Week 9 | Balanced Trees Concepts
**Topic:** AVL Rotations, Red-Black Tree, Java TreeMap
**Concept:**
- AVL: height difference ≤ 1 at every node. Rotations: LL, RR, LR, RL
- Red-Black: relaxed balance — no two consecutive reds, black-height uniform
- AVL = stricter balance = faster reads, more rotations on writes
- Java TreeMap/TreeSet use Red-Black trees internally
**Practical:** Theory day — diagram all 4 AVL rotations. Read Java TreeMap source code's put() method.
**NexCommerce:** Understanding sorted data access patterns — price-sorted product navigation.
**Skills:** `/shorts AVL vs Red-Black`, `/explain AVL Rotations`
**Revision Focus:** AVL = faster lookups (stricter balance). Red-Black = faster inserts/deletes (fewer rotations). In practice, use TreeMap — don't implement balanced trees from scratch.
**LeetCode Bridge:** #110 Balanced Binary Tree (Easy), #108 Convert Sorted Array to BST (Easy)

---

### Day 52 | Week 9 | Circuit Breaker
**Topic:** Resilience4j CircuitBreaker — States, Fallbacks
**Concept:**
- States: Closed (normal) → Open (failing, reject calls) → Half-Open (test recovery)
- Failure rate threshold: e.g., 50% failures in last 10 calls → trip to Open
- Fallback methods: return cached data, default response, or graceful degradation
- Sliding window: count-based vs time-based failure tracking
**Practical:** Add CircuitBreaker to Payment Service calling external payment gateway — fallback returns "payment pending."
**NexCommerce:** Payment gateway resilience — don't cascade failures to the entire platform.
**Skills:** `/explain Circuit Breaker Pattern`, `/pdd Circuit Breaker`
**Revision Focus:** Without circuit breaker: one failing service kills all services (cascading failure). Open state = fast-fail (don't waste resources on known-broken calls). Half-open = controlled recovery test.
**LeetCode Bridge:** N/A

---

### Day 53 | Week 9 | Rate Limiter
**Topic:** Token Bucket, Sliding Window, Fixed Window
**Concept:**
- Token bucket: tokens refill at fixed rate, each request consumes a token
- Fixed window: count requests per fixed time window (boundary burst problem)
- Sliding window log: track each request timestamp, count within window
- Sliding window counter: hybrid — less memory than log, smoother than fixed
**Practical:** Implement sliding window rate limiter from scratch in Java — `boolean allowRequest(String userId)`.
**NexCommerce:** API rate limiting — 100 requests/minute per user to prevent abuse.
**Skills:** `/explain Rate Limiting Algorithms`, `/shorts Token Bucket vs Sliding Window`
**Revision Focus:** Token bucket = smoothest, used by most cloud providers. Fixed window = simple but allows 2x burst at boundary. Sliding window log = most accurate but memory-heavy. Choose based on accuracy vs resource tradeoff.
**LeetCode Bridge:** N/A

---

### Day 54 | Week 9 | CQRS + Event Sourcing
**Topic:** Command/Query Separation, Event Store, Projections
**Concept:**
- CQRS: separate write model (commands) from read model (queries) — different schemas
- Event sourcing: store events, not current state. State = replay all events
- Projections: materialized views built from event stream for fast reads
- Replay: rebuild state from scratch by replaying events (audit + debugging)
**Practical:** Implement event sourcing for Order lifecycle: OrderCreated → OrderPaid → OrderShipped → OrderDelivered. Rebuild Order state from events.
**NexCommerce:** Order audit trail — complete history of every state change, replayable.
**Skills:** `/explain Event Sourcing`, `/pdd CQRS`
**Revision Focus:** Event sourcing = append-only log of facts. Never update, never delete. Current state = fold over events. CQRS lets read/write scale independently. Eventual consistency between command and query sides.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Review Trie autocomplete flow. Trace circuit breaker state transitions. Replay your event-sourced order lifecycle.

---

## Week 10 — Advanced Graphs + Observability

### Day 55 | Week 10 | Bellman-Ford
**Topic:** Negative Weights, Relaxation, Negative Cycle Detection
**Concept:**
- Relaxation: for every edge (u,v,w), if `dist[u] + w < dist[v]`, update dist[v]
- Run V-1 iterations of relaxation over ALL edges
- V-th iteration: if any edge still relaxes → negative cycle exists
- Time: O(V×E) — slower than Dijkstra but handles negative weights
**Practical:** Implement Bellman-Ford from scratch. Test with graph containing negative edges.
**NexCommerce:** Detecting arbitrage in multi-currency pricing — negative cycle = profit loop.
**Skills:** `/explain Bellman-Ford`, `/shorts Dijkstra vs Bellman-Ford`
**Revision Focus:** Bellman-Ford = V-1 relaxation passes over ALL edges. Handles negative weights (Dijkstra can't). Negative cycle detection with V-th pass. O(V×E) — use only when negative weights exist.
**LeetCode Bridge:** #787 Cheapest Flights (Medium — Bellman-Ford variant)

---

### Day 56 | Week 10 | Minimum Spanning Tree
**Topic:** Prim's (PQ-based), Kruskal's (Union-Find-based)
**Concept:**
- MST: connect all vertices with minimum total edge weight, no cycles
- Prim's: grow tree from a starting vertex, always add cheapest edge to new vertex
- Kruskal's: sort all edges, add cheapest that doesn't create cycle (union-find check)
- Both produce same MST weight (MST may not be unique)
**Practical:** Implement Kruskal's using your UnionFind class from Day 35.
**NexCommerce:** Minimum cost delivery network — connect all warehouses with minimum infrastructure cost.
**Skills:** `/explain Prim's vs Kruskal's`, `/shorts MST`
**Revision Focus:** Kruskal's = sort edges + union-find. Prim's = priority queue + visited set. Kruskal's better for sparse graphs (E-driven). Prim's better for dense (V-driven).
**LeetCode Bridge:** #1584 Min Cost to Connect All Points (Medium), #1135 Connecting Cities (Medium)

---

### Day 57 | Week 10 | Bit Manipulation
**Topic:** AND/OR/XOR, Power of 2, Count Bits, Bitmask
**Concept:**
- XOR properties: `a ^ a = 0`, `a ^ 0 = a` — single number trick
- Power of 2: `n > 0 && (n & (n-1)) == 0`
- Count set bits: `n & (n-1)` drops lowest set bit — count iterations
- Bit masking: represent sets as integers, use AND/OR for set operations
**Practical:** Solve single number (XOR) + count set bits (Brian Kernighan's algorithm).
**NexCommerce:** Feature flags using bitmasks — `int flags = PREMIUM | VERIFIED | SELLER` for user roles.
**Skills:** `/shorts Bit Manipulation`, `/trick Bit Manipulation`
**Revision Focus:** XOR is the king of bit tricks — find single element, swap without temp. `n & (n-1)` removes lowest set bit — use for power-of-2 check and bit counting.
**LeetCode Bridge:** #136 Single Number (Easy), #191 Number of 1 Bits (Easy)

---

### Day 58 | Week 10 | Bloom Filter
**Topic:** Probabilistic DS, Multiple Hash Functions, False Positive Rate
**Concept:**
- Bloom filter: bit array + K hash functions. Insert = set K bits. Query = check K bits
- False positive possible (all K bits set by other elements), false negative NEVER
- No delete (unless counting bloom filter)
- Optimal K = (m/n) × ln(2), where m = bits, n = elements
**Practical:** Build `BloomFilter` from scratch — add, mightContain, estimate false positive rate.
**NexCommerce:** Duplicate order detection — quickly check "have we seen this order ID before?" without DB lookup.
**Skills:** `/explain Bloom Filter`, `/pdd Bloom Filter`
**Revision Focus:** Bloom filter = space-efficient "maybe yes, definitely no." Used in databases (avoid disk reads), CDNs, spam filters. Trade accuracy for speed + space.
**LeetCode Bridge:** N/A

---

### Day 59 | Week 10 | Consistent Hashing
**Topic:** Hash Ring, Virtual Nodes, Minimal Redistribution
**Concept:**
- Hash ring: map both servers and keys to positions on a circular ring
- Key maps to the next server clockwise on the ring
- Virtual nodes: each server gets multiple positions → better distribution
- Add/remove server: only K/N keys need redistribution (minimal disruption)
**Practical:** Build `ConsistentHashRing` from scratch — addNode, removeNode, getNode(key), with virtual nodes.
**NexCommerce:** Distributed cache partitioning — shard product cache across multiple Redis instances.
**Skills:** `/explain Consistent Hashing`, `/shorts Consistent Hashing vs Modulo`
**Revision Focus:** Modulo hashing: add 1 server → almost ALL keys move. Consistent hashing: only 1/N keys move. Virtual nodes fix hotspot problem. Used by Cassandra, DynamoDB, Memcached.
**LeetCode Bridge:** N/A

---

### Day 60 | Week 10 | Distributed Tracing + Logging
**Topic:** Correlation IDs, MDC, Structured Logging, Micrometer
**Concept:**
- Correlation ID: UUID passed through all services via headers for request tracing
- MDC (Mapped Diagnostic Context): thread-local map, auto-included in log lines
- Structured logging: JSON log format for machine parsing (ELK stack ready)
- Micrometer: metrics library — counters, gauges, timers, percentiles
**Practical:** Add correlation IDs + structured JSON logging to all NexCommerce services. Add Micrometer timer to order processing.
**NexCommerce:** Observability stack — trace any request across all microservices.
**Skills:** `/guide Structured Logging`, `/explain MDC`
**Revision Focus:** Without correlation IDs, debugging distributed systems is impossible. MDC auto-populates log fields per thread. Structured logging (JSON) > free-text logs. Micrometer is the Spring Boot metrics standard.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Trace Bellman-Ford on paper with negative edges. Review bloom filter math. Test correlation ID flow across services.

---

## Week 11 — String Algorithms + LRU Cache + Containerization

### Day 61 | Week 11 | KMP Algorithm
**Topic:** Failure Function, O(n+m) Pattern Matching
**Concept:**
- Naive substring search: O(n×m) — backtrack on mismatch
- KMP: precompute LPS (Longest Proper Prefix which is also Suffix) array
- On mismatch: use LPS to skip comparisons (never backtrack in text)
- Time: O(n+m) for preprocessing + searching
**Practical:** Implement KMP from scratch — build LPS array + search function.
**NexCommerce:** Log pattern matching for anomaly detection — find error patterns in streaming logs.
**Skills:** `/explain KMP Algorithm`, `/shorts KMP`
**Revision Focus:** KMP's power is the LPS array — it tells you "how far back to jump in the pattern." Never re-scan text characters. O(n+m) is optimal for single-pattern search.
**LeetCode Bridge:** #28 Find the Index of the First Occurrence (Easy — KMP approach)

---

### Day 62 | Week 11 | Rabin-Karp
**Topic:** Rolling Hash, Hash-based Pattern Matching
**Concept:**
- Hash the pattern. Slide a window over text, compute hash of each window
- Rolling hash: remove leftmost char's contribution, add rightmost char's
- Hash collision: on hash match, verify character-by-character (to avoid false positives)
- Average O(n+m), worst O(n×m) if many collisions
**Practical:** Implement Rabin-Karp from scratch with polynomial rolling hash.
**NexCommerce:** Plagiarism detection in product descriptions — find copied text across listings.
**Skills:** `/explain Rabin-Karp`, `/shorts KMP vs Rabin-Karp`
**Revision Focus:** Rabin-Karp = hash-based sliding window. Good for multi-pattern search (hash each pattern). Rolling hash updates in O(1). Choose good base and mod to minimize collisions.
**LeetCode Bridge:** #28 Find the Index (Easy — Rabin-Karp approach), #187 Repeated DNA Sequences (Medium)

---

### Day 63 | Week 11 | LRU Cache
**Topic:** HashMap + DoublyLinkedList, O(1) Get/Put
**Concept:**
- LRU eviction: remove least recently used item when cache is full
- HashMap: O(1) key → node lookup. DoublyLinkedList: O(1) move-to-front, remove-tail
- Get: move accessed node to front (most recent)
- Put: insert at front; if over capacity, remove tail (least recent)
**Practical:** Build production-grade `LRUCache<K,V>` — get(key), put(key, value), O(1) both.
**NexCommerce:** Hot product data cache — cache top-accessed products, evict cold ones.
**Skills:** `/explain LRU Cache Design`, `/pdd LRU Cache`
**Revision Focus:** LRU = HashMap + DoublyLinkedList. HashMap for O(1) access, DLL for O(1) recency updates. This is the most-asked design question in interviews. Sentinel nodes simplify edge cases.
**LeetCode Bridge:** #146 LRU Cache (Medium)

---

### Day 64 | Week 11 | Podman Basics
**Topic:** Containerfile, Multi-stage Builds, Image Layers
**Concept:**
- Containerfile (= Dockerfile): FROM, COPY, RUN, EXPOSE, ENTRYPOINT
- Multi-stage build: builder stage (Maven + JDK) → runtime stage (JRE only) — smaller images
- Image layers: each instruction creates a layer, order matters for caching
- `podman build`, `podman run`, `podman exec`, `podman logs`
**Practical:** Write multi-stage Containerfile for User Service. Build and run with Podman.
**NexCommerce:** Service containerization — every service runs in its own container.
**Skills:** `/guide Podman Containerization`, `/pdd Containers`
**Revision Focus:** Multi-stage builds: build with JDK (fat), run with JRE (slim). COPY before RUN for layer caching. .containerignore = .dockerignore. Podman is rootless and daemonless — more secure than Docker.
**LeetCode Bridge:** N/A

---

### Day 65 | Week 11 | Podman Compose
**Topic:** Multi-service Orchestration, Networking, Volumes
**Concept:**
- podman-compose.yml: define all services, networks, volumes in one file
- Service discovery: containers on same network resolve by service name
- Volumes: persist data outside containers (databases, config)
- Health checks: ensure dependencies are ready before starting dependent services
**Practical:** Write podman-compose.yml for full NexCommerce stack — User, Product, Order services + PostgreSQL + MongoDB + Kafka.
**NexCommerce:** Local orchestration — entire platform runs with one command.
**Skills:** `/guide Podman Compose`, `/explain Container Networking`
**Revision Focus:** Compose = infrastructure-as-code for local dev. Named networks for service isolation. Volumes for data persistence. `depends_on` + health checks prevent startup race conditions.
**LeetCode Bridge:** N/A

---

### Day 66 | Week 11 | Helm Charts
**Topic:** Chart Structure, values.yaml, Templates, Releases
**Concept:**
- Helm = package manager for Kubernetes. Chart = package of K8s manifests
- Chart structure: Chart.yaml, values.yaml, templates/ (Deployment, Service, ConfigMap)
- Values: parameterize templates — {{ .Values.image.tag }}, override per environment
- `helm install`, `helm upgrade`, `helm rollback`, `helm list`
**Practical:** Create Helm chart for User Service — Deployment, Service, ConfigMap, Ingress templates.
**NexCommerce:** Deployment configuration — Helm charts for every service.
**Skills:** `/guide Helm Charts`, `/explain Helm Templating`
**Revision Focus:** Helm charts = reusable, versioned deployment packages. values.yaml = environment-specific config. Templates use Go templating. Rollback to any previous release instantly.
**LeetCode Bridge:** N/A

---

> 🛑 **REST DAY** — Review LRU Cache implementation. Verify podman-compose brings up entire stack. Test Helm chart locally with minikube/kind.

---

## Week 12 — System Design + Production Hardening + Capstone

### Day 67 | Week 12 | Design: URL Shortener
**Topic:** Full System Design — Hashing, Base62, DB, Cache, Scale
**Concept:**
- Functional: shorten URL, redirect, analytics (click count)
- Encoding: hash (MD5/SHA) → take first 7 chars, OR auto-increment ID → base62
- Database: key-value store (short → long URL), cache popular URLs (Redis)
- Scale: read-heavy (100:1 ratio), partition by hash range, CDN for redirects
**Practical:** Whiteboard design + implement base62 encode/decode + URL storage with redirect.
**NexCommerce:** Short URLs for sharing products — `nexcom.me/p/Ab3xY` → full product page.
**Skills:** `/explain URL Shortener Design`, `/shorts Base62 Encoding`
**Revision Focus:** URL shortener = great intro system design. Key decisions: hash vs auto-increment, collision handling, read-heavy caching. 7-char base62 = 62⁷ ≈ 3.5 trillion unique URLs.
**LeetCode Bridge:** #535 Encode and Decode TinyURL (Medium)

---

### Day 68 | Week 12 | Design: Distributed Rate Limiter
**Topic:** Redis-based, Sliding Window at Scale
**Concept:**
- Why local rate limiter fails: multiple instances = each allows full limit
- Redis centralized counter: atomic INCR + EXPIRE, shared across instances
- Sliding window log in Redis: sorted set of timestamps per user
- Race conditions: Lua scripts for atomic check-and-increment
**Practical:** Design document + implement distributed rate limiter concept using Redis-like pseudocode.
**NexCommerce:** API gateway rate limiting at scale — works across all gateway instances.
**Skills:** `/explain Distributed Rate Limiting`, `/shorts Redis Lua Scripts`
**Revision Focus:** Distributed = shared state. Redis sorted sets for sliding window. Lua scripts prevent race conditions. Always decide: reject (429) or queue (throttle) on limit breach.
**LeetCode Bridge:** N/A

---

### Day 69 | Week 12 | Design: Notification System
**Topic:** Push/Email/SMS, Fan-out, Retry with Backoff
**Concept:**
- Multi-channel: push notification, email (SMTP), SMS (API). User preferences
- Fan-out: one event → multiple notifications (Kafka consumer per channel)
- Priority queue: critical (payment failed) > normal (order shipped) > marketing
- Retry with exponential backoff: 1s → 2s → 4s → 8s → give up
**Practical:** Design document + implement notification dispatcher with channel routing and retry logic.
**NexCommerce:** Order status notifications — "Your order has shipped!" via preferred channel.
**Skills:** `/explain Notification System Design`, `/shorts Exponential Backoff`
**Revision Focus:** Notification = async by nature. Use message queue (Kafka) for decoupling. Template engine for message formatting. Retry with backoff + dead letter queue for permanent failures.
**LeetCode Bridge:** N/A

---

### Day 70 | Week 12 | JVM Tuning
**Topic:** GC Algorithms, Heap Sizing, Thread Dumps, Memory Leaks
**Concept:**
- G1GC: default since Java 9, region-based, predictable pause times
- ZGC: ultra-low latency (<1ms pauses), good for large heaps
- Heap sizing: -Xms (initial) = -Xmx (max) in production to avoid resize
- GC logs: `-Xlog:gc*`, analyze with GCEasy. Thread dumps: `jstack <pid>`
**Practical:** Run NexCommerce services with explicit JVM flags. Enable GC logging. Analyze GC output.
**NexCommerce:** Production JVM configuration — right GC + heap size for each service profile.
**Skills:** `/explain JVM Garbage Collection`, `/shorts G1GC vs ZGC`
**Revision Focus:** Set Xms = Xmx in production. G1GC for general workloads. ZGC for low-latency requirements. GC logs are your first tool for memory issues. Thread dumps for deadlock/hang diagnosis.
**LeetCode Bridge:** N/A

---

### Day 71 | Week 12 | Database Optimization
**Topic:** EXPLAIN ANALYZE, Indexes, Connection Pooling, Query Tuning
**Concept:**
- PostgreSQL EXPLAIN ANALYZE: shows actual execution plan, row estimates vs reality
- Index types: B-tree (default, range), Hash (equality only), GIN (full-text/arrays), GiST (geometry)
- HikariCP: connection pool tuning — minimumIdle, maximumPoolSize, connectionTimeout
- MongoDB indexes: compound indexes, covered queries, explain().executionStats()
**Practical:** Add indexes to User and Order tables. Run EXPLAIN ANALYZE before/after. Tune HikariCP pool size.
**NexCommerce:** Database performance — sub-10ms queries for all critical paths.
**Skills:** `/explain PostgreSQL EXPLAIN`, `/shorts Database Indexing`
**Revision Focus:** Always EXPLAIN before adding indexes. Too many indexes slow writes. HikariCP pool size ≈ (2 × CPU cores) + disk spindles. Covering index = query answered entirely from index.
**LeetCode Bridge:** N/A

---

### Day 72 | Week 12 | Capstone Review
**Topic:** Full Architecture Walkthrough + Mock Review
**Concept:**
- Present NexCommerce end-to-end: services, data flow, scaling strategy
- Mock system design interview: defend architectural choices
- Code roast: review code quality across all services
- Production readiness checklist: logging, monitoring, circuit breakers, health checks, security
**Practical:** Present NexCommerce as if in a senior engineer architecture review. Use `/roast` on key files. Use `/mock-interview System Design`.
**NexCommerce:** Final system review — is this production-ready?
**Skills:** `/roast`, `/mock-interview NexCommerce Architecture`, `/revise System Design`
**Revision Focus:** Can you explain every architectural decision? Can you defend your technology choices? Can you identify the weakest links in your system? That's production readiness.
**LeetCode Bridge:** N/A

---

> 🏁 **PLAN COMPLETE.** You've covered 72 days of DSA + Spring Boot + Microservices + DevOps, all mapped to NexCommerce. Run `/roadmap` to see your progress.

---

## Quick Reference: Skill Commands

| Command | Purpose |
|---------|---------|
| `/shorts <topic>` | High-density conceptual breakdown |
| `/explain <topic>` | Deep-dive into any engineering topic |
| `/pdd <topic>` | Pain-Driven Development — why this tool exists |
| `/guide <topic>` | Step-by-step setup and implementation |
| `/revise <topic>` | Active recall — test your understanding |
| `/trick <topic>` | Adversarial traps to expose misconceptions |
| `/project <scenario>` | Micro-project for hands-on practice |
| `/mock-interview <topic>` | Simulated technical interview |
| `/mock-test <scenario>` | Production incident simulation |
| `/roast` | Brutal code review of active file |
| `/roadmap` | View overall progress and gaps |
