import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q15: 3Sum
 */
public class Q15_3Sum {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            if (nums == null || n < 3) return new ArrayList<>();
            Arrays.sort(nums);
            List<List<Integer>> ret = new ArrayList<>();
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int mid = i + 1, hi = n - 1, loVal = nums[i];
                while (mid < hi) {
                    int midVal = nums[mid], hiVal = nums[hi];
                    int currSum = loVal + midVal + hiVal;
                    if (currSum == 0) {
                        ret.add(Arrays.asList(loVal, midVal, hiVal));
                        do { mid++; } while (mid < hi && nums[mid] == nums[mid - 1]);
                        do { hi--; } while (mid < hi && nums[hi] == nums[hi + 1]);
                    }
                    else if (currSum < 0) mid++;
                    else hi--;
                }
            }
            return ret;
        }
    }

    public static String arrToString_2d(int[][] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) ret += (arrToString(arr[i]) + ", ");
            else ret += (arrToString(arr[i]) + "]");
        }
        return ret;
    }

    public static String arrToString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) ret += (arr[i] + ", ");
            else ret += (arr[i] + "]");
        }
        return ret;
    }

    public static void test(int[] input, int[][] expectedOutput) {
        // TODO: check content
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Expected Output: " + Arrays.deepToString(expectedOutput));
        List<List<Integer>> result = new Solution().threeSum(input);
        System.out.println("Actual Output: " + Arrays.toString(result.toArray()));
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test(new int[]{-1,0,1,2,-1,-4}, new int[][]{{-1,-1,2},{-1,0,1}});
        test(new int[]{-2, 0, 1, 1, 2}, new int[][]{{-2, 0, 2}, {-2, 1, 1}});

    }
}
