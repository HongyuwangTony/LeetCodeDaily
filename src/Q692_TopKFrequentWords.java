import java.util.*;

public class Q692_TopKFrequentWords {
    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map_freq = new HashMap<>();
            for (String word : words) {
                int newFreq = map_freq.containsKey(word) ? map_freq.get(word) + 1 : 1;
                map_freq.put(word, newFreq);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue() == o2.getValue() ?
                            o2.getKey().compareTo(o1.getKey()) : (o1.getValue().compareTo(o2.getValue()));
                }
            });
            int size = 0;
            for (Map.Entry<String, Integer> entry : map_freq.entrySet()) {
                pq.offer(entry);
                if (size == k) pq.poll();
                else size++;
            }
            LinkedList<String> list = new LinkedList<>();
            while(!pq.isEmpty()) list.addFirst(pq.poll().getKey());
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new Solution().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
