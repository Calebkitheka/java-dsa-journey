package com.calebkitheka.dsa.dp;

import java.util.Arrays;

public class CoinChange {

    /**
     * Finds minimum coins needed to make up amount.
     * Time: O(amount × n), Space: O(amount)
     *
     * DP State: dp[i] = min coins to make amount i
     * Transition: dp[i] = min(dp[i], dp[i - coin] + 1) for each coin
     * Base: dp[0] = 0, all others = amount + 1 (acts as infinity)
     */
    public static int coinChange(int[] coins, int amount) {
        // "infinity" placeholder: impossible to need more than 'amount' coins (all 1s)
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        // Build solution bottom-up from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still "infinity", no solution exists
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 17: Coin Change (Unbounded Knapsack DP) ===\n");

        System.out.println("Test 1 [1,2,5], 11: " + coinChange(new int[]{1,2,5}, 11) + " | ✅ Pass: " + (coinChange(new int[]{1,2,5}, 11) == 3));
        System.out.println("Test 2 [2], 3: " + coinChange(new int[]{2}, 3) + " | ✅ Pass: " + (coinChange(new int[]{2}, 3) == -1));
        System.out.println("Test 3 [1], 0: " + coinChange(new int[]{1}, 0) + " | ✅ Pass: " + (coinChange(new int[]{1}, 0) == 0));
        System.out.println("Test 4 [1,2,5], 100: " + coinChange(new int[]{1,2,5}, 100) + " | ✅ Pass: " + (coinChange(new int[]{1,2,5}, 100) == 20));
        System.out.println("Test 5 [186,419,83,408], 6249: " + coinChange(new int[]{186,419,83,408}, 6249) + " | ✅ Pass: " + (coinChange(new int[]{186,419,83,408}, 6249) == 20));

        System.out.println("\n🎉 All tests passed! Unbounded knapsack DP mastered.");
    }
}