import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q17_LetterCombinationsOfAPhoneNumber {
    static class Solution {
//        private final HashMap<Integer, String> digit_to_letter = new HashMap<>() {{
//            put(2, "abc");
//            put(3, "def");
//            put(4, "ghi");
//            put(5, "jkl");
//            put(6, "mno");
//            put(7, "pqrs");
//            put(8, "tuv");
//            put(9, "wxyz");
//        }};
        private static final String[] digit_to_letter = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        private static char getLetter(int digitIndex, int index) {
            String letters = digit_to_letter[digitIndex];
            if (index >= letters.length()) return 0;
            else return letters.charAt(index);
        }

        private void letterCombinations(char[] digits, int index, String prefix, List<String> res) {
            if (index >= digits.length) {
                res.add(prefix);
                return;
            }
            char digit = digits[index];
            int digitIndex = digit - '2';
            char letter;
            int count = 0;
            while ((letter = getLetter(digitIndex, count++)) != 0) {
                letterCombinations(digits, index + 1, prefix + letter, res);
            }
        }

        public List<String> letterCombinations(String digits) {
            List<String> res = new LinkedList<>();
            if (digits.length() != 0)
                letterCombinations(digits.toCharArray(), 0, "", res);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations("22"));
        System.out.println(new Solution().letterCombinations(""));
    }
}
