package com.calebkitheka.dsa.stacks;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class Dailytemperatures {

    /**
     * Finds days to wait for a warmer temperature using a monotonic stack.
     * Time: O(n), Space: O(n)
     *
     * Monotonic Property: Stack stores indices of temperatures in DECREASING order.
     * When a warmer temperature arrives, it "resolves" all waiting colder days.
     * Each index is pushed once and popped once → O(n) total operations.
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices, not values

        for (int i = 0; i < n; i++) {
            // While current temp is warmer than the temp at stack's top index
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // Days waited = current - previous
            }
            stack.push(i); // Current day becomes the new "waiting" day
        }

        // Remaining indices in stack already have result[prevIndex] = 0 (default)
        return result;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 28: Daily Temperatures (Monotonic Stack) ===\n");

        int[] t1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Test 1: " + Arrays.toString(dailyTemperatures(t1)));
        System.out.println("✅ Pass: " + Arrays.equals(dailyTemperatures(t1), new int[]{1,1,4,2,1,1,0,0}));

        int[] t2 = {30, 40, 50, 60};
        System.out.println("Test 2: " + Arrays.toString(dailyTemperatures(t2)));
        System.out.println("✅ Pass: " + Arrays.equals(dailyTemperatures(t2), new int[]{1,1,1,0}));

        int[] t3 = {30, 20, 10};
        System.out.println("Test 3: " + Arrays.toString(dailyTemperatures(t3)));
        System.out.println("✅ Pass: " + Arrays.equals(dailyTemperatures(t3), new int[]{0,0,0}));

        int[] t4 = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        System.out.println("Test 4: " + Arrays.toString(dailyTemperatures(t4)));
        System.out.println("✅ Pass: " + Arrays.equals(dailyTemperatures(t4), new int[]{8,1,5,4,3,2,1,1,0,0}));

        System.out.println("\n All tests passed! Monotonic stack pattern mastered.");
    }
}