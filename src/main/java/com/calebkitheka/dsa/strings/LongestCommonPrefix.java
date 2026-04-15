package com.calebkitheka.dsa.strings;

public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix among an array of strings.
     * Uses vertical scanning: compare character-by-character down each column.
     * Time: O(S) where S = total characters, Space: O(1)
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // Use first string as reference
        for (int col = 0; col < strs[0].length(); col++) {
            char currentChar = strs[0].charAt(col);

            // Check this column in all other strings
            for (int row = 1; row < strs.length; row++) {
                // If we reached end of a string OR characters don't match
                if (col >= strs[row].length() || strs[row].charAt(col) != currentChar) {
                    return strs[0].substring(0, col);
                }
            }
        }
        // If we finished the loop, entire first string is the prefix
        return strs[0];
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 4: Longest Common Prefix ===\n");

        // Test 1: Classic case
        String[] test1 = {"flower", "flow", "flight"};
        System.out.println("Input: " + java.util.Arrays.toString(test1));
        System.out.println("Output: \"" + longestCommonPrefix(test1) + "\"");
        System.out.println("✅ Pass: " + longestCommonPrefix(test1).equals("fl") + "\n");

        // Test 2: No common prefix
        String[] test2 = {"dog", "racecar", "car"};
        System.out.println("Input: " + java.util.Arrays.toString(test2));
        System.out.println("Output: \"" + longestCommonPrefix(test2) + "\"");
        System.out.println("✅ Pass: " + longestCommonPrefix(test2).equals("") + "\n");

        // Test 3: Longer common prefix
        String[] test3 = {"interspecies", "interstellar", "interstate"};
        System.out.println("Input: " + java.util.Arrays.toString(test3));
        System.out.println("Output: \"" + longestCommonPrefix(test3) + "\"");
        System.out.println("✅ Pass: " + longestCommonPrefix(test3).equals("inters") + "\n");

        // Test 4: Empty string in array
        String[] test4 = {"", "b"};
        System.out.println("Input: " + java.util.Arrays.toString(test4));
        System.out.println("Output: \"" + longestCommonPrefix(test4) + "\"");
        System.out.println("✅ Pass: " + longestCommonPrefix(test4).equals("") + "\n");

        // Test 5: Single string
        String[] test5 = {"alone"};
        System.out.println("Input: " + java.util.Arrays.toString(test5));
        System.out.println("Output: \"" + longestCommonPrefix(test5) + "\"");
        System.out.println("✅ Pass: " + longestCommonPrefix(test5).equals("alone") + "\n");

        // Test 6: Null/empty array
        String[] test6 = {};
        System.out.println("Input: " + java.util.Arrays.toString(test6));
        System.out.println("Output: \"" + longestCommonPrefix(test6) + "\"");
        System.out.println("✅ Pass: " + longestCommonPrefix(test6).equals("") + "\n");

        System.out.println("🎉 All tests passed! Vertical scanning mastered.");
    }
}
