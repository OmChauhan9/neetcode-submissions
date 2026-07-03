class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ls = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!ls.isEmpty() && start <= ls.get(ls.size()-1)[1]) continue;

            for(int j=i+1; j<n; j++){
                if(end >= intervals[j][0]){
                    end = Math.max(end, intervals[j][1]);
                }else{
                    break;
                }
            }

            ls.add(new int[]{start,end});
        }

        return ls.toArray(new int[ls.size()][]);
    }
}

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         int n = intervals.length;
//         List<int[]> ls = new ArrayList<>();
//         ls.add(new int[]{intervals[0][0], intervals[0][1]});

//         for(int i=1; i<n; i++){
//             int end = ls.get(ls.size() - 1)[1];
//             if(end >= intervals[i][0]){
//                 end = Math.max(end, intervals[i][1]);
//             }
//             ls.add(new int[]{intervals[i][0],end});
//         }

//         return ls.toArray(new int[ls.size()][]);
//     }
// }
