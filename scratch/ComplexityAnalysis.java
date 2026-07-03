package scratch;

/**
 * Day 1: Complexity Analysis Practical Exercises.
 * Solved and analyzed on 2026-07-03.
 */
public class ComplexityAnalysis {

    // Snippet 1: Print all pairs
    // Time Complexity: O(n^2) - Nested loop iterating n * (n-1)/2 times.
    // Space Complexity: O(1) - Constant auxiliary space.
    public static void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    // Snippet 2: Binary Search
    // Time Complexity: O(log n) - Search space is halved at each step.
    // Space Complexity: O(1) - Constant auxiliary space.
    public static int findElement(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Snippet 3: Linear Recursion
    // Time Complexity: O(n) - Makes n recursive call frames.
    // Space Complexity: O(n) - Allocates n frames on the call stack.
    public static int recursiveSum(int n) {
        if (n <= 0) return 0;
        return n + recursiveSum(n - 1);
    }
}
