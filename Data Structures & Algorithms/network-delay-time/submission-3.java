class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new int[]{v, t});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int dest = top[0];
            int t_take = top[1];

            if(t_take > dist[dest]) continue;
            
            for(int[] map : adj.get(dest)){
                if(dist[dest] != Integer.MAX_VALUE && dist[map[0]] > dist[dest] + map[1]){
                    dist[map[0]] = dist[dest] + map[1];
                    pq.add(new int[]{map[0], dist[map[0]]});
                }
            }
        }

        int total = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            total = Math.max(total, dist[i]);
        }

        return total;
    }
}
