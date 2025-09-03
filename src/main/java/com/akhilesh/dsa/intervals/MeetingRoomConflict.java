package com.akhilesh.dsa.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomConflict {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals)); // Output: false
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // Sort the meetings by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            // If the start time of the current meeting is less than the end time of the previous one, there is a conflict
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}