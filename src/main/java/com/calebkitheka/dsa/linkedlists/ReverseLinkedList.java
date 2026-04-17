package com.calebkitheka.dsa.linkedlists;

import com.calebkitheka.dsa.utils.ListNode;
import java.util.Arrays;

public class ReverseLinkedList {
    /**
     * Reverses a singly linked list iteratively.
     * Time: O(n), Space: O(1)
     *
     * Uses three pointers:
     * - prev: tracks the previous node (starts as null)
     * - current: tracks the current node (starts as head)
     * - next: temporarily stores the next node
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            // Step 1: Store the next node (before we break the link)
            ListNode next = current.next;

            // Step 2: Reverse the link (point current to previous)
            current.next = prev;

            // Step 3: Move prev and current one step forward
            prev = current;
            current = next;
        }

        // prev is now the new head (old tail)
        return prev;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 5: Reverse Linked List ===\n");

        // Test 1: Normal case (5 nodes)
        ListNode test1 = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original: " + test1);
        ListNode result1 = reverseList(test1);
        System.out.println("Reversed: " + result1);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result1), new int[]{5,4,3,2,1}) + "\n");

        // Test 2: Two nodes
        ListNode test2 = ListNode.fromArray(new int[]{1, 2});
        System.out.println("Original: " + test2);
        ListNode result2 = reverseList(test2);
        System.out.println("Reversed: " + result2);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result2), new int[]{2,1}) + "\n");

        // Test 3: Single node
        ListNode test3 = ListNode.fromArray(new int[]{42});
        System.out.println("Original: " + test3);
        ListNode result3 = reverseList(test3);
        System.out.println("Reversed: " + result3);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result3), new int[]{42}) + "\n");

        // Test 4: Empty list
        ListNode test4 = ListNode.fromArray(new int[]{});
        System.out.println("Original: " + (test4 == null ? "null" : test4));
        ListNode result4 = reverseList(test4);
        System.out.println("Reversed: " + (result4 == null ? "null" : result4));
        System.out.println("✅ Pass: " + (result4 == null) + "\n");

        // Test 5: Already reversed pattern
        ListNode test5 = ListNode.fromArray(new int[]{5, 4, 3, 2, 1});
        System.out.println("Original: " + test5);
        ListNode result5 = reverseList(test5);
        System.out.println("Reversed: " + result5);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result5), new int[]{1,2,3,4,5}) + "\n");

        System.out.println("🎉 All tests passed! Linked list reversal mastered.");
    }
}



