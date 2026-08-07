class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        int cntFresh = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 2){
                    q.add(new int[]{r, c, 0});
                }else if(grid[r][c] == 1){
                    cntFresh++;
                }
            }
        }

        if(cntFresh == 0) return 0;

        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};
        int time = 0;

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int t = top[2];

            time = Math.max(time, t);

            for(int i=0; i<4; i++){
                int nRow = delrow[i] + row;
                int nCol = delcol[i] + col;

                if(nRow >=0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = 2;
                    q.add(new int[]{nRow, nCol, t + 1});
                    cntFresh--;
                }
            }
        }

        return cntFresh > 0 ? -1 : time;
    }
}
