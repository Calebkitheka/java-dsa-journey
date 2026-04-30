package com.calebkitheka.dsa.dp;

public class LongestCommonSubsequence {

    /**
     * Finds length of longest common subsequence between two strings.
     * Time: O(m × n), Space: O(m × n)
     *
     * DP State: dp[i][j] = LCS length of text1[0..i-1] and text2[0..j-1]
     * Transition:
     *   - If chars match: dp[i][j] = dp[i-1][j-1] + 1 (extend diagonal)
     *   - If chars differ: dp[i][j] = max(dp[i-1][j], dp[i][j-1]) (skip one)
     * Base: dp[0][j] = dp[i][0] = 0 (empty string has LCS length 0)
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 19: Longest Common Subsequence (2D String DP) ===\n");

        System.out.println("\"abcde\", \"ace\": " + longestCommonSubsequence("abcde", "ace") + " | ✅ Pass: " + (longestCommonSubsequence("abcde", "ace") == 3));
        System.out.println("\"abc\", \"abc\": " + longestCommonSubsequence("abc", "abc") + " | ✅ Pass: " + (longestCommonSubsequence("abc", "abc") == 3));
        System.out.println("\"abc\", \"def\": " + longestCommonSubsequence("abc", "def") + " | ✅ Pass: " + (longestCommonSubsequence("abc", "def") == 0));
        System.out.println("\"bsbininm\", \"jmjkbkjkv\": " + longestCommonSubsequence("bsbininm", "jmjkbkjkv") + " | ✅ Pass: " + (longestCommonSubsequence("bsbininm", "jmjkbkjkv") == 1));
        System.out.println("\"\", \"abc\": " + longestCommonSubsequence("", "abc") + " | ✅ Pass: " + (longestCommonSubsequence("", "abc") == 0));

        System.out.println("\n All tests passed! 2D string DP mastered.");
    }
}