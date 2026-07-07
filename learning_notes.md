# 📝 Learning Notes & Missed Concepts

This file is your personalized handbook of concepts you missed or got partially wrong during our `/trick` and `/master` sessions. Review this regularly to prepare for `/revise` checks.

---

## 🗂️ Table of Contents
1. [Core Java: Integer Caching](#1-core-java-integer-caching)
2. [Core Java: Operator Associativity](#2-core-java-operator-associativity)
3. [DSA: Complexity Bounds & Loops](#3-dsa-complexity-bounds--loops)
4. [DSA: Recursion Memory Limits](#4-dsa-recursion-memory-limits)
5. [DSA: Amortized Latency Jitter](#5-dsa-amortized-latency-jitter)
6. [System Design: Low-Latency Data Structures](#6-system-design-low-latency-data-structures)
7. [DSA: Dynamic Array Right-Shift & Capacity Guards](#7-dsa-dynamic-array-right-shift--capacity-guards)
8. [Core Java: Primitive Varargs & Generics](#8-core-java-primitive-varargs--generics)
9. [Core Java: ArrayList Resizing Sizing Threshold](#9-core-java-arraylist-resizing-sizing-threshold)
10. [DSA: Array Algorithms Tradeoffs](#10-dsa-array-algorithms-tradeoffs)

---

## 1. Core Java: Integer Caching
* **Session Date:** 2026-07-02 (`/trick`)

### The Question
What does the following snippet print and why?
```java
Integer a = 127;
Integer b = 127;
Integer c = 128;
Integer d = 128;
System.out.println(a == b);
System.out.println(c == d);
```

### ❌ Your Answer
`two false` — because `==` compares reference value/object address, not content.

### 🔬 The Correct Answer & Explanation
Output:
```text
true
false
```
*   **Why `a == b` is `true`:** The Java compiler uses `Integer.valueOf(127)` for autoboxing. The JVM pre-caches `Integer` objects for values between **-128 and 127** in `IntegerCache` during startup. Both references point to the exact same cached object in memory.
*   **Why `c == d` is `false`:** `128` falls outside the cache range, so `Integer.valueOf(128)` allocates a new `Integer` object instance on each call. The references point to different addresses.
*   **Other Types:** `Byte`, `Short`, `Long`, and `Character` (from 0 to 127) also implement wrapper caching.

### 🧲 Memory Anchor
> *"`==` on Integer tells the truth 256 times (-128 to 127), then starts lying. Use `.equals()` every single time."*

---

## 2. Core Java: Operator Associativity
* **Session Date:** 2026-07-02 (`/trick`)

### The Question
What is the output of the following lines?
```java
System.out.println(1 + 2 + "3");
System.out.println("1" + 2 + 3);
```

### ❌ Your Answer
`33` and `15`

### 🔬 The Correct Answer & Explanation
Output:
```text
33
123
```
*   **Why `"1" + 2 + 3` is `"123"`:** The `+` operator in Java evaluates strictly **left-to-right** (left-associative). 
    1. `"1" + 2` is evaluated first, producing the string `"12"`.
    2. `"12" + 3` is evaluated next, producing the string `"123"`.
    Once a `String` operand appears in a `+` chain, **all subsequent operations become string concatenations**.
*   **How to get `15`:** You must use parentheses to override associativity: `"1" + (2 + 3)`.

### 🧲 Memory Anchor
> *"The `+` operator walks left to right. The first `String` it touches is the point of no return—everything after it becomes concatenation."*

---

## 3. DSA: Complexity Bounds & Loops
* **Session Date:** 2026-07-05 (`/master`)

### The Questions
What is the time complexity of the following patterns?
1. **Pattern A:** You divide a number $N$ by 3 until it becomes $\le 1$.
2. **Pattern B:** A loop runs from $1$ to $N$. Inside, it calls a function running from $1$ to $\log N$.
3. **Pattern C:** A recursive function splits input in half, calls itself on both halves, and performs a linear scan $O(N)$ to merge.

### ❌ Your Answers
*   Pattern A: $O(n)$
*   Pattern B: $O(n^2)$
*   Pattern C: $O(n)$

### 🔬 The Correct Answers & Explanation
1.  **Pattern A is $O(\log N)$:** Any loop where the search space or input size is divided by a constant factor (like 3) at each step scales **logarithmically**.
2.  **Pattern B is $O(n \log n)$:** The outer loop executes $N$ times. For each iteration, the inner loop runs $\log N$ times. The operations multiply: $N \times \log N = O(n \log n)$.
3.  **Pattern C is $O(n \log n)$:** This is the recursive equation for **Merge Sort**: $T(N) = 2T(N/2) + O(N)$. The recursion tree has $\log N$ levels, and each level performs $O(N)$ total merge work, resulting in $O(n \log n)$.

---

## 4. DSA: Recursion Memory Limits
* **Session Date:** 2026-07-05 (`/master`)

### The Question
What exception is thrown if a recursive function runs 20,000 levels deep?

### ❌ Your Answer
`OutOfMemoryError`

### 🔬 The Correct Answer & Explanation
The JVM throws a **`java.lang.StackOverflowError`**.
*   **Why:** Each method invocation pushes a frame onto the thread's execution call stack. Stack space is highly restricted (default is usually 1MB per thread, configured via the `-Xss` flag). When call frames exceed this limit, the JVM triggers a stack overflow.
*   **Contrast:** `OutOfMemoryError` occurs when the JVM's **Heap memory** (where objects are allocated via `new`) runs out of space.

---

## 5. DSA: Amortized Latency Jitter
* **Session Date:** 2026-07-06 (`/master`)

### The Question
If an operation has an amortized complexity of $O(1)$ (like `ArrayList.add()`), is it possible for a single insertion call to take 5 seconds?

### ❌ Your Answer
*"here it does not mean time, it means even the input grows, it will work in amortized constant time."* (Implying no)

### 🔬 The Correct Answer & Explanation
**Yes**, a single insertion can easily take 5 seconds.
*   **Amortized vs. Worst-Case:** Amortized complexity guarantees that the **average** cost of a sequence of operations is constant. It does *not* place a time limit on any individual call. 
*   **The Cause:** If you insert into a dynamic array that is full and requires copying millions of elements, or if the copy operation triggers a JVM garbage collection freeze, that specific write call will block the execution thread for a long time.

### 🧲 Memory Anchor
> *"Amortized complexity guarantees you won't go broke over a long journey, but it doesn't stop you from running out of cash on any single day."*

---

## 6. System Design: Low-Latency Data Structures
* **Session Date:** 2026-07-06 (`/master`)

### The Question
If you are designing a low-latency trading matching engine where execution must be under 10 microseconds, why is a resizing `ArrayList` dangerous, and what would you use instead?

### ❌ Your Answer
Use a `HashMap` instead because resizing arraylist will cause thread blocking.

### 🔬 The Correct Answer & Explanation
A standard `HashMap` is **worse** than an `ArrayList` in low-latency environments:
1.  **Resizing/Rehashing:** A `HashMap` also resizes periodically, causing extreme latency spikes when redistributing keys.
2.  **Pointer Chasing:** `HashMap` entries are stored as heap-allocated `Node` objects. Traversing them requires chasing memory pointers, causing CPU **cache misses** as the processor waits for RAM.
3.  **Low-Latency Solution:** Use a **Fixed-Size Ring Buffer** (circular array) pre-allocated at application startup. 
    *   It never resizes (no allocation on the hot path).
    *   Data is stored contiguously in memory, ensuring $O(1)$ cache-friendly lookups without pointer chasing.

---

## 7. DSA: Dynamic Array Right-Shift & Capacity Guards
* **Session Date:** 2026-07-06 (`/today` Day 2)

### The Question
Implement index-based insertion (`add(int index, T element)`) and growth bounds (`resize()`) for a custom dynamic array class.

### ❌ Your Answer / Code Mistakes
1.  **Overwrite Bug:** Assigning `data[index] = element` directly without shifting the existing data to the right. This destroys values and leaves `size` unchanged.
2.  **Missing Resize Guard:** Inserting at an index without verifying and growing the capacity first, causing out-of-bound errors.
3.  **Capacity 0 / 1 Math Lock:** Resizing capacity via `(int)(capacity * 1.5)` locks up when capacity is `0` or `1` because `0 * 1.5 = 0` and `1 * 1.5 = 1` (due to integer truncation).

### 🔬 The Correct Answer & Explanation
1.  **Shift-Right:** Call `System.arraycopy(data, index, data, index + 1, size - index)` to shift data right before writing the new element at the index. Increment `size`.
2.  **Resize Check:** Check if `size == capacity` at the start of index-based insertion.
3.  **Resizing bounds:** Handle small capacities with a fallback guard: `capacity = capacity <= 1 ? 10 : (int)(capacity * 1.5)`.

---

## 8. Core Java: Primitive Varargs & Generics
* **Session Date:** 2026-07-06 (`/trick` arrays)

### The Question
What does the following print and why?
```java
int[] primitives = {1, 2, 3};
List<?> list = Arrays.asList(primitives);
System.out.println(list.size());
```

### ❌ Your Answer
`3`

### 🔬 The Correct Answer & Explanation
Output:
```text
1
```
*   **Generics Restriction:** Generics (`List<T>`) only accept **objects**, not primitive types (`int`).
*   **Binding Rule:** An array of primitives (`int[]`) is itself an object, but `int` is not. Since `int` cannot bind to the generic type parameter `T`, the compiler treats the entire `int[]` array as a single object of type `int[]` passed to the varargs parameter.
*   **Result:** A list of size `1` containing the array object itself (`[ [I@hashcode ]`). If you used an object array (`Integer[]`), the list size would be `3`.

### 🧲 Memory Anchor
> *"Generics cannot bind to primitives. `Arrays.asList(int[])` creates a list containing one array object, not a list of numbers."*

---

## 9. Core Java: ArrayList Resizing Sizing Threshold
* **Session Date:** 2026-07-07 (`/today` Day 3 Warmup)

### The Question
How does Java's `ArrayList` calculate its next capacity size when it grows, and what is the growth factor?

### ❌ Your Answer
`1.5` is the growth factor and when it is `90%` filled, it grows its size to 1.5x.

### 🔬 The Correct Answer & Explanation
*   **Trigger:** `ArrayList` resizes ONLY when it is **100% full** (`size == capacity`). Unlike `HashMap`, there is no intermediate load factor/threshold.
*   **Formula:** It grows by **50%** (1.5x) using the bitwise formula: `newCapacity = oldCapacity + (oldCapacity >> 1)`.

---

## 10. DSA: Array Algorithms Tradeoffs
* **Session Date:** 2026-07-07 (`/master` Array Algorithms)

### Key Insights
*   **Modulo Rotation Math:** When rotating an array by $k$ steps, always normalize $k$ using `k = k % N`. This handles cases where $k \ge N$ and prevents `IndexOutOfBoundsException`.
*   **Why $O(n)$ Two Sum is slower than $O(n^2)$ for small $N$ ($N \le 10$):**
    - The HashMap overhead (object allocations, hashing computation, bucket collisions) dominates for small inputs.
    - A brute force $O(n^2)$ scan uses contiguous arrays, loading directly into CPU cache lines with zero heap allocations, executing faster than $O(n)$ HashMap lookups at tiny scales.
*   **Kadane's Negative Bound:** If the array contains only negative numbers (e.g., `[-3, -1, -5]`), Kadane's maximum subarray sum is the maximum single element (`-1`), not `0`. You must initialize `currentMax` and `globalMax` to the first element, not `0`.


