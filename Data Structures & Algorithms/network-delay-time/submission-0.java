class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            ls.get(u).add(new int[]{v,t});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});
        int cost = 0;

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int w = top[1];

            if(dist[node] < w) continue;

            for(int[] map : ls.get(node)){
                if(dist[map[0]] > dist[node] + map[1]){
                    dist[map[0]] = dist[node] + map[1];
                    pq.add(new int[]{map[0], dist[map[0]]});
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            cost = Math.max(dist[i],cost);
        }
        return cost;
    }
}
