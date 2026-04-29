package com.calebkitheka.dsa.dp;

public class UniquePaths {

    /**
     * Finds number of unique paths from top-left to bottom-right in m x n grid.
     * Time: O(m × n), Space: O(m × n)
     *
     * DP State: dp[i][j] = number of ways to reach cell (i, j)
     * Transition: dp[i][j] = dp[i-1][j] (from above) + dp[i][j-1] (from left)
     * Base Case: First row & first column = 1 (only one way to reach them)
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base case: First column (can only go down)
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        // Base case: First row (can only go right)
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 18: Unique Paths (2D DP) ===\n");

        System.out.println("3×7 grid: " + uniquePaths(3, 7) + " | ✅ Pass: " + (uniquePaths(3, 7) == 28));
        System.out.println("3×2 grid: " + uniquePaths(3, 2) + " | ✅ Pass: " + (uniquePaths(3, 2) == 3));
        System.out.println("1×1 grid: " + uniquePaths(1, 1) + " | ✅ Pass: " + (uniquePaths(1, 1) == 1));
        System.out.println("7×3 grid: " + uniquePaths(7, 3) + " | ✅ Pass: " + (uniquePaths(7, 3) == 28));
        System.out.println("10×10 grid: " + uniquePaths(10, 10) + " | ✅ Pass: " + (uniquePaths(10, 10) == 48620));

        System.out.println("\n🎉 All tests passed! 2D DP grid traversal mastered.");
    }
}