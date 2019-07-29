public class Q227_BasicCalculatorII {
    static class Solution {
        public int calculate(String s) {
            char[] arr = s.toCharArray();
            int len = s.length(), val = 0, res = 0, multiplier = 1;
            boolean plus = true, multiply = true;
            for (int i = 0; i < len; i++) {
                char c = arr[i];
                if (c == ' ') continue;
                else if (c >= '0' && c <= '9') val = val * 10 + (c - '0');
                else if (c == '+' || c == '-') {
                    res = res + (plus ? 1 : -1) * (multiply ? multiplier * val : multiplier / val);
                    multiply = true;
                    multiplier = 1;
                    plus = c == '+';
                    val = 0;
                } else {
                    multiplier = multiply ? multiplier * val : multiplier / val;
                    multiply = c == '*';
                    val = 0;
                }
            }
            return res + (plus ? 1 : -1) * (multiply ? multiplier * val : multiplier / val);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
        System.out.println(new Solution().calculate(" 3/2 "));
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
    }
}
