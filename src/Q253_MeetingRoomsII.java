import java.util.*;

public class Q253_MeetingRoomsII {
    static class Solution {
        // Referring to https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
        public int minMeetingRooms(int[][] intervals) {
            int numIntervals = intervals.length;
            int[] start = new int[numIntervals];
            int[] end = new int[numIntervals];
            for (int i = 0; i < numIntervals; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }
            Arrays.sort(start);
            Arrays.sort(end);

            int numRooms = 0;
            for (int startItr = 0, endItr = 0; startItr < numIntervals; startItr++) {
                if (start[startItr] < end[endItr]) numRooms++;
                else endItr++;
            }
            return numRooms;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(new Solution().minMeetingRooms(new int[][]{{7,10},{2,4}}));
    }
}
