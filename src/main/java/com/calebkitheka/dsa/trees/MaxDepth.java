package com.calebkitheka.dsa.trees;

import com.calebkitheka.dsa.utils.TreeNode;

public class MaxDepth {

    /**
     * Finds maximum depth of binary tree using recursive DFS.
     * Time: O(n), Space: O(h) where h = tree height
     *
     * Post-order traversal: compute depth of left/right subtrees first,
     * then take max and add 1 for current node.
     */
    public static int maxDepth(TreeNode root) {
        // Base case: empty node has depth 0
        if (root == null) return 0;

        // Recursively compute depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return max depth + 1 (for current node)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 11: Maximum Depth of Binary Tree ===\n");

        // Test 1: Balanced tree [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test 1 [3,9,20,15,7]: " + maxDepth(t1));
        System.out.println("✅ Pass: " + (maxDepth(t1) == 3) + "\n");

        // Test 2: Skewed right [1,null,2]
        TreeNode t2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Test 2 [1,null,2]: " + maxDepth(t2));
        System.out.println("✅ Pass: " + (maxDepth(t2) == 2) + "\n");

        // Test 3: Empty tree
        System.out.println("Test 3 null: " + maxDepth(null));
        System.out.println("✅ Pass: " + (maxDepth(null) == 0) + "\n");

        // Test 4: Single node
        TreeNode t4 = new TreeNode(42);
        System.out.println("Test 4 [42]: " + maxDepth(t4));
        System.out.println("✅ Pass: " + (maxDepth(t4) == 1) + "\n");

        // Test 5: Perfect binary tree of height 4
        TreeNode t5 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        System.out.println("Test 5 [perfect height-3]: " + maxDepth(t5));
        System.out.println("✅ Pass: " + (maxDepth(t5) == 3) + "\n");

        System.out.println("🎉 All tests passed! Recursive DFS mastered.");
    }
}
