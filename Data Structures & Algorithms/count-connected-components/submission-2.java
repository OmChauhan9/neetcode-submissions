class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i<n; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] it : edges){
            int u = it[0];
            int v = it[1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        // System.out.println("ls ::: " + ls);

        int cnt = 0;
        int[] vis = new int[n];
        for(int i = 0; i<n; i++){
            if(vis[i] != 1){
                cnt++;
                dfs(i,vis,ls);
            }
        }
        return cnt;
    }

    public void dfs(int i, int[] vis, List<List<Integer>> ls){
        if(vis[i] == 1){
            return;
        }
        vis[i] = 1;
        for(int it : ls.get(i)){
            if(vis[it] == 0){
                dfs(it,vis,ls);
            }
        }
    }
}
