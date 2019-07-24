import java.util.Arrays;

public class Q215_KthLargestElementInAnArray {
    static class Solution {
        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private int partition(int[] nums, int lo, int hi) {
            int pivot = nums[hi];
            int i = lo - 1;
            for (int j = lo; j < hi; j++) {
                if (nums[j] >= pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, hi);
            return i + 1;
        }

        private void quickSort(int[] nums, int lo, int hi, int k) {
            if (lo >= hi) return;
            int pivot = partition(nums, lo, hi) - lo;
//            System.out.println("lo: " + lo + ", hi: " + hi + ", k: " + k + " " + Arrays.toString(nums));
            if (pivot == k - 1) return;
            else if (pivot < k - 1) quickSort(nums, lo + pivot + 1, hi, k - pivot - 1);
            else quickSort(nums, lo, lo + pivot - 1, k);
        }

        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1, k);
            return nums[k - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
