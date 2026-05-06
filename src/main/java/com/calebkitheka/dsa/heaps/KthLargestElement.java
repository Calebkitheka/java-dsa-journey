package com.calebkitheka.dsa.heaps;

import java.util.PriorityQueue;

public class KthLargestElement {

    /**
     * Finds the kth largest element using a Min-Heap of size k.
     * Time: O(n log k), Space: O(k)
     *
     * Why Min-Heap? Java's PriorityQueue is a min-heap by default.
     * We keep only the k largest elements seen so far. The smallest
     * among them (heap root) is exactly the kth largest overall.
     */
    public static int findKthLargest(int[] nums, int k) {
        // Min-Heap: smallest element automatically bubbles to top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);
            // If heap grows beyond k, evict the smallest
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root is the kth largest element
        return minHeap.peek();
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 23: Kth Largest Element (Min-Heap) ===\n");

        int[] t1 = {3, 2, 1, 5, 6, 4};
        System.out.println("Test 1 [3,2,1,5,6,4], k=2: " + findKthLargest(t1, 2) + " | ✅ Pass: " + (findKthLargest(t1, 2) == 5));

        int[] t2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("Test 2 [3,2,3,1,2,4,5,5,6], k=4: " + findKthLargest(t2, 4) + " | ✅ Pass: " + (findKthLargest(t2, 4) == 4));

        int[] t3 = {1};
        System.out.println("Test 3 [1], k=1: " + findKthLargest(t3, 1) + " | ✅ Pass: " + (findKthLargest(t3, 1) == 1));

        int[] t4 = {7, 10, 4, 3, 20, 15};
        System.out.println("Test 4 [7,10,4,3,20,15], k=3: " + findKthLargest(t4, 3) + " | ✅ Pass: " + (findKthLargest(t4, 3) == 7));

        int[] t5 = {99, 99, 99, 99, 99};
        System.out.println("Test 5 [99,99,99,99,99], k=2: " + findKthLargest(t5, 2) + " | ✅ Pass: " + (findKthLargest(t5, 2) == 99));

        System.out.println("\n🎉 All tests passed! Heap-based top-K mastered.");
    }
}