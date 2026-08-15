class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == '1'){
                    dfs(r, c, grid, n, m);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int row, int col, char[][] grid, int n, int m){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == '0') return;

        grid[row][col] = '0';

        dfs(row + 1, col, grid, n , m);
        dfs(row - 1, col, grid, n , m);
        dfs(row, col + 1, grid, n , m);
        dfs(row, col - 1, grid, n , m);
    }
}
