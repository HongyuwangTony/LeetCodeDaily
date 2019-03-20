import java.util.LinkedList;
import java.util.List;

public class Q904_FruitIntoBaskets {
    static class Solution {
          // Give Credit to Discussion raised by lee215
          public int totalFruit(int[] tree) {
              /**
               * count_two The number of fruits in basket of size 2
               * count_one The number of fruits in basket of size 1
               * first     The first type in the basket
               * second    The second type in the basket
               */
              int count_two = 0, count_one = 0, first = -1, second = -1, max = 0;
              for (int curr : tree) {
                  count_two = (curr == first || curr == second) ? count_two + 1 : count_one + 1;
                  count_one = curr == second ? count_one + 1 : 1;
                  if (curr != second) {
                      first = second;
                      second = curr;
                  }
                  max = Math.max(max, count_two);
              }
              return max;
          }

//        LinkedList<Integer> queue;
//        int size, maxNum;
//
//        public int totalFruit(int[] tree) {
//            size = tree.length;
//            if (size == 0) return 0;
//            queue = new LinkedList<>();
//            maxNum = 0;
//            return maxFruit(tree, 0, 0);
//        }
//
//        public int maxFruit(int[] tree, int start, int transition) {
//            if (size - start <= maxNum) return maxNum;
//            int end = transition, currNum;
//            while (end < size) {
//                int currType = tree[end];
//                switch (queue.size()) {
//                    case 0:
//                        queue.addLast(currType);
//                        end++;
//                        break;
//                    case 1:
//                        if (currType != queue.peekLast()) {
//                            transition = end;
//                            queue.addLast(currType);
//                        }
//                        end++;
//                        break;
//                    default:
//                        if (currType == queue.peekLast()) end++;
//                        else if (currType != queue.removeFirst()) {
//                            currNum = end - start;
//                            if (currNum > maxNum) maxNum = currNum;
//                            return maxFruit(tree, transition, end);
//                        }
//                        else {
//                            transition = end;
//                            queue.addLast(currType);
//                            end++;
//                        }
//                }
//            }
//            currNum = end - start;
//            if (currNum > maxNum) maxNum = currNum;
//            return maxNum;
//        }
    }

    public static void test(int[] input, int expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input: ");
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Expected Output: " + expectedOutput);
        int result = new Solution().totalFruit(input);
        System.out.println("Actual Output: " + result);
        assert result == expectedOutput;
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test(new int[]{1,2,1}, 3);
        test(new int[]{0,1,2,2}, 3);
        test(new int[]{1,2,3,2,2}, 4);
        test(new int[]{3,3,3,1,2,1,1,2,3,3,4}, 5);
    }
}
