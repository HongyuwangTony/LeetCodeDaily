import java.util.Arrays;

public class Q529_Minesweeper {
    static class Solution {
        public static int[] adj_x = {-1, 0, 1, -1, 1, -1, 0, 1};
        public static int[] adj_y = {-1, -1, -1, 0, 0, 1, 1, 1};
        public char[][] updateBoard(char[][] board, int[] click) {
            int height = board.length, width = board[0].length;
            int click_y = click[0];
            int click_x = click[1];
            if (click_x < 0 || click_x >= width || click_y < 0 || click_y >= height) return board;
            switch (board[click_y][click_x]) {
                case 'M':
                    board[click_y][click_x] = 'X';
                    break;
                case 'E':
                    int numMines = 0;
                    for (int i = 0; i < 8; i++) {
                        int x = click_x + adj_x[i], y = click_y + adj_y[i];
                        if (x < 0 || x >= width || y < 0 || y >= height) continue;
                        if (board[y][x] == 'M') numMines++;
                    }
                    if (numMines > 0) {
                        board[click_y][click_x] = Character.forDigit(numMines, 10);
                        break;
                    }
                    board[click_y][click_x] = 'B';
                    for (int i = 0; i < 8; i++)
                        updateBoard(board, new int[]{click_y + adj_y[i], click_x + adj_x[i]});
                default:
                    break;
            }
            return board;
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        printBoard(new Solution().updateBoard(
                new char[][]{
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'}
                }, new int[]{3, 0}
        ));
    }
}
