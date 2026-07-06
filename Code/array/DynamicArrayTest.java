package Code.array;

import array.DynamicArray;

/**
 * Day 2: DynamicArray unit testing and validation.
 * Solved and verified on 2026-07-06.
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>(2);
        
        // Test 1: Grow dynamic resizing
        arr.add(10);
        arr.add(20);
        arr.add(30); // Triggers resize from 2 to 3
        
        assert arr.size() == 3 : "Size should be 3";
        assert arr.get(2) == 30 : "Element at index 2 should be 30";
        
        // Test 2: Index-based insert (Shifts elements right)
        arr.add(1, 15); // [10, 15, 20, 30]
        assert arr.size() == 4 : "Size should be 4";
        assert arr.get(1) == 15 : "Element at index 1 should be 15";
        assert arr.get(2) == 20 : "Element at index 2 should be 20";
        
        // Test 3: Remove shifts elements left
        int removed = arr.remove(2); // removes 20 -> [10, 15, 30]
        assert removed == 20 : "Removed element should be 20";
        assert arr.size() == 3 : "Size should be 3";
        assert arr.get(2) == 30 : "Element at index 2 should be 30";
        
        System.out.println("All DynamicArray assertions passed successfully!");
    }
}
