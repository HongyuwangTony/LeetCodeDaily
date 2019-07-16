public class Q11_ContainerWithMostWater {
    static class Solution {
        public int maxArea(int[] height) {
            int lo = 0, hi = height.length - 1, volume = 0;
            while (lo < hi) {
                int depth = Math.min(height[lo], height[hi]);
                volume = Math.max(volume, depth * (hi - lo));
                while (height[lo] <= depth && lo < hi) lo++;
                while (height[hi] <= depth && lo < hi) hi--;
            }
            return volume;
        }
    }
}
