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


        int[] delcol = {0, 1, 0, -1};
        int[] delrow = {1, 0, -1, 0};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];

            for(int i=0; i<4; i++){
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 2147483647){
                    grid[newRow][newCol] = 1 + grid[row][col];
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        return;
    }
}
