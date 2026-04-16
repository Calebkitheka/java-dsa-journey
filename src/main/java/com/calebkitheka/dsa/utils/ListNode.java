package com.calebkitheka.dsa.utils;

public class ListNode {

    /**
     * Definition for singly-linked list node.
     * This is the standard LeetCode ListNode structure.
     */
    public int val;
    public ListNode next;

    // Constructors
    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Helper method to create a linked list from an array.
     * Example: ListNode.fromArray(new int[]{1,2,3}) → 1→2→3→null
     */
    public static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Helper method to convert linked list to array (for easy printing).
     * Example: 1→2→3→null → [1, 2, 3]
     */

    public static int[] toArray(ListNode head) {
        if (head == null) return new int[]{};

        // Count nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Fill array
        int[] result = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.val;
            current = current.next;
        }
        return result;
    }

    /**
     * Helper method to print linked list as a string.
     * Example: 1→2→3→null
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" → ");
            }
            current = current.next;
        }
        sb.append(" → null");
        return sb.toString();
    }
}
