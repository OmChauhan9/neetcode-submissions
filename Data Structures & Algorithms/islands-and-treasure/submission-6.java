class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r, c});
                }
            }
        }

        int[] nrow = {1, 0, -1, 0};
        int[] ncol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];

            for(int i=0; i<4; i++){
                int nRow = nrow[i] + row;
                int nCol = ncol[i] + col;

                if(nRow >=0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == 2147483647){
                    grid[nRow][nCol] = 1 + grid[row][col];
                    q.add(new int[]{nRow, nCol});
                }
            }
        }
    }

}
