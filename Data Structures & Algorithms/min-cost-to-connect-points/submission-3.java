class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        pq.add(new int[]{0,0});

        boolean[] vis = new boolean[n];

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int w = top[1];

            if(vis[node]) continue;

            vis[node] = true;
            cost += w;
            
            for(int i=0; i<n; i++){
                if(!vis[i]){
                    int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                    pq.add(new int[]{i,dist});
                }
            }
        }

        return cost;
        
    }
}
