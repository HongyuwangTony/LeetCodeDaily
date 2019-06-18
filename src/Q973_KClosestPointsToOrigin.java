import java.util.*;

public class Q973_KClosestPointsToOrigin {
    static class Solution {
        public int[][] kClosest(int[][] points, int K) {
            List<int[]> list_points = Arrays.asList(points);
            Collections.sort(list_points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
                }
            });
            int[][] ret = new int[K][2];
            for (int i = 0; i < K; i++) {
                ret[i] = list_points.get(i);
            }
            return ret;
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

        public static void main(String[] args) {
            int[][] result = new Solution().kClosest(input_to_points("[1,3],[-2,2]"), 1);
            for (int[] point : result) {
                System.out.println(Arrays.toString(point));
            }
        }
    }
}
