class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    return dfs(i,j,grid);
                }
            }
        }
        return 0;
    }

    public int dfs(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 1;
        }

        if(grid[row][col] == 2){
            return 0;
        }

        int cnt = 0;
        grid[row][col] = 2;
        int[] delrow = {1,0,-1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0; i<4; i++){
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];
            cnt += dfs(newRow, newCol, grid);
        }

        return cnt;
    }
}