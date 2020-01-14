import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Q1048_LongestStringChain {
    static class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            HashMap<String, Integer> map = new HashMap<>();
            int retval = 1;
            for (String word : words) {
                int len = 1;
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.deleteCharAt(i);
                    len = Math.max(len, map.getOrDefault(sb.toString(), 0) + 1);
                }
                map.put(word, len);
                retval = Math.max(retval, len);
            }
            return retval;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println("Expected: 4\n");
    }
}
