public class Q8_StringToInteger_Atoi {
    static class Solution {
        public int myAtoi(String str) {
            int strlen = str.length();
            char[] arr = str.toCharArray();
            boolean positive = true;
            int value = 0;
            for (int i = 0; i < strlen; i++) {
                if (arr[i] == ' ') continue;
                else if (arr[i] == '+') i++;
                else if (arr[i] == '-') {
                    positive = false;
                    i++;
                }
                for (; i < strlen; i++) {
                    if (arr[i] < '0' || arr[i] > '9') break;
                    int digit = arr[i] - '0';

                    if (positive) {
                        if (value > Integer.MAX_VALUE / 10) return Integer.MAX_VALUE;
                        else if (value == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) return Integer.MAX_VALUE;
                    } else {
                        if (-value < Integer.MIN_VALUE / 10) return Integer.MIN_VALUE;
                        else if (-value == Integer.MIN_VALUE / 10 && -digit < Integer.MIN_VALUE % 10) return Integer.MIN_VALUE;
                     }

                    value = value * 10 + digit;
                }
                break;
            }
            return positive ? value : -value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("42"));
        System.out.println(new Solution().myAtoi("   -42"));
        System.out.println(new Solution().myAtoi("4193 with words"));
        System.out.println(new Solution().myAtoi("words and 987"));
        System.out.println(new Solution().myAtoi("-91283472332"));
        System.out.println(new Solution().myAtoi("-2147483647"));
        System.out.println(Integer.MIN_VALUE % 10);
    }
}
