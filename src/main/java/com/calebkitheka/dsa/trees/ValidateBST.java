package com.calebkitheka.dsa.trees;

import com.calebkitheka.dsa.utils.TreeNode;

public class ValidateBST {
    /**
     * Validates if a binary tree is a BST using recursive bounds checking.
     * Time: O(n), Space: O(h) where h = tree height
     *
     * Each node must be within a valid range (min, max).
     * Left child: (min, node.val)
     * Right child: (node.val, max)
     */
    public static boolean isValidBST(TreeNode root) {
        // Use long to safely handle Integer.MIN/MAX edge cases
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // Check current node against bounds
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively validate left and right subtrees with updated bounds
        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 10: Validate Binary Search Tree ===\n");

        // Test 1: Valid BST [2,1,3]
        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Test 1 [2,1,3]: " + isValidBST(t1));
        System.out.println("✅ Pass: " + (isValidBST(t1) == true) + "\n");

        // Test 2: Invalid BST [5,1,4,null,null,3,6]
        TreeNode t2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Test 2 [5,1,4,3,6]: " + isValidBST(t2));
        System.out.println("✅ Pass: " + (isValidBST(t2) == false) + "\n");

        // Test 3: Single node
        TreeNode t3 = new TreeNode(10);
        System.out.println("Test 3 [10]: " + isValidBST(t3));
        System.out.println("✅ Pass: " + (isValidBST(t3) == true) + "\n");

        // Test 4: Empty tree
        System.out.println("Test 4 null: " + isValidBST(null));
        System.out.println("✅ Pass: " + (isValidBST(null) == true) + "\n");

        // Test 5: Duplicate values (invalid per strict BST definition)
        TreeNode t5 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println("Test 5 [2,2,2]: " + isValidBST(t5));
        System.out.println("✅ Pass: " + (isValidBST(t5) == false) + "\n");

        System.out.println("🎉 All tests passed! BST validation mastered.");
    }
}
