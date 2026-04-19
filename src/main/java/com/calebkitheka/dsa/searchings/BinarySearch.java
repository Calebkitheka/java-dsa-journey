package com.calebkitheka.dsa.searchings;

import java.util.Arrays;

public class BinarySearch {
    /**
     * Finds the index of target in a sorted array.
     * Time: O(log n), Space: O(1)
     *
     * Uses two pointers to repeatedly halve the search space.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevent integer overflow for large arrays
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found it!
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 8: Binary Search ===\n");

        int[] test1 = {-1, 0, 3, 5, 9, 12};
        System.out.println("Array: " + Arrays.toString(test1));
        System.out.println("Search 9: " + search(test1, 9) + " | ✅ Pass: " + (search(test1, 9) == 4));
        System.out.println("Search 2: " + search(test1, 2) + " | ✅ Pass: " + (search(test1, 2) == -1));
        System.out.println("Search -1: " + search(test1, -1) + " | ✅ Pass: " + (search(test1, -1) == 0));
        System.out.println("Search 12: " + search(test1, 12) + " | ✅ Pass: " + (search(test1, 12) == 5) + "\n");

        int[] test2 = {5};
        System.out.println("Array: " + Arrays.toString(test2));
        System.out.println("Search 5: " + search(test2, 5) + " | ✅ Pass: " + (search(test2, 5) == 0));
        System.out.println("Search 0: " + search(test2, 0) + " | ✅ Pass: " + (search(test2, 0) == -1) + "\n");

        int[] test3 = {};
        System.out.println("Array: " + Arrays.toString(test3));
        System.out.println("Search 1: " + search(test3, 1) + " | ✅ Pass: " + (search(test3, 1) == -1) + "\n");

        System.out.println("🎉 All tests passed! O(log n) search mastered.");
    }
}
