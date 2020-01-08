import java.util.*;

public class Q539_MinimumTimeDifference {
    static class Solution {
        // Solution 1: Convert to integer and sort
//        public int findMinDifference(List<String> timePoints) {
//            List<Integer> minutes = new ArrayList<>();
//            for (String s : timePoints)
//                minutes.add(Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3)));
//            Collections.sort(minutes);
//            int retval = Integer.MAX_VALUE;
//            for (int i = 0; i < minutes.size(); i++) {
//                int diff = Math.abs(minutes.get(i + 1 >= minutes.size() ? 0 : (i + 1)) - minutes.get(i));
//                if (diff > 12 * 60) diff = 24 * 60 - diff;
//                retval = Math.min(retval, diff);
//            }
//            return retval;
//        }

        // Solution 2: boolean array
        public int findMinDifference(List<String> timePoints) {
            boolean exists[] = new boolean[24 * 60];
            int minDiff = 0, first = 0;
            for (int i = 0; i < timePoints.size(); i++) {
                String timePoint = timePoints.get(i);
                int minute = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3));
                if (exists[minute]) return 0;
                exists[minute] = true;
                if (i == 0) first = minute;
                else if (i == 1) {
                    minDiff = Math.abs(minute - first);
                    if (minDiff > 12 * 60) minDiff = 24 * 60 - minDiff;
                } else {
                    for (int diff = 1; diff < minDiff; diff++) {
                        int lo = minute - diff, hi = minute + diff;
                        if (lo < 0) lo += 24 * 60;
                        if (hi >= 24 * 60) hi -= 24 * 60;
                        if (exists[lo] || exists[hi]) {
                            minDiff = diff;
                            break;
                        }
                    }
                }
            }
            return minDiff;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinDifference(List.of("23:59","00:00")));
        System.out.println("Expected: 1\n");

        System.out.println(new Solution().findMinDifference(List.of("12:00","00:00","06:00")));
        System.out.println("Expected: 360\n");
    }
}
