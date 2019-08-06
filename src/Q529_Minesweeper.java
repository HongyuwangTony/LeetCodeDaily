import java.util.Arrays;

public class Q529_Minesweeper {
    static class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {

        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().updateBoard(
                new char[][]{
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'}
                }, new int[]{3, 0}
        )));
    }
}
