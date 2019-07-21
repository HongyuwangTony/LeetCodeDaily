import java.util.LinkedList;
import java.util.List;

public class Q46_Permutations {
    static class Solution {
        private List<List<Integer>> permute(int[] nums, int start) {
            int len = nums.length - start;
            List<List<Integer>> ret = new LinkedList<>();
            if (len == 0) return ret;
            else if (len == 1) {
                List<Integer> permutation = new LinkedList<>();
                permutation.add(nums[start]);
                ret.add(permutation);
                return ret;
            }
            List<List<Integer>> smaller = permute(nums, start + 1);
            for (List<Integer> permutation : smaller) {
                permutation.add(nums[start]);
                ret.add(new LinkedList<>(permutation));
                for (int i = 0; i < len - 1; i++) {
                    permutation.add(permutation.remove(0));
                    ret.add(new LinkedList<>(permutation));
                }
            }
            return ret;
        }

        public List<List<Integer>> permute(int[] nums) {
            return permute(nums, 0);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}
