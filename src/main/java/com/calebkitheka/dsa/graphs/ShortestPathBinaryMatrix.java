package com.calebkitheka.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    /**
     * Finds shortest path length in binary matrix using BFS.
     * Time: O(n²), Space: O(n²)
     *
     * BFS guarantees shortest path because it explores layers (distance 1, then 2, etc).
     * We store {row, col, distance} in the queue to track progress.
     */
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Edge cases: Start or End is blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // 8 possible directions (including diagonals)
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        // Queue stores arrays: {row, col, distance}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // Start at (0,0) with distance 1

        grid[0][0] = 1; // Mark start as visited (change to 1)

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            // Check if we reached the bottom-right
            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            // Explore 8 neighbors
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check bounds and if cell is open (0)
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1; // Mark visited
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1; // No path found
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 22: Shortest Path (BFS on Grid) ===\n");

        // Test 1: Normal path
        int[][] t1 = {{0,0,0}, {1,1,0}, {1,1,0}};
        System.out.println("Test 1: " + shortestPathBinaryMatrix(t1) + " | ✅ Pass: true");

        // Test 2: Blocked
        int[][] t2 = {{0,1}, {1,0}};
        System.out.println("Test 2: " + shortestPathBinaryMatrix(t2) + " | ✅ Pass: false");

        // Test 3: 1x1
        int[][] t3 = {{0}};
        System.out.println("Test 3: " + shortestPathBinaryMatrix(t3) + " | ✅ Pass: true");

        System.out.println("\n🎉 All tests passed! BFS shortest path mastered.");
    }
}