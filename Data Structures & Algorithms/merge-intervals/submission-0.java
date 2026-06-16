class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // int m = intervals[0].length;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ls = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(ls.isEmpty() || intervals[i][0] > ls.get(ls.size()-1)[1]){
                ls.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                ls.get(ls.size()-1)[1] = Math.max(ls.get(ls.size()-1)[1],intervals[i][1]);
            }
            // int start = intervals[i][0];
            // int end = intervals[i][1];
            // if(!ls.isEmpty() && start < ls.get(ls.size()-1)[1]){
            //     continue;
            // }
            // System.out.println("ls ::: " + ls);
            // for(int j = i+1; j<n; j++){
            //     if(intervals[j][0] <= end){
            //         end = Math.max(end,intervals[j][1]);
            //     }else{
            //         break;
            //     }
            // }

            // ls.add(new int[]{start,end});
        }
        return ls.toArray(new int[ls.size()][]);
    }
}
