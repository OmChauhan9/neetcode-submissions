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
            while(!pq.isEmpty() && pq.peek() <= intervals.get(i).start){
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
            // System.out.println("pq ::::: " + pq);
            // System.out.println("cnt ::::: " + cnt);
            // cnt = Math.max(pq.size(),cnt);
        }
        return pq.size();
    }
}


// Sort by start time.
// Collections.sort(intervals, (a,b) -> Integer.compare(a.start,b.start));
// We’ll process meetings in the order they begin.

// Use a min-heap of end times.
// PriorityQueue<Integer> pq = new PriorityQueue<>();
// The heap holds the end times of meetings currently occupying rooms. The smallest end time is on top (the room that frees up earliest).

// For each meeting (in start order):

// Free finished rooms:
// while (!pq.isEmpty() && pq.peek() <= current.start) pq.poll();
// If the earliest finishing meeting ends at or before the next meeting’s start, that room is reusable (note the <= matches the “(0,8) and (8,10) don’t conflict” rule).

// Allocate current meeting:
// pq.offer(current.end);
// Either we re-used a freed room (heap size stays same) or we needed a new room (heap size grows).

// Track the maximum rooms ever needed:
// cnt = Math.max(cnt, pq.size());

// Return cnt as the minimum number of rooms required (the peak number of overlapping meetings).
