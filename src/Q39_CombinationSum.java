import java.util.*;

public class Q39_CombinationSum {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>>[] dp = new List[target + 1];
            for (int candidate : candidates) {
                if (candidate > target) continue;
                dp[candidate] = new ArrayList<>();
                LinkedList<Integer> combination = new LinkedList<>();
                combination.add(candidate);
                dp[candidate].add(combination);
            }

            for (int i = 1; i < target; i++) {
                if (dp[i] == null) continue;
                for (List<Integer> comb : dp[i]) {
                    int tail = comb.get(comb.size() - 1);
                    for (int candidate : candidates) {
                        if (candidate < tail) continue;

                        int sum = i + candidate;
                        if (sum > target) continue;

                        if (dp[sum] == null) dp[sum] = new ArrayList<>();
                        LinkedList<Integer> newComb = new LinkedList<>(comb);
                        newComb.add(candidate);
                        dp[sum].add(newComb);
                    }
                }
            }

            return dp[target] == null ? new ArrayList<>() : dp[target];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));
        System.out.println(new Solution().combinationSum(new int[]{2}, 1));
    }
}
