public class Q393_UTF8Validation {
    static class Solution {
        private boolean validUtf8(int[] data, int start) {
            if (start >= data.length) return true;
            int seq = data[start] & 0xFF;
            int numFollowed;
            if (seq >> 7 == 0) return validUtf8(data, start + 1);
            else if (seq >> 5 == 6) numFollowed = 1; // 110xxxxx
            else if (seq >> 4 == 14) numFollowed = 2; // 1110xxxx
            else if (seq >> 3 == 30) numFollowed = 3; // 11110xxx
            else return false;

            if (start + numFollowed >= data.length) return false;
            for (int i = 0; i < numFollowed; i++) {
                if ((data[++start] & 0xFF) >> 6 != 2) return false;
            }
            return validUtf8(data, start + 1);
        }

        public boolean validUtf8(int[] data) {
            if (data.length == 0) return true;
            return validUtf8(data, 0);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validUtf8(new int[]{197,130,1}));
        System.out.println(new Solution().validUtf8(new int[]{235,140,4}));
    }
}
