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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals, (a,b) -> Integer.compare(a.end,b.end));
        int cnt = 1;
        int ft = intervals.get(0).end;
        for(int i = 1; i<n; i++){
            if(intervals.get(i).start > ft){
                cnt++;
            }
        }
        return cnt;
    }
}
