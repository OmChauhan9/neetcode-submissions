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
        for(int i = 0; i<n-1; i++){
            int ft = intervals.get(i).end;
            if(intervals.get(i+1).start > ft){
                cnt++;
            }
        }
        return cnt;
    }
}
