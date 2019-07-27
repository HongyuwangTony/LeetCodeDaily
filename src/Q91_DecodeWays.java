import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q91_DecodeWays {
    static class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for(int i = 2; i <= n; i++) {
                if (s.charAt(i - 1) != '0') dp[i] = dp[i - 1];
                else if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') return 0;

                int code = Integer.valueOf(s.substring(i - 2, i));
                if(code >= 10 && code <= 26) dp[i] += dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("226")); // 2 2 6, 22 6, 2 26
        System.out.println(new Solution().numDecodings("2260"));
        System.out.println(new Solution().numDecodings("0"));
        System.out.println(new Solution().numDecodings("01"));
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("110"));
    }
}
