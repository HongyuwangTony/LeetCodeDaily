import java.util.HashMap;

public class Q12_IntegerToRoman {
    static class Solution {
        private int num_scale = 13;
        private int[] num_roman = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        private String[] str_roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < num_scale; i++) {
                int multiplier = num / num_roman[i];
                if (multiplier == 0) continue;
                for (int j = 0; j < multiplier; j++) {
                    res.append(str_roman[i]);
                }
                num %= num_roman[i];
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
    }
}
