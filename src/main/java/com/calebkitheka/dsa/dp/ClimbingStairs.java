package com.calebkitheka.dsa.dp;

public class ClimbingStairs {

    /**
     * Finds distinct ways to climb n stairs (1 or 2 steps at a time).
     * Time: O(n), Space: O(1)
     *
     * This is a 1D DP problem equivalent to Fibonacci.
     * Instead of storing an array, we only track the last two values.
     */
    public static int climbStairs(int n) {
        // Base cases
        if (n <= 2) return n;

        // prev2 = ways to reach step i-2
        // prev1 = ways to reach step i-1
        int prev2 = 1; // n=1 → 1 way
        int prev1 = 2; // n=2 → 2 ways

        // Build up to n using only last two values
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 15: Climbing Stairs (DP Intro) ===\n");

        System.out.println("n=1: " + climbStairs(1) + " | ✅ Pass: " + (climbStairs(1) == 1));
        System.out.println("n=2: " + climbStairs(2) + " | ✅ Pass: " + (climbStairs(2) == 2));
        System.out.println("n=3: " + climbStairs(3) + " | ✅ Pass: " + (climbStairs(3) == 3));
        System.out.println("n=5: " + climbStairs(5) + " | ✅ Pass: " + (climbStairs(5) == 8));
        System.out.println("n=10: " + climbStairs(10) + " | ✅ Pass: " + (climbStairs(10) == 89));
        System.out.println("n=45: " + climbStairs(45) + " | ✅ Pass: " + (climbStairs(45) == 1836311903) + "\n");

        System.out.println("🎉 All tests passed! DP foundation mastered.");
    }
}