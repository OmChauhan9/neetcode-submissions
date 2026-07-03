class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;

        List<int[]> ls = new ArrayList<>();

        while(i<n && intervals[i][1] < newInterval[0]){
            ls.add(new int[]{intervals[i][0], intervals[i][1]});
            i = i+1;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i = i+1;
        }
        ls.add(new int[]{newInterval[0], newInterval[1]});

        while(i<n){
            ls.add(new int[]{intervals[i][0], intervals[i][1]});
            i = i+1;
        }

        return ls.toArray(new int[ls.size()][]);
    }
}
