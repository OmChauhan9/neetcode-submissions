class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }

        int res = 0;
        int edge = 0;
        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int v = top[0];
            int w = top[1];

            if(vis[v] == true) continue;

            res += w;
            vis[v] = true;
            edge++;

            if(edge == n) break;

            for(int[] map : adj.get(v)){
                if(vis[map[0]] == false){
                    pq.add(new int[]{map[0], map[1]});
                }
            }
        }

        return res;
    }
}
