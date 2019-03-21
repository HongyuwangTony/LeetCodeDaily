import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * Q3: Longest Substring Without Repeating Characters
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
        /**
         * Solution 1: Use one HashSet and one Queue
         */
//        public int lengthOfLongestSubstring(String s) {
//            int i, start = 0, max = 0, strlen = s.length();
//            Set<Character> set = new HashSet<>();
//            ArrayDeque<Character> queue = new ArrayDeque<>();
//            for (i = 0; i < strlen; i++) {
//                char c = s.charAt(i);
//                if (set.contains(c)) {
//                    max = Math.max(max, i - start);
//                    char c_;
//                    while ( (c_ = queue.removeFirst()) != c) {
//                        set.remove(c_);
//                        start++;
//                    }
//                    set.remove(c_);
//                    start++;
//                }
//                queue.addLast(c);
//                set.add(c);
//            }
//            max = Math.max(max, i - start);
//            return max;
//        }

        /**
         * Solution 2: Use one HashSet
         */
//        public int lengthOfLongestSubstring(String s) {
//            int i = 0, start = 0, max = 0, strlen = s.length();
//            Set<Character> set = new HashSet<>();
//            while (i < strlen) {
//                char c = s.charAt(i);
//                if (set.contains(c)) set.remove(s.charAt(start++));
//                else {
//                    set.add(s.charAt(i++));
//                    max = Math.max(max, set.size());
//                }
//            }
//            return max;
//        }


        /**
         * Solution 3: Use a String as pool
         */
        public int lengthOfLongestSubstring(String s) {
            int max = 0, strlen = s.length(), index;
            String pool = "";
            for (int i = 0; i < strlen; i++) {
                char c = s.charAt(i);
                if ( (index = pool.indexOf(c)) != -1) {
                    max = Math.max(max, pool.length());
                    pool = pool.substring(index + 1);
                }
                pool += c;
            }
            return Math.max(max, pool.length());
        }
    }

    public static void test(String input, int expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input: " + input);
        System.out.println("Expected Output: " + expectedOutput);
        int result = new Solution().lengthOfLongestSubstring(input);
        System.out.println("Actual Output: " + result);
        assert result == expectedOutput;
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test("abcabcbb", 3);
        test("bbbbb", 1);
        test("pwwkew", 3);
    }
}
