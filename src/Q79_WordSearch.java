public class Q79_WordSearch {
    static class Solution {
        private boolean[][] visited;

        private boolean exist(char[][] board, String word, int index, int x, int y) {
            if (index >= word.length()) return true;
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
            if (visited[x][y]) return false;
            if (board[x][y] != word.charAt(index)) return false;

            visited[x][y] = true;
            if (exist(board, word, index + 1, x - 1, y) ||
                    exist(board, word, index + 1, x + 1, y) ||
                    exist(board, word, index + 1, x, y - 1) ||
                    exist(board, word, index + 1, x, y + 1)) return true;
            visited[x][y] = false;

            return false;
        }

        public boolean exist(char[][] board, String word) {
            if (board.length == 0) return false;
            int height = board.length;
            int width = board[0].length;
            visited = new boolean[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (exist(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(
                new char[][]{{'A','B','C','E'},
                             {'S','F','C','S'},
                             {'A','D','E','E'}},
                "ABCCED"
        ));
    }
}
