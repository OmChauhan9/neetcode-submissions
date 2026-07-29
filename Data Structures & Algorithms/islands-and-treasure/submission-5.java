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

        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];

            for(int i=0; i<4; i++){
                int newRow = delrow[i] + row;
                int newCol = delcol[i] + col;

                if(newRow >= 0 && newCol >= 0 && newCol < m && newRow < n && grid[newRow][newCol] == 2147483647){
                    grid[newRow][newCol] = grid[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}
