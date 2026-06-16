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
        if (intervals.isEmpty()) {
            return 0; 
        }
        int n = intervals.size();
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start,b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for(int i = 0; i<n; i++){
            while(!pq.isEmpty() && pq.peek() >= intervals.get(i).start){
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
            System.out.println("pq ::::: " + pq);
            System.out.println("cnt ::::: " + cnt);
            cnt = Math.max(pq.size(),cnt);
        }
        // int cnt = 1;
        // int ft = intervals.get(0).end;
        // for(int i = 1; i<n; i++){
        //     if(intervals.get(i).start > ft){
        //         cnt++; 
        //     }
        //     ft = intervals.get(i).end;
        // }
        // // int ans = 
        return cnt;
    }
}
