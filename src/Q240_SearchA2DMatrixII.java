public class Q240_SearchA2DMatrixII {
    class Solution {
        private int numRow;
        private int numCol;

        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            numRow = matrix.length;
            numCol = matrix[0].length;
            int i = 0, j = numCol - 1;
            while (i < numRow && j >= 0) {
                if (target == matrix[i][j]) return true;
                else if (target > matrix[i][j]) i++;
                else j--;
            }
            return false;
        }
    }
}
