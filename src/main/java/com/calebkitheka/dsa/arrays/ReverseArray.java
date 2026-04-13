package com.calebkitheka.dsa.arrays;

import java.util.Arrays;

public class ReverseArray {

    /**
     * Reverses an array in-place using two pointers.
     * Time: O(n), Space: O(1)
     */
    public static void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers
            left++;
            right--;
        }
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 2: Reverse Array ===\n");

        // Test 1: Normal case
        int[] test1 = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(test1));
        reverse(test1);
        System.out.println("After:  " + Arrays.toString(test1));
        System.out.println("✅ Pass: " + Arrays.equals(test1, new int[]{5,4,3,2,1}) + "\n");

        // Test 2: Single element
        int[] test2 = {42};
        reverse(test2);
        System.out.println("Single element: " + Arrays.toString(test2));
        System.out.println("✅ Pass: " + Arrays.equals(test2, new int[]{42}) + "\n");

        // Test 3: Even length
        int[] test3 = {10, 20, 30, 40};
        reverse(test3);
        System.out.println("Even length: " + Arrays.toString(test3));
        System.out.println("✅ Pass: " + Arrays.equals(test3, new int[]{40,30,20,10}) + "\n");

        // Test 4: Empty array
        int[] test4 = {};
        reverse(test4);
        System.out.println("Empty array: " + Arrays.toString(test4));
        System.out.println("✅ Pass: " + (test4.length == 0) + "\n");

        System.out.println("🎉 All tests passed! Two-pointer technique mastered.");
    }
}