class Solution {
    public boolean bfs(int src, int[] vis, List<List<Integer>> ls){
        vis[src] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {src,-1});

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];
            for(int it : ls.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(new int[] {it,node});
                } else if(parent != it){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i<n; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[1];
            int v = e[0];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }

        int[] vis = new int[n];

        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                if(bfs(i,vis,ls)){
                    return true;
                }
            }    
        }
        return false;
    }
}
