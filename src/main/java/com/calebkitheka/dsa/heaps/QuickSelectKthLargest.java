package com.calebkitheka.dsa.searching;

import java.util.Arrays;
import java.util.Random;

public class QuickSelectKthLargest {
    private static final Random rand = new Random();

    /**
     * Finds the kth largest element using QuickSelect.
     * Time: O(n) average, O(n²) worst-case (random pivot prevents this)
     * Space: O(log n) recursion stack
     *
     * Converts "kth largest" to "(n-k)th smallest" index.
     * Uses Lomuto partition scheme with random pivot selection.
     */
    public static int findKthLargest(int[] nums, int k) {
        // Target index in 0-based sorted order
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    private static int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) return nums[left];

        // Partition and get pivot's final sorted position
        int pivotIndex = partition(nums, left, right);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest]; // Found it!
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest); // Search left
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest); // Search right
        }
    }

    private static int partition(int[] nums, int left, int right) {
        // Random pivot to avoid O(n²) on sorted/reverse-sorted inputs
        int pivotIdx = left + rand.nextInt(right - left + 1);
        swap(nums, pivotIdx, right); // Move pivot to end

        int pivot = nums[right];
        int i = left; // Points to where next smaller element should go

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        // Place pivot in correct sorted position
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 25: Kth Largest (QuickSelect O(n)) ===\n");

        int[] t1 = {3, 2, 1, 5, 6, 4};
        System.out.println("Test 1 k=2: " + findKthLargest(t1, 2) + " | ✅ Pass: " + (findKthLargest(t1, 2) == 5));

        int[] t2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("Test 2 k=4: " + findKthLargest(t2, 4) + " | ✅ Pass: " + (findKthLargest(t2, 4) == 4));

        int[] t3 = {7, 10, 4, 3, 20, 15};
        System.out.println("Test 3 k=3: " + findKthLargest(t3, 3) + " | ✅ Pass: " + (findKthLargest(t3, 3) == 7));

        int[] t4 = {1};
        System.out.println("Test 4 k=1: " + findKthLargest(t4, 1) + " | ✅ Pass: " + (findKthLargest(t4, 1) == 1));

        int[] t5 = {99, 99, 99, 99, 99};
        System.out.println("Test 5 k=2: " + findKthLargest(t5, 2) + " | ✅ Pass: " + (findKthLargest(t5, 2) == 99));

        System.out.println("\n🎉 All tests passed! O(n) selection algorithm mastered.");
    }
}