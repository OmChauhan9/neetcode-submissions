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

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            Interval current = intervals.get(i);

            if(!q.isEmpty() && current.start >= q.peek()){
                q.poll();
            }

            q.add(current.end);

            // if(!q.isEmpty() && current.end <= q.peek()){
            //     q.poll();
            // }else{
            //     q.add(current.end);
            // }

        }

        return q.size();

    }
}
