import java.util.*;

public class Q56_MergeIntervals {
    /**
     * Definition for an interval.
     */
     public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() == 0 || intervals.size() == 1) return new ArrayList<>(intervals);
            Collections.sort(intervals, (o1, o2) -> (o1.start - o2.start));
//            Collections.sort(intervals, new Comparator<Interval>(){
//                @Override
//                public int compare(Interval i1, Interval i2) {
//                    return i1.start - i2.start;
//                }
//            });

            List<Interval> retval = new ArrayList<>();
            Interval last = null;
            for (Interval curr : intervals) {
                if (retval.isEmpty() || curr.start > last.end) {
                    retval.add(curr);
                    last = curr;
                } else last.end = Math.max(last.end, curr.end);
            }
            return retval;
        }
    }

    public static List<Interval> createIntervals(String input) {
        List<Integer> list = new ArrayList<>();
        String buffer = "";
        for (char c : input.toCharArray()) {
           if (Character.isDigit(c)) {
               buffer += c;
           } else if (!buffer.isBlank()) {
               list.add(Integer.valueOf(buffer));
               buffer = "";
           }
        } // assume the end is not digit
        List<Interval> retval = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            try {
                retval.add(new Interval(list.get(i), list.get(i + 1)));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Format Error: " + input);
                return null;
            }
        }
        return retval;
    }

    public static void test(String input, String expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input: " + input);
        System.out.println("Expected Output: " + expectedOutput);
        String result = new Solution().merge(createIntervals(input)).toString();
        System.out.println("Actual Output: " + result);
        assert result.equals(expectedOutput);
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test("[[1,3],[2,4],[1,5],[2,6]]", "[[1,6]]");
        test("[[1,3],[2,6],[8,10],[15,18]]", "[[1,6], [8,10], [15,18]]");
    }
}
