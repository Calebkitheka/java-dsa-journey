package com.calebkitheka.dsa.deques;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    /**
     * Finds maximum in each sliding window of size k.
     * Time: O(n), Space: O(k) for deque + O(n-k+1) for result
     *
     * Monotonic Property: Deque stores INDICES of elements in DECREASING value order.
     * Front of deque = index of current window's maximum.
     * Back of deque = index of newest/smallest candidate.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // 1. Remove index that just slid out of the window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order: remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index to back
            deque.offerLast(i);

            // 4. Record maximum once window is full (starting at index k-1)
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 29: Sliding Window Maximum (Monotonic Deque) ===\n");

        int[] t1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("Test 1 k=3: " + Arrays.toString(maxSlidingWindow(t1, 3)));
        System.out.println("✅ Pass: " + Arrays.equals(maxSlidingWindow(t1, 3), new int[]{3,3,5,5,6,7}));

        int[] t2 = {1};
        System.out.println("Test 2 k=1: " + Arrays.toString(maxSlidingWindow(t2, 1)));
        System.out.println("✅ Pass: " + Arrays.equals(maxSlidingWindow(t2, 1), new int[]{1}));

        int[] t3 = {1, -1};
        System.out.println("Test 3 k=1: " + Arrays.toString(maxSlidingWindow(t3, 1)));
        System.out.println("✅ Pass: " + Arrays.equals(maxSlidingWindow(t3, 1), new int[]{1,-1}));

        int[] t4 = {9, 11};
        System.out.println("Test 4 k=2: " + Arrays.toString(maxSlidingWindow(t4, 2)));
        System.out.println("✅ Pass: " + Arrays.equals(maxSlidingWindow(t4, 2), new int[]{11}));

        int[] t5 = {4, -2};
        System.out.println("Test 5 k=2: " + Arrays.toString(maxSlidingWindow(t5, 2)));
        System.out.println("✅ Pass: " + Arrays.equals(maxSlidingWindow(t5, 2), new int[]{4}));

        System.out.println("\n🎉 All tests passed! Monotonic deque sliding window mastered.");
    }
}