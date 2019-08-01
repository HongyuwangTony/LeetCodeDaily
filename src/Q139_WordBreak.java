import java.util.HashSet;
import java.util.List;

public class Q139_WordBreak {
    static class Solution {
        // Referring to DP method in https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
        public boolean wordBreak(String s, List<String> wordDict) {
            int strlen = s.length();
            if (strlen == 0) return true;
            HashSet<String> set = new HashSet<>(wordDict);
            boolean dp[] = new boolean[strlen + 1];
            dp[0] = true;
            for (int i = 1; i <= strlen; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[strlen];
        }

        // TODO: TireNode Method
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(new Solution().wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(new Solution().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}
