package problems.meetingRooms_920;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// link : https://www.lintcode.com/problem/920/
public class Solution {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i+1).start) {
                return false;
            }
        }
        return true;
    }
}
