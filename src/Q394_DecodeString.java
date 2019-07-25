public class Q394_DecodeString {
    static class Solution {
        private int index = 0;

        private void append(StringBuilder res, StringBuilder prefix, int times) {
            for (int i = 0; i < times; i++) {
                res.append(prefix);
            }
        }

        private void decodeString(char[] s, StringBuilder res, StringBuilder prefix, int times) {
            if (index == s.length) {
                res.append(prefix);
                return;
            }

            char c = s[index++];
            if ('0' <= c && c <= '9') {
                int newTimes = c - '0';
                while ((c = s[index++]) != '[') {
                    newTimes = newTimes * 10 + (c - '0');
                }
                decodeString(s, prefix, new StringBuilder(), newTimes);
            } else if (c == ']') {
                append(res, prefix, times);
                return;
            } else prefix.append(c);

            decodeString(s, res, prefix, times);
        }

        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            decodeString(s.toCharArray(), res, new StringBuilder(), 0);
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}
