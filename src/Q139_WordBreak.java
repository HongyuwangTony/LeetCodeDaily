import java.util.List;
import java.util.TreeSet;

public class Q139_WordBreak {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(new Solution().wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(new Solution().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
