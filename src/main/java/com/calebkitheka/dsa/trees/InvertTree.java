package com.calebkitheka.dsa.trees;

import com.calebkitheka.dsa.utils.TreeNode;

public class InvertTree {

    /**
     * Inverts a binary tree by swapping left/right children recursively.
     * Time: O(n), Space: O(h) where h = tree height
     *
     * Pre-order traversal: swap children first, then recurse on subtrees.
     * Post-order also works—order doesn't matter as long as all nodes are visited.
     */
    public static TreeNode invertTree(TreeNode root) {
        // Base case: empty node needs no inversion
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        // Return the (now inverted) root
        return root;
    }

    // ============ HELPER: Print Tree Level-Order ============
    // Makes testing easier by visualizing the inverted structure
    public static java.util.List<java.lang.Integer> levelOrder(TreeNode root) {
        java.util.List<java.lang.Integer> result = new java.util.ArrayList<>();
        if (root == null) return result;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        // Trim trailing nulls for cleaner output
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 12: Invert Binary Tree ===\n");

        // Test 1: Balanced tree [4,2,7,1,3,6,9]
        TreeNode t1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("Original: " + levelOrder(t1));
        invertTree(t1);
        System.out.println("Inverted: " + levelOrder(t1));
        System.out.println("✅ Pass: " + levelOrder(t1).equals(java.util.Arrays.asList(4,7,2,9,6,3,1)) + "\n");

        // Test 2: Small tree [2,1,3]
        TreeNode t2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Original: " + levelOrder(t2));
        invertTree(t2);
        System.out.println("Inverted: " + levelOrder(t2));
        System.out.println("✅ Pass: " + levelOrder(t2).equals(java.util.Arrays.asList(2,3,1)) + "\n");

        // Test 3: Empty tree
        System.out.println("Original: []");
        TreeNode t3 = invertTree(null);
        System.out.println("Inverted: " + levelOrder(t3));
        System.out.println("✅ Pass: " + levelOrder(t3).isEmpty() + "\n");

        // Test 4: Single node
        TreeNode t4 = new TreeNode(42);
        System.out.println("Original: " + levelOrder(t4));
        invertTree(t4);
        System.out.println("Inverted: " + levelOrder(t4));
        System.out.println("✅ Pass: " + levelOrder(t4).equals(java.util.Arrays.asList(42)) + "\n");

        // Test 5: Skewed tree [1,2,null,3]
        TreeNode t5 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        System.out.println("Original: " + levelOrder(t5));
        invertTree(t5);
        System.out.println("Inverted: " + levelOrder(t5));
        System.out.println("✅ Pass: " + levelOrder(t5).equals(java.util.Arrays.asList(1,null,2,null,3)) + "\n");

        System.out.println("🎉 All tests passed! Tree inversion mastered.");
    }
}
