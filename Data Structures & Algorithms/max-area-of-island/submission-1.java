class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 1){
                    int cnt = dfs(r, c, grid, n, m);
                    max = Math.max(max, cnt);
                }
            }
        }

        return max;
    }

    public int dfs(int row, int col, int[][] grid, int n, int m){
        if(row >= n || col >= m || row < 0 || col < 0 || grid[row][col] == 0){
            return 0;
        } 

        grid[row][col] = 0;

        int area = 1;
        area += dfs(row + 1, col, grid, n, m);
        area += dfs(row - 1, col, grid, n, m);
        area += dfs(row, col + 1, grid, n, m);
        area += dfs(row, col - 1, grid, n, m);

        return area;
    }
}
