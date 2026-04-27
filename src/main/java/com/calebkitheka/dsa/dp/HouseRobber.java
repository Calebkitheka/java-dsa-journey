package com.calebkitheka.dsa.dp;

public class HouseRobber {

    /**
     * Finds maximum money that can be robbed without alerting police.
     * Time: O(n), Space: O(1)
     *
     * DP State: At each house, choose max of:
     *   1. Skip current house → keep max from previous house (prev1)
     *   2. Rob current house → add to max from two houses ago (prev2 + num)
     */
    public static int rob(int[] nums) {
        int prev2 = 0; // Max money up to house i-2
        int prev1 = 0; // Max money up to house i-1

        for (int num : nums) {
            // Decision: rob current + i-2 OR skip current & keep i-1
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 16: House Robber (DP with Choices) ===\n");

        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + rob(test1) + " | ✅ Pass: " + (rob(test1) == 4));

        int[] test2 = {2, 7, 9, 3, 1};
        System.out.println("Test 2: " + rob(test2) + " | ✅ Pass: " + (rob(test2) == 12));

        int[] test3 = {5};
        System.out.println("Test 3: " + rob(test3) + " | ✅ Pass: " + (rob(test3) == 5));

        int[] test4 = {};
        System.out.println("Test 4: " + rob(test4) + " | ✅ Pass: " + (rob(test4) == 0));

        int[] test5 = {2, 1, 1, 2};
        System.out.println("Test 5: " + rob(test5) + " | ✅ Pass: " + (rob(test5) == 4));

        System.out.println("\n🎉 All tests passed! Decision-based DP mastered.");
    }
}
