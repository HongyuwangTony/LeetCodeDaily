import java.util.Arrays;

public class Q31_NextPermutation {
    static class Solution {
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int lo, int hi) {
            if (hi - lo <= 0) return;
            swap(nums, lo, hi);
            reverse(nums, lo + 1, hi - 1);
        }

        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len <= 1) return;

            int transition = -1, nextLarger = 0;
            for (int i = len - 1; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    transition = i - 1;
                    nextLarger = i;
                    break;
                }
            }
            if (transition != -1) {
                while (nextLarger < len - 1 && nums[nextLarger + 1] > nums[transition]) {
                    nextLarger++;
                }
            }

            if (transition == -1) {
                reverse(nums, 0, len - 1);
            } else if (transition == len - 1) {
                swap(nums, len - 2, len - 1);
            } else {
                swap(nums, transition, nextLarger);
                reverse(nums, transition + 1, len - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2, 3};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 1};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 5};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 4, 2, 6, 5};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 2, 4, 6, 5, 7};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 6, 5, 4, 3, 2};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 3, 1};
        System.out.print(Arrays.toString(nums) + " -> ");
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
