class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int r = 0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }

        int[] delrow = {1,0,-1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            for(int i=0; i<4; i++){
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 2147483647){
                    grid[newRow][newCol] = grid[row][col] + 1;
                    q.add(new int[]{newRow,newCol});
                }
            }
        }

        return;
    }
}
