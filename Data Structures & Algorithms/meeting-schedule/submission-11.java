/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i=1; i<n; i++){
            Interval current = intervals.get(i);
            Interval previous = intervals.get(i-1);

            if(current.start < previous.end) return false;
        }

        return true;
    }
}
