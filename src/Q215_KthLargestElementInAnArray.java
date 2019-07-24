import java.util.Arrays;
import java.util.PriorityQueue;

public class Q215_KthLargestElementInAnArray {
    static class Solution {
//        private static void swap(int[] nums, int i, int j) {
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//        }
//
//        private int partition(int[] nums, int lo, int hi) {
//            int pivot = nums[lo];
//            int i = lo, j = hi + 1;
//            while (true) {
//                while(i < hi && nums[++i] > pivot);
//                while(j > lo && pivot > nums[--j]);
//                if (i >= j) break;
//                swap(nums, i, j);
//            }
//            swap(nums, lo, j);
//            return j;
//        }
//
//        public int findKthLargest(int[] nums, int k) {
//            int lo = 0, hi = nums.length - 1;
//            while (lo < hi) {
//                int pivot = partition(nums, lo, hi);
//                if(pivot < k - 1) lo = pivot + 1;
//                else if (pivot > k - 1) hi = pivot - 1;
//                else break;
//            }
//            return nums[k - 1];
//        }


        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for(int num : nums) {
                if(heap.size() < k) {
                    heap.offer(num);
                } else {
                    if (num > heap.peek()) {
                        heap.poll();
                        heap.offer(num);
                    }
                }
            }
            return heap.peek();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
