import java.util.Arrays;
import java.util.PriorityQueue;

public class Q215_KthLargestElementInAnArray {
    static class Solution {
        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private int quickSelect(int[] nums, int lo, int hi, int k) {
            if (lo == hi) return nums[lo];
            int left = lo, right = hi, mid = lo + (hi - lo) / 2;
            int pivot = nums[mid];
            while (left < right) {
                while (left <= right && nums[left] > pivot) left++;
                while (left <= right && nums[right] < pivot) right--;
                if (left <= right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }

            int target = lo + k - 1;
            if (target <= right) return quickSelect(nums, lo, right, k);
            if (target >= left) return quickSelect(nums, left, hi,k - (left - lo));
            return nums[right + 1];
        }

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums,0, nums.length - 1, k);
        }


//        public int findKthLargest(int[] nums, int k) {
//            PriorityQueue<Integer> heap = new PriorityQueue<>();
//            for(int num : nums) {
//                if(heap.size() < k) {
//                    heap.offer(num);
//                } else {
//                    if (num > heap.peek()) {
//                        heap.poll();
//                        heap.offer(num);
//                    }
//                }
//            }
//            return heap.peek();
//        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
