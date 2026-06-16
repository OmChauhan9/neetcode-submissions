class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntF=0;
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[] {r,c,0});
                } else if(grid[r][c] == 1){
                    cntF++;
                }
            }
        }

        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];
            int t = pair[2];
            tm = Math.max(tm,t);
            for(int i = -1; i<=1; i++){
                for(int j = -1; j<=1; j++){
                    if(Math.abs(i) == Math.abs(j)){
                        continue;
                    }
                    int nrow = row + i;
                    int ncol = col + j;
                    if(nrow >= 0 && ncol >= 0 && ncol<m && nrow<n && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] =2;
                        q.offer(new int[] {nrow,ncol,tm+1});
                        cnt++;
                    }
                }
            }
        }

        if(cnt != cntF){
            return -1;
        }

        return tm;
    }
}
