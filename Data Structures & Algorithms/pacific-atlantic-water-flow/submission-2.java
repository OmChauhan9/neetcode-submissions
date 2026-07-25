class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int c=0; c<m; c++){
            dfs(heights, 0, c, 0, pacific);
            dfs(heights, n-1, c, 0, atlantic);
        }

        for(int r=0; r<n; r++){
            dfs(heights, r, 0, 0, pacific);
            dfs(heights, r, m-1, 0, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] nums, int row, int col, int prev, boolean[][] visited){
        if(row < 0 || col < 0 || row >= nums.length || col >= nums[0].length || visited[row][col] == true || nums[row][col] < prev){
            return;
        }

        visited[row][col] = true;
        prev = nums[row][col];

        dfs(nums, row + 1, col, prev, visited);
        dfs(nums, row - 1, col, prev, visited);
        dfs(nums, row, col + 1, prev, visited);
        dfs(nums, row, col - 1, prev, visited);

        return;
    }
}
