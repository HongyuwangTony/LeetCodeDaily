import java.util.*;

public class Q973_KClosestPointsToOrigin {
    static class Solution {
        public void swap(int[][] points, int i, int j) {
            int[] temp = points[i].clone();
            points[i] = points[j];
            points[j] = temp;
        }

        public int comparePoints(int[] p1, int[] p2) {
//            System.out.println(Arrays.toString(p1) + " " + Arrays.toString(p2));
//            System.out.println(p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
            return (p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        }

        public int partition(int[][] points, int lo, int hi) {
            int[] pivot = points[hi];
            int i = lo - 1;
            for (int j = lo; j < hi; j++) {
                if (comparePoints(points[j], pivot) <= 0) {
                    i++;
                    swap(points, i, j);
                }
            }
            swap(points, i + 1, hi);
            return i + 1;
        }

        // Quick Sort for first K elements
        public void quickSort(int[][] points, int lo, int hi, int K) {
            if (lo >= hi) return;
            System.out.println("Quick sorting on lo: " + lo + " hi: " + hi + " K: " + K);
            int pivot = partition(points, lo, hi) - lo;
            System.out.println("After Partitioning: ");
            for (int[] point : points) {
                System.out.print(Arrays.toString(point) + ", ");
            }
            System.out.println();
            if (pivot == K - 1) return;
            else if (pivot < K - 1) quickSort(points, lo + pivot + 1, hi, K - pivot - 1);
            else quickSort(points, lo, lo + pivot - 1, K);
        }

        public int[][] kClosest(int[][] points, int K) {
            if (points.length <= K) return points;
            quickSort(points, 0, points.length - 1, K);

            int[][] ret = new int[K][2];
            for (int i = 0; i < K; i++) {
                ret[i] = points[i];
            }
            return ret;
        }

    }


    public static int[][] input_to_points(String inputs_args) {
        List<int[]> list = new ArrayList<>();
        for (String args : inputs_args.split("]")) {
            args = args.substring(args.indexOf("[") + 1);
            int index = args.indexOf(",");
            list.add(new int[]{Integer.valueOf(args.substring(0, index)),
                    Integer.valueOf(args.substring(index + 1))});
        }
        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void test(String input_points, int K, String expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input:");
        System.out.println("Points: " + input_points);
        System.out.println("K: " + K);
        int[][] result = new Solution().kClosest(input_to_points(input_points), K);
        System.out.println("Expected Output: " + expectedOutput);
        System.out.print("Actual Output: ");
        for (int[] point : result) {
            System.out.print(Arrays.toString(point) + ", ");
        }
        System.out.println("\n");
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test("[1,3],[-2,2]", 1, "[[-2, 2]]");
        test("[3,3],[5,-1],[-2,4]", 2, "[[3,3],[-2,4]]");
        test("[6,10],[-3,3],[-2,5],[0,2]", 3, "[[0,2],[-3,3],[-2,5]]");
        test("[-2,5],[7,-2],[-8,0],[2,9],[-1,3],[-3,9],[-6,8],[-5,-5]" , 7, "[[-1,3],[-2,5],[-5,-5],[7,-2],[-8,0],[2,9],[-3,9]]");
    }
}
