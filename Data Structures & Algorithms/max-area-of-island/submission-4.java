class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 1){
                    int area = dfs(r, c, grid, n, m);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int row, int col, int[][] grid, int n, int m){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;
        int currentArea = 1;

        currentArea += dfs(row + 1, col, grid, n, m);
        currentArea += dfs(row - 1, col, grid, n, m);
        currentArea += dfs(row, col + 1, grid, n, m);
        currentArea += dfs(row, col - 1, grid, n, m);

        return currentArea;

    }
}
