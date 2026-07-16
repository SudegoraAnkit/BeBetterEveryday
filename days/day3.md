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
