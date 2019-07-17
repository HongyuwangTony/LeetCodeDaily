import java.util.HashMap;
import java.util.Map;

public class Q560_SubarraySumEqualsK {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int sum = 0, len = nums.length, ret = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            for (int i = 0; i < len; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    ret += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1}, 0));
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().subarraySum(new int[]{-1, -1, 1}, 0));
    }
}
