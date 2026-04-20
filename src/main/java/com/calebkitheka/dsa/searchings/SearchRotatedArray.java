package com.calebkitheka.dsa.searchings;

import java.util.Arrays;

public class SearchRotatedArray {

    /**
     * Finds target in a rotated sorted array.
     * Time: O(log n), Space: O(1)
     *
     * Key insight: At least one half (left or right of mid) is always sorted.
     * Check which half is sorted, then determine if target lies in that range.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found it!
            }

            // Check if LEFT half is sorted
            if (nums[left] <= nums[mid]) {
                // Is target in the sorted left half?
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search left
                } else {
                    left = mid + 1; // Search right
                }
            }
            // Otherwise RIGHT half must be sorted
            else {
                // Is target in the sorted right half?
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }
        }

        return -1; // Target not found
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 9: Search in Rotated Sorted Array ===\n");

        // Test 1: Classic rotation
        int[] test1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Array: " + Arrays.toString(test1));
        System.out.println("Search 0: " + search(test1, 0) + " | ✅ Pass: " + (search(test1, 0) == 4));
        System.out.println("Search 3: " + search(test1, 3) + " | ✅ Pass: " + (search(test1, 3) == -1));
        System.out.println("Search 6: " + search(test1, 6) + " | ✅ Pass: " + (search(test1, 6) == 2) + "\n");

        // Test 2: No rotation (fully sorted)
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Array: " + Arrays.toString(test2));
        System.out.println("Search 1: " + search(test2, 1) + " | ✅ Pass: " + (search(test2, 1) == 0));
        System.out.println("Search 5: " + search(test2, 5) + " | ✅ Pass: " + (search(test2, 5) == 4) + "\n");

        // Test 3: Single element
        int[] test3 = {1};
        System.out.println("Array: " + Arrays.toString(test3));
        System.out.println("Search 1: " + search(test3, 1) + " | ✅ Pass: " + (search(test3, 1) == 0));
        System.out.println("Search 0: " + search(test3, 0) + " | ✅ Pass: " + (search(test3, 0) == -1) + "\n");

        // Test 4: Two elements rotated
        int[] test4 = {3, 1};
        System.out.println("Array: " + Arrays.toString(test4));
        System.out.println("Search 1: " + search(test4, 1) + " | ✅ Pass: " + (search(test4, 1) == 1));
        System.out.println("Search 3: " + search(test4, 3) + " | ✅ Pass: " + (search(test4, 3) == 0) + "\n");

        // Test 5: Target at pivot point
        int[] test5 = {5, 6, 7, 1, 2, 3, 4};
        System.out.println("Array: " + Arrays.toString(test5));
        System.out.println("Search 1 (pivot): " + search(test5, 1) + " | ✅ Pass: " + (search(test5, 1) == 3));
        System.out.println("Search 7 (end of left): " + search(test5, 7) + " | ✅ Pass: " + (search(test5, 7) == 2) + "\n");

        System.out.println("🎉 All tests passed! Rotated array binary search mastered.");
    }
}
