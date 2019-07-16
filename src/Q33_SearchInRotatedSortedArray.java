public class Q33_SearchInRotatedSortedArray {
    static class Solution {
        public int findPivot(int[] nums, int lo, int hi) {
            if (lo == hi || nums[lo] < nums[hi]) return lo;
            else if (lo == hi - 1) return hi; // Prevent mid == lo
            int mid = (lo + hi) / 2;
            if (nums[0] < nums[mid]) return findPivot(nums, mid + 1, hi);
            else return findPivot(nums, lo, mid);
        }

        public int binarySearch(int[] nums, int target, int pivot, int lo, int hi) {
            if (lo > hi) return -1;
            int mid = (lo + hi) / 2;
            int mid_ = mid + pivot;
            if (mid >= nums.length) mid_ -= nums.length;
            if (target == nums[mid_]) return mid_;
            else if (target > nums[mid_]) return binarySearch(nums, target, pivot, mid + 1, hi);
            else return binarySearch(nums, target, pivot, lo, mid - 1);
        }

        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int pivot = findPivot(nums, 0, nums.length - 1);
            System.out.println("Pivot: " + pivot);
            return binarySearch(nums, target, pivot, 0, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{3, 1}, 1));
    }
}
