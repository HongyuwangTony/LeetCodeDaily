import java.util.*;

public class Q39_CombinationSum {
    static class Solution {
        private List<List<Integer>> combinationSumHelper(int[] candidates, int target, int index_min) {
            List<List<Integer>> res = new ArrayList<>();
            if (target == 0) {
                res.add(new ArrayList<>());
                return res;
            }
            int numCandidates = candidates.length;
            for (int i = index_min; i < numCandidates; i++) {
                int candidate = candidates[i];
                if (target < candidate) break;
                List<List<Integer>> combs = combinationSumHelper(candidates, target - candidate, i);
                for (List<Integer> comb : combs) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(candidate);
                    res.add(newComb);
                }
            }
            return res;
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            return combinationSumHelper(candidates, target, 0);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));
        System.out.println(new Solution().combinationSum(new int[]{2}, 1));
    }
}
