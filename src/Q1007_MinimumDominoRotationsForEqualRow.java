public class Q1007_MinimumDominoRotationsForEqualRow {
    static class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int len = A.length;
            if (len == 0) return 0;
            int count[][] = new int[6][3];
            for (int i = 0; i < len; i++) {
                int a = A[i], b = B[i];
                if (a == b) count[a - 1][0]++;
                else {
                    count[a - 1][1]++;
                    count[b - 1][2]++;
                }
            }
            int retval = -1;
            for (int i = 0; i < 6; i++) {
                int counts[] = count[i];
                if (counts[0] + counts[1] + counts[2] < len) continue;
                int swap = Math.min(counts[1], counts[2]);
                if (retval == -1) retval = swap;
                else retval = Math.min(retval, swap);
            }
            return retval;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println("Expected: 2\n");
        System.out.println(new Solution().minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
        System.out.println("Expected: -1\n");
    }
}
