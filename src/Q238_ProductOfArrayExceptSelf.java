import java.util.Arrays;

public class Q238_ProductOfArrayExceptSelf {
    static class Solution {
        // Note: Please solve it without division and in O(n)
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] res = new int[length];

            System.out.println(Arrays.toString(res));
            // From left to right
            int carry = 1;
            for (int i = 0; i < length; i++) {
                res[i] = carry;
                carry *= nums[i];
                System.out.println(carry);
            }
            System.out.println(Arrays.toString(res));

            // From right to left
            carry = 1;
            for (int i = length - 1; i >= 0; i--) {
                res[i] *= carry;
                carry *= nums[i];
            }

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{2, 3, 4, 5})));
    }
}
