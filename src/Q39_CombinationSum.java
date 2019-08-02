import java.util.*;

public class Q39_CombinationSum {
    static class Solution {
        private void combinationSumHelper(int[] candidates, int target, int index_min,
                                          LinkedList<Integer> comb, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new LinkedList<>(comb));
                return;
            }
            int numCandidates = candidates.length;
            for (int i = index_min; i < numCandidates; i++) {
                int candidate = candidates[i];
                if (target < candidate) break;
                comb.add(candidate);
                combinationSumHelper(candidates, target - candidate, i, comb, res);
                comb.removeLast();
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new LinkedList<>();
            combinationSumHelper(candidates, target,0, new LinkedList<>(), res);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));
        System.out.println(new Solution().combinationSum(new int[]{2}, 1));
    }
}
