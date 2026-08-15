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
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            if(!pq.isEmpty() && pq.peek() <= intervals.get(i).start){
                pq.poll();
            }

            pq.add(intervals.get(i).end);
        }

        return pq.size();
    }
}
