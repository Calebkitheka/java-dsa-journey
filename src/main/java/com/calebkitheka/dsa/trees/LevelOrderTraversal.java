package com.calebkitheka.dsa.trees;

import com.calebkitheka.dsa.utils.TreeNode;
import java.util.*;

public class LevelOrderTraversal {

    /**
     * Returns level-order traversal of a binary tree using BFS.
     * Time: O(n), Space: O(n)
     *
     * Uses a queue to process nodes level-by-level.
     * Key trick: Capture queue.size() at the start of each level
     * to know exactly how many nodes belong to that level.
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Queue for BFS (FIFO: First In, First Out)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Nodes at current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Remove from front
                currentLevel.add(node.val);

                // Add children to back of queue for next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 13: Level Order Traversal (BFS) ===\n");

        // Test 1: Balanced tree [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test 1: " + levelOrder(t1));
        System.out.println("✅ Pass: " + levelOrder(t1).equals(Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        )) + "\n");

        // Test 2: Single node [1]
        TreeNode t2 = new TreeNode(1);
        System.out.println("Test 2: " + levelOrder(t2));
        System.out.println("✅ Pass: " + levelOrder(t2).equals(Arrays.asList(Arrays.asList(1))) + "\n");

        // Test 3: Empty tree
        System.out.println("Test 3: " + levelOrder(null));
        System.out.println("✅ Pass: " + levelOrder(null).isEmpty() + "\n");

        // Test 4: Skewed tree [1,2,3,4]
        TreeNode t4 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);
        System.out.println("Test 4: " + levelOrder(t4));
        System.out.println("✅ Pass: " + levelOrder(t4).equals(Arrays.asList(
                Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4)
        )) + "\n");

        // Test 5: Perfect tree height 2 [1,2,3,4,5,6,7]
        TreeNode t5 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println("Test 5: " + levelOrder(t5));
        System.out.println("✅ Pass: " + levelOrder(t5).equals(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6, 7)
        )) + "\n");

        System.out.println("🎉 All tests passed! BFS queue-based traversal mastered.");
    }
}