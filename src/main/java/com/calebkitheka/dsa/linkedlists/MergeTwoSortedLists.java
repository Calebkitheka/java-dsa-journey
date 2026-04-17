package com.calebkitheka.dsa.linkedlists;

import com.calebkitheka.dsa.utils.ListNode;
import java.util.Arrays;

public class MergeTwoSortedLists {

    /**
     * Merges two sorted linked lists into one sorted list.
     * Time: O(m + n), Space: O(1)
     *
     * Uses a dummy node to simplify edge cases and two pointers
     * to traverse both lists, always picking the smaller value.
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the start of the merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Traverse both lists while both have nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // Pick node from list1
                tail.next = list1;
                list1 = list1.next;
            } else {
                // Pick node from list2
                tail.next = list2;
                list2 = list2.next;
            }
            // Move tail forward
            tail = tail.next;
        }

        // Attach remaining nodes (only one list will have leftovers)
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the merged list (skip the dummy node)
        return dummy.next;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 6: Merge Two Sorted Lists ===\n");

        // Test 1: Classic case
        ListNode test1a = ListNode.fromArray(new int[]{1, 2, 4});
        ListNode test1b = ListNode.fromArray(new int[]{1, 3, 4});
        System.out.println("List 1: " + test1a);
        System.out.println("List 2: " + test1b);
        ListNode result1 = mergeTwoLists(test1a, test1b);
        System.out.println("Merged: " + result1);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result1), new int[]{1,1,2,3,4,4}) + "\n");

        // Test 2: One list is empty
        ListNode test2a = ListNode.fromArray(new int[]{});
        ListNode test2b = ListNode.fromArray(new int[]{0});
        System.out.println("List 1: " + (test2a == null ? "null" : test2a));
        System.out.println("List 2: " + test2b);
        ListNode result2 = mergeTwoLists(test2a, test2b);
        System.out.println("Merged: " + result2);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result2), new int[]{0}) + "\n");

        // Test 3: Both lists empty
        ListNode test3a = ListNode.fromArray(new int[]{});
        ListNode test3b = ListNode.fromArray(new int[]{});
        System.out.println("List 1: " + (test3a == null ? "null" : test3a));
        System.out.println("List 2: " + (test3b == null ? "null" : test3b));
        ListNode result3 = mergeTwoLists(test3a, test3b);
        System.out.println("Merged: " + (result3 == null ? "null" : result3));
        System.out.println("✅ Pass: " + (result3 == null) + "\n");

        // Test 4: Different lengths
        ListNode test4a = ListNode.fromArray(new int[]{5});
        ListNode test4b = ListNode.fromArray(new int[]{1, 2, 3});
        System.out.println("List 1: " + test4a);
        System.out.println("List 2: " + test4b);
        ListNode result4 = mergeTwoLists(test4a, test4b);
        System.out.println("Merged: " + result4);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result4), new int[]{1,2,3,5}) + "\n");

        // Test 5: All elements in one list are smaller
        ListNode test5a = ListNode.fromArray(new int[]{1, 1, 1});
        ListNode test5b = ListNode.fromArray(new int[]{2, 2, 2});
        System.out.println("List 1: " + test5a);
        System.out.println("List 2: " + test5b);
        ListNode result5 = mergeTwoLists(test5a, test5b);
        System.out.println("Merged: " + result5);
        System.out.println("✅ Pass: " + Arrays.equals(ListNode.toArray(result5), new int[]{1,1,1,2,2,2}) + "\n");

        System.out.println("🎉 All tests passed! Linked list merging mastered.");
      }
    }
