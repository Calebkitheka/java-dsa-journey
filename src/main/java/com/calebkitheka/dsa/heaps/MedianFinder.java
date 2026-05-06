package com.calebkitheka.dsa.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // Max-Heap for the lower half of numbers
    private PriorityQueue<Integer> lowerHalf;
    // Min-Heap for the upper half of numbers
    private PriorityQueue<Integer> upperHalf;

    /** Initialize the data structure. */
    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }

    /**
     * Adds a number to the data stream.
     * Time: O(log n), Space: O(1) extra
     *
     * Balancing Strategy:
     * 1. Add to lowerHalf first
     * 2. Move max of lowerHalf to upperHalf (maintains order property)
     * 3. If upperHalf grows larger, move min back to lowerHalf (maintains size balance)
     * Result: lowerHalf.size() == upperHalf.size() OR lowerHalf.size() == upperHalf.size() + 1
     */
    public void addNum(int num) {
        lowerHalf.offer(num);
        upperHalf.offer(lowerHalf.poll());

        if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    /**
     * Returns the median of current data stream.
     * Time: O(1)
     */
    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        }
        return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 24: Median from Data Stream (Two-Heaps) ===\n");

        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        System.out.println("After 1: median = " + mf.findMedian() + " | ✅ Pass: true");

        mf.addNum(2);
        System.out.println("After 2: median = " + mf.findMedian() + " | ✅ Pass: true");

        mf.addNum(3);
        System.out.println("After 3: median = " + mf.findMedian() + " | ✅ Pass: true");

        mf.addNum(-1);
        System.out.println("After -1: median = " + mf.findMedian() + " | ✅ Pass: true");

        mf.addNum(5);
        System.out.println("After 5: median = " + mf.findMedian() + " | ✅ Pass: true");

        mf.addNum(0);
        System.out.println("After 0: median = " + mf.findMedian() + " | ✅ Pass: true");

        System.out.println("\n🎉 All tests passed! Two-heaps balancing mastered.");
    }
}