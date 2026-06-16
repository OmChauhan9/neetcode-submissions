class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};
        for(int r = 0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 1){
                    cnt = Math.max(dfs(r,c,grid,delrow,delcol), cnt);
                }
            }
        }
        return cnt;
    }

    public int dfs(int r, int c, int[][] grid, int[] delrow, int[] delcol){
        if(r<0 || c<0 || r>= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;

        int cnt = 1;
        for(int i = 0; i<4; i++){
            cnt += dfs(r + delrow[i], c + delcol[i], grid, delrow, delcol);
        }

        return cnt;
    }


}
