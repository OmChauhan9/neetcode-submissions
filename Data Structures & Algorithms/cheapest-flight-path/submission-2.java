class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            ls.get(u).add(new int[]{v,w});
        }

        // int[] dist = new int[n];
        // Arrays.fill(dist,Integer.MAX_VALUE);
        // dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{src,0,0});

        int[] stops = new int[n];
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int cost = top[1];
            int stop = top[2];

            if(stop <= k+1 && node == dst){
                return cost;
            }

            for(int[] map : ls.get(node)){
                // if(dist[map[0]] > dist[node] + map[1] && stops[dst] <= k){
                //     dist[map[0]] = dist[node] + map[1];
                //     pq.add(new int[]{map[0],dist[map[0]],stop + 1});
                //     stops[map[0]]++;
                // }
                int ncost = map[1] + cost;
                stops[map[0]]++;
                // System.out.println("Stop :: " + Arrays.toString(stops));
                // System.out.println("cost :: " + map[1]);
                // System.out.println()
                pq.add(new int[]{map[0],ncost,stop + 1});
            }
        }
        return -1;
    }
}
