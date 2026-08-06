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
        Collections.sort(intervals, (a,b) -> a.start - b.start);

        int n = intervals.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            if(!pq.isEmpty() && intervals.get(i).start >= pq.peek()){
                pq.poll();
            }

            pq.add(intervals.get(i).end);
        }

        return pq.size();
    }
}
