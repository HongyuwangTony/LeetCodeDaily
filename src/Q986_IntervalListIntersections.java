import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q986_IntervalListIntersections {
    static class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            int A_len = A.length, B_len = B.length;
            if (A_len == 0 || B_len == 0) return new int[][]{};
            List<int[]> intersection = new ArrayList<>();
            int index_A = 0, index_B = 0;
            while (index_A < A_len && index_B < B_len) {
                int[] head_A = A[index_A], head_B = B[index_B];
                boolean A_first = head_A[0] < head_B[0] || (head_A[0] == head_B[0] && head_A[1] <= head_B[1]);
                int[] first = A_first ? head_A : head_B, second = A_first ? head_B : head_A;
                if (first[1] >= second[0]) {
                    if (first[1] >= second[1]) {
                        intersection.add(second);
                        A_first = !A_first;
                    } else intersection.add(new int[]{second[0], first[1]});
                }
                if (A_first) index_A++;
                else index_B++;
            }
            return intersection.toArray(new int[intersection.size()][2]);
        }
    }

    public static void printResult(int[][] res) {
        for (int[] interval : res) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printResult(new Solution().intervalIntersection(
                new int[][]{{0,2},{5,10},{13,23},{24,25}},
                new int[][]{{1,5},{8,12},{15,24},{25,26}}));
        printResult(new Solution().intervalIntersection(
                new int[][]{},
                new int[][]{{1,5},{8,12},{15,24},{25,26}}));
        printResult(new Solution().intervalIntersection(
                new int[][]{{5,10}},
                new int[][]{{5,6}}));
        printResult(new Solution().intervalIntersection(
                new int[][]{{3,5},{9,20}},
                new int[][]{{4,5},{7,10},{11,12},{14,15},{16,20}}));
    }
}
