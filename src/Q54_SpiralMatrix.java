import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q54_SpiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix.length == 0) return res;
            int dir = 0;
            int x = -1, y = 0;
            int x_lower = 0, x_upper = matrix[0].length - 1, y_lower = 0, y_upper = matrix.length - 1;
            while (true) {
                if (x > x_upper || x_lower > x_upper) break;
                while (x < x_upper) res.add(matrix[y][++x]);
                y_lower++;

                if (y > y_upper || y_lower > y_upper) break;
                while (y < y_upper) res.add(matrix[++y][x]);
                x_upper--;

                if (x < x_lower || x_lower > x_upper) break;
                while (x > x_lower) res.add(matrix[y][--x]);
                y_upper--;

                if (y < y_lower || y_lower > y_upper) break;
                while (y > y_lower) res.add(matrix[--y][x]);
                x_lower++;
            }
            return res;
        }
    }
}
