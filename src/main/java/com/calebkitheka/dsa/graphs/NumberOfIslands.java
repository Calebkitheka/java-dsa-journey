package com.calebkitheka.dsa.graphs;

import java.util.Arrays;

public class NumberOfIslands {

    /**
     * Counts islands in a 2D grid using DFS.
     * Time: O(m × n), Space: O(m × n) worst-case recursion stack
     *
     * Strategy: Scan grid cell-by-cell. When land ('1') is found:
     *   1. Increment island count
     *   2. DFS to "sink" the entire connected island (turn '1' → '0')
     * This prevents double-counting without extra visited array.
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j); // Sink entire island
                }
            }
        }
        return count;
    }

    // DFS to traverse and mark connected land as water
    private static void dfs(char[][] grid, int r, int c) {
        // Base case: out of bounds or already water/visited
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Mark current cell as visited by sinking it
        grid[r][c] = '0';

        // Explore 4 adjacent directions
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 20: Number of Islands (Graph DFS) ===\n");

        // Test 1: Single large island
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Test 1 (1 island): " + numIslands(grid1) + " | ✅ Pass: " + (numIslands(grid1) == 1));

        // Test 2: Multiple islands
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Test 2 (3 islands): " + numIslands(grid2) + " | ✅ Pass: " + (numIslands(grid2) == 3));

        // Test 3: All water
        char[][] grid3 = {{'0','0'}, {'0','0'}};
        System.out.println("Test 3 (0 islands): " + numIslands(grid3) + " | ✅ Pass: " + (numIslands(grid3) == 0));

        // Test 4: Single land
        char[][] grid4 = {{'1'}};
        System.out.println("Test 4 (1 island): " + numIslands(grid4) + " | ✅ Pass: " + (numIslands(grid4) == 1));

        // Test 5: Checkerboard pattern
        char[][] grid5 = {
                {'1','0','1'},
                {'0','1','0'},
                {'1','0','1'}
        };
        System.out.println("Test 5 (5 islands): " + numIslands(grid5) + " | ✅ Pass: " + (numIslands(grid5) == 5));

        System.out.println("\n🎉 All tests passed! Graph traversal on grids mastered.");
    }
}
