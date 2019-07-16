import java.util.*;

public class Q49_GroupAnagrams {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> anagrams = new ArrayList<>();
            Map<String, List<String>> map_anagram = new HashMap<>();
            for (String str : strs) {
                char[] str_c = str.toCharArray();
                Arrays.sort(str_c);
                String str_sorted = String.valueOf(str_c);
                if (map_anagram.containsKey(str_sorted)) {
                    map_anagram.get(str_sorted).add(str);
                } else {
                    List<String> anagram = new ArrayList<>();
                    anagram.add(str);
                    anagrams.add(anagram);
                    map_anagram.put(str_sorted, anagram);
                }
            }
            return anagrams;
        }
    }
}
