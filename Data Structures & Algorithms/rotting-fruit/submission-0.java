class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int[][] vis = new int[n][m];
        int cntF = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                if(grid[r][c] == 2){                                //vis[r][c] == 0 && 
                    q.add(new int[] {r,c,0});
                }
                if(grid[r][c] == 1){
                    cntF++;
                }
            }
        }

        int tm = 0;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        int count = 0;

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];
            int t = pair[2];
            tm = Math.max(tm, t);

            for(int i = 0; i<4; i++){
                int nrow = row + dRow[i];
                int ncol = col + dCol[i]; 
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol< grid[0].length &&  grid[nrow][ncol] == 1){               //vis[nrow][ncol] == 0 &&
                    q.add(new int[] {nrow, ncol, t + 1});
                    grid[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if(count != cntF){
            return -1;
        }

        return tm;
    }
}
