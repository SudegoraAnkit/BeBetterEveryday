
**📅 Day 3 of 72 — 2026-07-16 — Week 1 of 12**

**🎯 Theme:** Complexity + Arrays + Strings + Spring Boot Setup

---

### ⏰ Block 1: Yesterday's Revision (10 min)
*Self-check your memory on the corrected concepts from your recent roast:*
1. **CPU Cache vs. Heap:** What physical mechanism makes sequential reads of primitive arrays `int[]` much faster than reference arrays `Integer[]`?
2. **ArrayList Resize Trigger:** Does an `ArrayList` grow when it is 75% full, 90% full, or 100% full? What bitwise shift operation does it use?
3. **Varargs Binding:** Why does `Arrays.asList(new int[]{1, 2, 3})` return a list of size 1 instead of 3?

---

### 📖 Block 2: Concept Deep-Dive (50 min)
**Topic:** Array Algorithms: Two Sum, Kadane's, and Array Rotation

**Study Objectives:**
- **Two Sum:** Trade space for time. Transition from brute-force $O(n^2)$ search to single-pass $O(n)$ hash mapping.
- **Kadane's Algorithm:** Solve maximum subarray sum in $O(n)$ time. Understand how to decide whether to append to the running sum or start a new subarray.
- **Array Rotation:** Learn the three-step reverse trick to rotate an array in-place with $O(n)$ time and $O(1)$ extra space.

**Recommended commands:**
- `/shorts Kadane's Algorithm`
- `/shorts Rotate Array`

---

### 🔨 Block 3: Practical Hands-On (40 min)
**Task:** Implement the three algorithms inside `ArrayAlgorithms.java`.

**In NexCommerce:** Used in analytics services to calculate maximum profit segments over dates (Kadane's) and optimize product listing matching (Two Sum).

**Steps:**
1. Open or create [ArrayAlgorithms.java](file:///d:/2026/Learning/UsingAntigravity/2.0/BeBetterEveryday/scratch/ArrayAlgorithms.java).
2. Implement the method signatures:
   ```java
   package scratch;

   import java.util.HashMap;
   import java.util.Map;

   public class ArrayAlgorithms {
       // O(n) One-pass HashMap lookup
       public static int[] twoSum(int[] nums, int target) {
           // TODO: Implement
           return new int[0];
       }

       // O(n) Kadane's maximum subarray sum
       public static int maxSubArray(int[] nums) {
           // TODO: Implement
           return 0;
       }

       // O(n) in-place array rotation (3-reverse trick)
       public static void rotate(int[] nums, int k) {
           // TODO: Implement
       }
   }
   ```
3. Test your code using assertions or a main class.

---

### 🧊 Block 4: Cool-Down Revision (20 min)
- Run `/trick arrays` to test for generic traps.
- When done, share your code for verification! I will review it, help you log the completions, and update your tracker.



# 📅 Day 3: Array Algorithms (Two Sum, Kadane's, & Array Rotation)

---

## 🎯 Learning Objectives
1.  **Two Sum:** Transition from brute-force $O(n^2)$ search to single-pass $O(n)$ hash mapping.
2.  **Kadane's Algorithm:** Identify maximum subarray sum in $O(n)$ time. Understand how to decide whether to append to a running sum or start a new subarray.
3.  **Array Rotation:** Rotate an array by $k$ positions in-place with $O(n)$ time complexity and $O(1)$ auxiliary space.

---

## 📖 Under the Hood Algorithms

### 1. Two Sum (One-Pass HashMap)
Rather than checking every pair with nested loops ($O(n^2)$), we scan the array once. At each element $x$, we calculate the complement `target - x`. If the complement exists in our map, we have found our solution. Otherwise, we add $x$ and its index to the map.
- **Time Complexity:** $O(n)$
- **Space Complexity:** $O(n)$

### 2. Kadane's Algorithm (Max Subarray Sum)
Kadane's operates on a single scan. At each index, you decide: *"Do I extend the current subarray, or do I start a new one from this element?"*
- **State Transition:** 
  $$\text{currentMax} = \max(\text{nums}[i], \text{currentMax} + \text{nums}[i])$$
  $$\text{globalMax} = \max(\text{globalMax}, \text{currentMax})$$
- **Time Complexity:** $O(n)$
- **Space Complexity:** $O(1)$

### 3. Array Rotation (Three-Reverse Trick)
To rotate array `[1, 2, 3, 4, 5]` by `k = 2` steps:
1.  **Reverse All:** `[5, 4, 3, 2, 1]`
2.  **Reverse First $k$:** `[4, 5, 3, 2, 1]`
3.  **Reverse Remaining $N-k$:** `[4, 5, 1, 2, 3]`
- **Time Complexity:** $O(n)$
- **Space Complexity:** $O(1)$ in-place.

---

## 🔨 Practical Hands-On Skeleton

**File Path:** `scratch/ArrayAlgorithms.java`

```java
package scratch;

import java.util.HashMap;
import java.util.Map;

public class ArrayAlgorithms {

    // 1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }

    // 2. Kadane's Algorithm
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    // 3. Array Rotation
    public static void rotate(int[] nums, int k) {
        k = k % nums.length; // Normalize k
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

---

## 🚀 NexCommerce Integration Context
In the NexCommerce Analytics microservice, Kadane's algorithm is utilized to identify the most profitable consecutive period of transaction streams. Modulo arithmetic in array rotation is applied in load-balancing configurations to distribute read/write requests across active database replicas.
