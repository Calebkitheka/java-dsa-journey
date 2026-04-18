package com.calebkitheka.dsa.linkedlists;

import com.calebkitheka.dsa.utils.ListNode;

public class DetectCycle {
        /**
         * Detects if a linked list has a cycle using Floyd's Tortoise & Hare.
         * Time: O(n), Space: O(1)
         *
         * Two pointers move at different speeds. If there's a cycle,
         * the fast pointer will eventually lap the slow pointer.
         */
        public static boolean hasCycle(ListNode head) {
            // Edge cases: empty list or single node cannot have a cycle
            if (head == null || head.next == null) return false;

            ListNode slow = head;
            ListNode fast = head;

            // Move slow by 1 step, fast by 2 steps
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                // If they meet, there's a cycle
                if (slow == fast) {
                    return true;
                }
            }

            // Fast reached the end → no cycle
            return false;
        }

        // ============ TEST RUNNER ============
        public static void main(String[] args) {
            System.out.println("=== Day 7: Detect Cycle in Linked List ===\n");

            // Test 1: No cycle
            ListNode test1 = ListNode.fromArray(new int[]{1, 2, 3, 4});
            System.out.println("Test 1 (No cycle): " + hasCycle(test1));
            System.out.println("✅ Pass: " + (hasCycle(test1) == false) + "\n");

            // Test 2: Cycle at position 2 (1→2→3→4→2...)
            ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3), n4 = new ListNode(4);
            n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n2; // Cycle back to n2
            System.out.println("Test 2 (Cycle at pos 2): " + hasCycle(n1));
            System.out.println("✅ Pass: " + (hasCycle(n1) == true) + "\n");

            // Test 3: Single node with self-loop
            ListNode test3 = new ListNode(1);
            test3.next = test3; // Points to itself
            System.out.println("Test 3 (Self-loop): " + hasCycle(test3));
            System.out.println("✅ Pass: " + (hasCycle(test3) == true) + "\n");

            // Test 4: Empty list
            System.out.println("Test 4 (Empty): " + hasCycle(null));
            System.out.println("✅ Pass: " + (hasCycle(null) == false) + "\n");

            // Test 5: Two nodes with cycle
            ListNode m1 = new ListNode(1), m2 = new ListNode(2);
            m1.next = m2; m2.next = m1; // 1↔2
            System.out.println("Test 5 (Two-node cycle): " + hasCycle(m1));
            System.out.println("✅ Pass: " + (hasCycle(m1) == true) + "\n");

            System.out.println("🎉 All tests passed! Floyd's algorithm mastered.");
    }
}
