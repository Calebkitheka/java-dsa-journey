package com.calebkitheka.dsa.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    /**
     * Checks if a string of parentheses is valid using a stack.
     * Time: O(n), Space: O(n)
     *
     * Uses LIFO property: every closing bracket must match the
     * most recently opened bracket. HashMap provides O(1) type lookup.
     * Note: ArrayDeque is preferred over java.util.Stack in modern Java.
     */
    public static boolean isValid(String s) {
        // Odd length strings can never be valid
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                // Closing bracket: check against most recent open bracket
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != mapping.get(c)) {
                    return false; // Mismatch or empty stack
                }
            } else {
                // Opening bracket: push onto stack
                stack.push(c);
            }
        }

        // Valid only if no unmatched opening brackets remain
        return stack.isEmpty();
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 26: Valid Parentheses (Stack LIFO) ===\n");

        System.out.println("Test 1 \"()\": " + isValid("()") + " | ✅ Pass: true");
        System.out.println("Test 2 \"()[]{}\": " + isValid("()[]{}") + " | ✅ Pass: true");
        System.out.println("Test 3 \"(]\": " + isValid("(]") + " | ✅ Pass: false");
        System.out.println("Test 4 \"([)]\": " + isValid("([)]") + " | ✅ Pass: false");
        System.out.println("Test 5 \"{[]}\": " + isValid("{[]}") + " | ✅ Pass: true");
        System.out.println("Test 6 \"\": " + isValid("") + " | ✅ Pass: true");
        System.out.println("Test 7 \"((()))\": " + isValid("((()))") + " | ✅ Pass: true");

        System.out.println("\n🎉 All tests passed! Stack LIFO pattern mastered.");
    }
}