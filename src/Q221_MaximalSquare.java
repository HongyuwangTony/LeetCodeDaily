public class Q221_MaximalSquare {
    static class Solution {
        private int calcMaxWidth(int left, int upper, int leftUpper) {
            if (left == 0 || upper == 0 || leftUpper == 0) return 1;
            return Math.min(left, Math.min(upper, leftUpper)) + 1;
        }

        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int height = matrix.length, width = matrix[0].length;
            int[][] dp = new int[height][width];
            int maxSquareWidth = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int newWidth;
                    if (matrix[i][j] == '0') newWidth = 0;
                    else if (i == 0 || j == 0) newWidth = 1;
                    else newWidth = calcMaxWidth(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                    if (newWidth > maxSquareWidth) maxSquareWidth = newWidth;
                    dp[i][j] = newWidth;
                }
            }
            return maxSquareWidth * maxSquareWidth;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(
                new char[][]{
                        {'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                }));
        System.out.println(new Solution().maximalSquare(
                new char[][]{
                        {'1','1','1','0','0'},
                        {'1','1','1','0','0'},
                        {'1','1','1','1','1'},
                        {'0','1','1','1','1'},
                        {'0','1','1','1','1'},
                        {'0','1','1','1','1'}
                }
        ));
    }
}
