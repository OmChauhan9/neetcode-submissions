class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ls = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        // int cnt = 0;

        for(int i=0; i<n; i++){
            if(ls.isEmpty() || ls.get(ls.size() - 1)[1] <= intervals[i][0]){
                ls.add(intervals[i]);
            }
        }

        return n - ls.size();
    }
}
