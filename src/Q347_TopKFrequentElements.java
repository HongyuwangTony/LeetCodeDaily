import java.util.*;

public class Q347_TopKFrequentElements {
    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            int len = nums.length;
            HashMap<Integer, Integer> map_freq = new HashMap<>();
            ArrayList<Integer>[] reverse_map = new ArrayList[len];
            for (int num : nums) {
                map_freq.put(num, map_freq.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map_freq.entrySet()) {
                int index = entry.getValue() - 1;
                if (reverse_map[index] == null) reverse_map[index] = new ArrayList<>();
                reverse_map[index].add(entry.getKey());
            }
            int size = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = len - 1; i >= 0 && size < k; i--) {
                ArrayList<Integer> nums_freq = reverse_map[i];
                if (nums_freq == null) continue;
                for (int num : nums_freq) {
                    list.add(num);
                    if (++size == k) break;
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(new Solution().topKFrequent(new int[]{1}, 1));
    }
}
