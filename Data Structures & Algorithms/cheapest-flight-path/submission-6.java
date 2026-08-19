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

        int[] stops = new int[n];
        Arrays.fill(stops,Integer.MAX_VALUE);
        stops[src] = 0;
        
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{src,0,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0];
            int cost = top[1];
            int stop = top[2];

            if(stop <= k+1 && node == dst){
                return cost;
            }

            if(stop > k) continue;

            for(int[] map : ls.get(node)){
                // int nextNode = map[0];
                // int newCost = cost + map[1]; 
                if(dist[map[0]] > cost + map[1] || stop + 1 < stops[map[0]]){
                    dist[map[0]] = map[1] + cost;
                    stops[map[0]] = stop + 1;
                    pq.add(new int[]{map[0],dist[map[0]],stop + 1});
                }
            }
        }
        return -1;
    }
}