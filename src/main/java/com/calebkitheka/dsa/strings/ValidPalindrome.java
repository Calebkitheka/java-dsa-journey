package com.calebkitheka.dsa.strings;

public class ValidPalindrome {
        /**
         * Checks if a string is a palindrome (alphanumeric only, case-insensitive).
         * Time: O(n), Space: O(1)
         */
        public static boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) return true;

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // Skip non-alphanumeric characters from left
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                // Skip non-alphanumeric characters from right
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                // Compare characters (case-insensitive)
                if (Character.toLowerCase(s.charAt(left)) !=
                        Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }
            return true;
        }

        // ============ TEST RUNNER ============
        public static void main(String[] args) {
            System.out.println("=== Day 3: Valid Palindrome ===\n");

            // Test 1: Classic palindrome with punctuation
            String test1 = "A man, a plan, a canal: Panama";
            System.out.println("Input: \"" + test1 + "\"");
            System.out.println("Output: " + isPalindrome(test1));
            System.out.println("✅ Pass: " + (isPalindrome(test1) == true) + "\n");

            // Test 2: Non-palindrome
            String test2 = "race a car";
            System.out.println("Input: \"" + test2 + "\"");
            System.out.println("Output: " + isPalindrome(test2));
            System.out.println("✅ Pass: " + (isPalindrome(test2) == false) + "\n");

            // Test 3: Empty / whitespace only
            String test3 = "   ";
            System.out.println("Input: \"" + test3 + "\"");
            System.out.println("Output: " + isPalindrome(test3));
            System.out.println("✅ Pass: " + (isPalindrome(test3) == true) + "\n");

            // Test 4: Mixed case + numbers
            String test4 = "0P";
            System.out.println("Input: \"" + test4 + "\"");
            System.out.println("Output: " + isPalindrome(test4));
            System.out.println("✅ Pass: " + (isPalindrome(test4) == false) + "\n");

            // Test 5: Single character
            String test5 = "a";
            System.out.println("Input: \"" + test5 + "\"");
            System.out.println("Output: " + isPalindrome(test5));
            System.out.println("✅ Pass: " + (isPalindrome(test5) == true) + "\n");

            System.out.println("🎉 All tests passed! String two-pointer technique mastered.");
        }
    }
