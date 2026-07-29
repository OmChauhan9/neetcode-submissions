class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int c=0; c<m; c++){
            dfs(0, c, heights, n, m, pacific, 0);
            dfs(n-1, c, heights, n, m, atlantic, 0);
        }

        for(int r=0; r<n; r++){
            dfs(r, 0, heights, n, m, pacific, 0);
            dfs(r, m-1, heights, n, m, atlantic, 0);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    ans.add(Arrays.asList(r ,c));
                }
            }
        }

        return ans;
    }

    public void dfs(int row, int col, int[][] heights, int n, int m, boolean[][] vis, int prev){
        if(row < 0 || col < 0 || row >= n || col >= m || heights[row][col] < prev || vis[row][col] == true){
            return;
        }

        vis[row][col] = true;
        prev = heights[row][col];

        dfs(row + 1, col, heights, n, m, vis, prev);
        dfs(row - 1, col, heights, n, m, vis, prev);
        dfs(row, col + 1, heights, n, m, vis, prev);
        dfs(row, col - 1, heights, n, m, vis, prev);

        return;
    }
}
