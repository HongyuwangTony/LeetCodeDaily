import java.lang.reflect.Array;
import java.util.*;

public class Q735_AsteroidCollision {
    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            // Solution 1: Stack + Queue
//            Stack<Integer> stack = new Stack<>();
//            Queue<Integer> queue = new LinkedList<>();
//            for (int asteroid : asteroids) {
//                if (asteroid > 0) {
//                    stack.push(asteroid);
//                } else {
//                    asteroid = Math.abs(asteroid);
//                    boolean exists = true;
//                    while (!stack.isEmpty() && exists) {
//                        if (stack.peek() >= asteroid) exists = false;
//                        if (stack.peek() <= asteroid) stack.pop();
//                    }
//                    if (exists) queue.offer(-asteroid);
//                }
//            }
//            int retval[] = new int[queue.size() + stack.size()];
//            int index = 0;
//            while (!queue.isEmpty()) retval[index++] = queue.poll();
//            index = retval.length - 1;
//            while (!stack.isEmpty()) retval[index--] = stack.pop();
//            return retval;

            // Solution 2: Directly operating on the list
//            List<Integer> res = new ArrayList<>();
//            for (int asteroid : asteroids) res.add(asteroid);
//            for (int i = 0, j = 0; j < res.size();) {
//                int asteroid = res.get(j);
//                if (asteroid < 0) {
//                    asteroid = Math.abs(asteroid);
//                    boolean exists = true;
//                    while (i < j && exists) {
//                        if (res.get(j - 1) >= asteroid) exists = false;
//                        if (res.get(j - 1) <= asteroid) res.remove(j-- - 1);
//                    }
//                    if (exists) res.add(i++, res.remove(j++));
//                    else res.remove(j);
//                } else j++;
//            }
//            return res.stream().mapToInt(Integer::valueOf).toArray();

            // Solution 3: LinkedList Version 1
//            LinkedList<Integer> q = new LinkedList<>();
//            for (int i : asteroids) {
//                if (i > 0) q.add(i);
//                else {
//                    boolean exists = true;
//                    while (!q.isEmpty() && q.peekLast() > 0 && exists) {
//                        if (q.peekLast() >= -i) exists = false;
//                        if (q.peekLast() <= -i) q.pollLast();
//                    }
//                    if (exists) q.add(i);
//                }
//            }
//            int retval[] = new int[q.size()];
//            for (int i = 0; i < retval.length; i++) retval[i] = q.pollFirst();
//            return retval;

            // Solution 4: LinkedList Version 2
            LinkedList<Integer> q = new LinkedList<>();
            for (int i : asteroids) {
                if (i > 0) q.add(i);
                else {
                    while (!q.isEmpty() && q.getLast() > 0 && q.peekLast() < -i)
                        q.pollLast();
                    if (q.isEmpty() || q.getLast() < 0) q.add(i);
                    else if (q.getLast() == -i) q.pollLast();
                }
            }
            int retval[] = new int[q.size()];
            for (int i = 0; i < retval.length; i++) retval[i] = q.pollFirst();
            return retval;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{5, 10, -5})));
        System.out.println("Expected: [5, 10]\n");
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{8, -8})));
        System.out.println("Expected: []\n");
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{10, 2, -5})));
        System.out.println("Expected: [10]\n");
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println("Expected: [-2, -1, 1, 2]\n");
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{-2, 2, -1, -2})));
        System.out.println("Expected: [-2]\n");
    }
}
