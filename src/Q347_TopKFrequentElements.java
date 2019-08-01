import java.util.*;

public class Q347_TopKFrequentElements {
    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            int len = nums.length;
            HashMap<Integer, Integer> map_freq = new HashMap<>();
            ArrayList<Integer>[] reverse_map = new ArrayList[len];
            for (int num : nums) {
                int freq = map_freq.getOrDefault(num, 0) + 1;
                map_freq.put(num, freq);
                if (reverse_map[freq - 1] == null) reverse_map[freq - 1] = new ArrayList<>();
                reverse_map[freq - 1].add(num);
            }
            int size = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = len - 1; i >= 0; i--) {
                ArrayList<Integer> nums_freq = reverse_map[i];
                if (nums_freq == null) continue;
                for (int num : nums_freq) {
                    if (!map_freq.containsKey(num)) continue;
                    list.add(num);
                    map_freq.remove(num);
                    if (++size == k) break;
                }
                if (size == k) break;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(new Solution().topKFrequent(new int[]{1}, 1));
    }
}
