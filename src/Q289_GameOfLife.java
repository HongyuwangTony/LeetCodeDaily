public class Q289_GameOfLife {
    static class Solution {
        int[] position_x = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] position_y = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

        public void spread(int[][] board, int y, int x, int height, int width) {
            for (int i = 0; i < 8; i++) {
                int y_neighbor = y + position_y[i];
                int x_neighbor = x + position_x[i];
                if (y_neighbor < 0 || y_neighbor >= height || x_neighbor < 0 || x_neighbor >= width) continue;
                board[y_neighbor][x_neighbor] ++;
            }
        }

        public void gameOfLife(int[][] board) {
            int height = board.length;
            int width = board[0].length;
            int[][] num_neighbors = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (board[i][j] == 0) continue;
                    spread(num_neighbors, i, j, height, width);
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int life = board[i][j];
                    int num = num_neighbors[i][j];
                    if (life == 0 && num == 3) board[i][j] = 1;
                    else if (life == 1 && (num == 2 || num == 3)) board[i][j] = 0;
                }
            }
        }
    }
}
