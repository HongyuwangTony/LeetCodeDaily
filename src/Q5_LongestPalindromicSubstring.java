public class Q5_LongestPalindromicSubstring {

    static class Solution {
        int maxLen, lo, hi, strlen;
//
//        public String longestPalindrome(String s) {
//            if (s.equals("")) return "";
//            maxLen = 1;
//            lo = 0;
//            hi = 0;
//            strlen = s.length();
//            for (int i = 0; i < strlen; i++) {
//                extendPalindrome(s, i - 1, i + 1);
//                extendPalindrome(s, i, i + 1);
//            }
//            return s.substring(lo, hi + 1);
//        }
//
//        public void extendPalindrome(String s, int lo, int hi) {
//            if (hi >= strlen || lo < 0) return;
//            if (s.charAt(lo) != s.charAt(hi)) return;
//            int currLen = hi - lo + 1;
//            if (currLen > maxLen) {
//                this.lo = lo;
//                this.hi = hi;
//                maxLen = currLen;
//            }
//            extendPalindrome(s, lo - 1, hi + 1);
//        }

        public String longestPalindrome(String s) {
            if (s.equals("")) return "";
            maxLen = 1;
            lo = 0;
            hi = 0;
            strlen = s.length();
            for (int i = 0; i < strlen; i++) {
                i = extendPalindrome(s, i);
            }
            return s.substring(lo, hi + 1);
        }

        public int extendPalindrome(String s, int index) {
            int lo = index - 1, hi = index;
            while (hi + 1 < strlen && s.charAt(hi) == s.charAt(hi + 1)) hi++;
            int nextIndex = hi++;
            while (lo >= 0 && hi < strlen && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
            }
            int currLen = hi - lo - 1;
            if (currLen > maxLen) {
                this.lo = lo + 1;
                this.hi = hi - 1;
                maxLen = currLen;
            }
            return nextIndex;
        }

    }

    /**
     * Test Code
     */
    public static void test(String input, String[] expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input: " + input);
        System.out.println("Expected Output: ");
        String result = new Solution().longestPalindrome(input);
        boolean passed = false;
        for (String s : expectedOutput) {
            System.out.println(s);
            if (s.equals(result)) {
                passed = true;
            }
        }
        System.out.println("Actual Output: " + result);
        assert passed;
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test("babad", new String[]{"bab", "aba"});
        test("cbbd", new String[]{"bb"});
        test("", new String[]{""});
    }
}
