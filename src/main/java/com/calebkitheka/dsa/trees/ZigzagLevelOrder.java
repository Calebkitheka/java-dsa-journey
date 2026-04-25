package com.calebkitheka.dsa.trees;

import com.calebkitheka.dsa.utils.TreeNode;
import java.util.*;

public class ZigzagLevelOrder {

    /**
     * Returns zigzag level-order traversal of a binary tree.
     * Time: O(n), Space: O(n)
     *
     * Uses standard BFS queue, but flips collection direction
     * at each level using a boolean flag.
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Direction flag

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Reverse direction for alternate levels
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Flip direction for next level
        }

        return result;
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 14: Zigzag Level Order Traversal ===\n");

        // Test 1: Standard zigzag [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test 1: " + zigzagLevelOrder(t1));
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(20, 9),
                Arrays.asList(15, 7)
        );
        System.out.println("✅ Pass: " + zigzagLevelOrder(t1).equals(expected1) + "\n");

        // Test 2: Single node [1]
        TreeNode t2 = new TreeNode(1);
        System.out.println("Test 2: " + zigzagLevelOrder(t2));
        System.out.println("✅ Pass: " + zigzagLevelOrder(t2).equals(Arrays.asList(Arrays.asList(1))) + "\n");

        // Test 3: Empty tree
        System.out.println("Test 3: " + zigzagLevelOrder(null));
        System.out.println("✅ Pass: " + zigzagLevelOrder(null).isEmpty() + "\n");

        // Test 4: Skewed tree [1,2,null,3]
        TreeNode t4 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        System.out.println("Test 4: " + zigzagLevelOrder(t4));
        List<List<Integer>> expected4 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );
        System.out.println("✅ Pass: " + zigzagLevelOrder(t4).equals(expected4) + "\n");

        // Test 5: Perfect tree [1,2,3,4,5,6,7]
        TreeNode t5 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println("Test 5: " + zigzagLevelOrder(t5));
        List<List<Integer>> expected5 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
        );
        System.out.println("✅ Pass: " + zigzagLevelOrder(t5).equals(expected5) + "\n");

        System.out.println("🎉 All tests passed! Zigzag BFS mastered.");
    }
}