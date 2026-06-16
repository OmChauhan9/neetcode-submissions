class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                if(vis[r][c] != 1 && grid[r][c] == '1'){
                    bfs(r,c,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void bfs(int r, int c, int[][] vis, char[][] grid){
        vis[r][c] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];
            
            for(int i = -1; i<= 1; i++){
                for(int j = -1; j<= 1; j++){
                    if(Math.abs(i) == Math.abs(j)){
                        continue;
                    }
                    int nrow = row + i;
                    int ncol = col + j;
                    if(ncol >= 0 && ncol < grid[0].length 
                    && nrow >= 0 && nrow < grid.length && vis[nrow][ncol] != 1 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.add(new int[] {nrow, ncol});
                    }
                }
            }
        }
    }
}
