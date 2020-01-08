import java.util.Stack;

public class Q1130_MinimumCostTreeFromLeafValues {
    static class Solution {
        // Solution 1: DP
//        public int mctFromLeafValues(int[] arr) {
//            int max[][] = new int[arr.length][arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                int currMax = arr[i];
//                for (int j = i; j < arr.length; j++) {
//                    if (arr[j] > currMax) currMax = arr[j];
//                    max[i][j] = currMax;
//                }
//            }
//            int dp[][] = new int[arr.length][arr.length];
//            for (int diff = 1; diff < arr.length; diff++) {
//                for (int i = 0; i + diff < arr.length; i++) {
//                    int j = i + diff;
//                    if (diff == 1) dp[i][j] = arr[i] * arr[j];
//                    else {
//                        dp[i][j] = Integer.MAX_VALUE;
//                        for (int k = i; k < j; k++) {
//                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
//                        }
//                    }
//                }
//            }
//            return dp[0][arr.length - 1];
//        }

        // Solution 2: Stack
        public int mctFromLeafValues(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            stack.push(Integer.MAX_VALUE);
            int retval = 0;
            for (int x : arr) {
                // Find local minimum
                // Remove the smallest leaf and decide whether it belongs to the left/right
                while (stack.peek() <= x) retval += stack.pop() * Math.min(stack.peek(), x);
                stack.push(x);
            }
            // Descending order in the resulting stack
            while (stack.size() > 2) retval += stack.pop() * stack.peek();
            return retval;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mctFromLeafValues(new int[]{6, 2, 4}));
        System.out.println("Expected: 32\n");
    }
}
