import java.util.*;

public class Q347_TopKFrequentElements {
    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map_freq = new HashMap<>();
            for (int num : nums) {
                Integer freq = map_freq.get(num);
                int newFreq = freq == null ? 1 : freq + 1;
                map_freq.put(num, newFreq);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() == o2.getValue() ?
                            o2.getKey().compareTo(o1.getKey()) : o1.getValue().compareTo(o2.getValue());
                }
            });
            int size = 0;
            for (Map.Entry<Integer, Integer> entry : map_freq.entrySet()) {
                pq.offer(entry);
                if (size == k) pq.poll();
                else size++;
            }
            LinkedList<Integer> list = new LinkedList<>();
            while(!pq.isEmpty()) list.addFirst(pq.poll().getKey());
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(new Solution().topKFrequent(new int[]{1}, 1));
    }
}
