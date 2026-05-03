package com.calebkitheka.dsa.graphs;

public class WordSearch {

    /**
     * Checks if word exists in grid using DFS + backtracking.
     * Time: O(m × n × 4^L), Space: O(L) recursion stack
     *
     * Strategy: Try starting DFS from every cell.
     * At each step, mark cell as visited, explore 4 directions,
     * then backtrack (unmark) to restore grid for other paths.
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.isEmpty()) return false;

        int rows = board.length;
        int cols = board[0].length;

        // Try DFS starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true; // Found complete word
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int r, int c, String word, int index) {
        // Base case: matched entire word
        if (index == word.length()) return true;

        // Boundary checks & character match check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(index)) {
            return false;
        }

        // 🔑 BACKTRACKING STEP 1: Mark current cell as visited
        char temp = board[r][c];
        board[r][c] = '#'; // '#' acts as visited marker

        // Explore 4 directions
        boolean found = dfs(board, r + 1, c, word, index + 1) ||
                dfs(board, r - 1, c, word, index + 1) ||
                dfs(board, r, c + 1, word, index + 1) ||
                dfs(board, r, c - 1, word, index + 1);

        // 🔑 BACKTRACKING STEP 2: Restore original character
        board[r][c] = temp;

        return found;
    }

    // ============ TEST RUNNER ============
    // Note: exist() modifies board in-place, so we use fresh boards per test
    public static void main(String[] args) {
        System.out.println("=== Day 21: Word Search (DFS + Backtracking) ===\n");

        char[][] b1 = { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
        System.out.println("Test 1 \"ABCCED\": " + exist(b1, "ABCCED") + " | ✅ Pass: true");

        char[][] b2 = { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
        System.out.println("Test 2 \"SEE\": " + exist(b2, "SEE") + " | ✅ Pass: true");

        char[][] b3 = { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
        System.out.println("Test 3 \"ABCB\": " + exist(b3, "ABCB") + " | ✅ Pass: false");

        char[][] b4 = {{'a'}};
        System.out.println("Test 4 \"a\": " + exist(b4, "a") + " | ✅ Pass: true");

        char[][] b5 = { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
        System.out.println("Test 5 \"ABCESEEEFS\": " + exist(b5, "ABCESEEEFS") + " | ✅ Pass: false");

        System.out.println("\n All tests passed! Backtracking on grids mastered.");
    }
}