class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];

        for(int c=0; c<m; c++){
            dfs(0, c, heights, p, n, m, 0);
            dfs(n-1, c, heights, a, n, m, 0);
        }

        for(int r=0; r<n; r++){
            dfs(r, 0, heights, p, n, m,0);
            dfs(r, m-1, heights, a, n, m, 0);
        }

        List<List<Integer>> ls = new ArrayList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(p[r][c] && a[r][c]){
                    ls.add(Arrays.asList(r ,c));
                }
            }
        }

        return ls;
    }

    public void dfs(int row, int col, int[][] nums, boolean[][] vis, int n, int m, int prev){
        if(row < 0 || col < 0 || row >= n || col >= m || nums[row][col] < prev || vis[row][col] == true){
            return;
        }

        vis[row][col] = true;
        prev = nums[row][col];

        dfs(row + 1, col, nums, vis, n, m, prev);
        dfs(row - 1, col, nums, vis, n, m, prev);
        dfs(row, col + 1, nums, vis, n, m, prev);
        dfs(row, col - 1, nums, vis, n, m, prev);

        return;
    }
}
