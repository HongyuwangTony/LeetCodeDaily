public class Q200_NumberOfIslands {
    static class Solution {
        public boolean[][] visited;
        public int numRows;
        public int numCols;

        public void dfs(char[][] grid, int i, int j) {
            if (grid[i][j] == '0' || visited[i][j]) return;
            visited[i][j] = true;
            if (i > 0) dfs(grid, i - 1, j);
            if (i < numRows - 1) dfs(grid, i + 1, j);
            if (j > 0) dfs(grid, i, j - 1);
            if (j < numCols - 1) dfs(grid, i, j + 1);
        }

        public int numIslands(char[][] grid) {
            numRows = grid.length;
            if (numRows == 0) return 0;
            numCols = grid[0].length;
            visited = new boolean[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    visited[i][j] = false;
                }
            }

            int result = 0;
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if(grid[i][j] == '1' && !visited[i][j]) {
                        dfs(grid, i, j);
                        result++;
                    }
                }
            }
            return result;
        }
    }

    /**
     * Test Code
     */

    public static char[][] createGrid(String grid_s) {
        if (grid_s.equals("")) {
            return new char[][]{};
        }
        String[] rows = grid_s.split("\n");
        final int numRows = rows.length;
        final int numCols = rows[0].length();
        char[][] ret = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                ret[i][j] = rows[i].charAt(j);
            }
        }
        return ret;
    }

    public static void test(String grid_s, int expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input:");
        System.out.println(grid_s);
        System.out.println("Expected Output: " + expectedOutput);
        int result = new Solution().numIslands(createGrid(grid_s));
        System.out.println("Actual Output: " + result);
        assert result == expectedOutput;
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test("", 0);
        test("11110\n" +
                "11010\n" +
                "11000\n" +
                "00000", 1);
        test("11000\n" +
                "11000\n" +
                "00100\n" +
                "00011", 3);
    }
}
