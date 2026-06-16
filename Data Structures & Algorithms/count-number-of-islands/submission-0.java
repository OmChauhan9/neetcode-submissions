class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                if(vis[r][c] == 0 && grid[r][c] == '1'){
                    bfs(r,c,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int r, int c, int[][] vis, char[][] grid){
        vis[r][c] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];
            // int tm = pair[2];
            // int t = 0;
            // int t = Math.max(t , tm);
            for(int i = -1; i<=1; i++){
                for(int j = -1; j<=1; j++){
                    if(Math.abs(i) == Math.abs(j)){
                        continue;
                    }

                    int newRow = row + i;
                    int newCol = col + j;

                    if(newRow>=0 && newRow < grid.length && newCol>=0 && newCol < grid[0].length && grid[newRow][newCol] == '1' && vis[newRow][newCol] == 0 ){
                        vis[newRow][newCol] = 1;
                        q.add(new int[] {newRow,newCol});
                    }
                }
            }
        }
    }
}
