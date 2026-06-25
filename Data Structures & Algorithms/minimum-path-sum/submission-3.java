class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] t = new int[n];

        t[0] = grid[0][0];

        for(int j=1; j<n; j++){
            t[j] = t[j-1] + grid[0][j];
        }

        for(int i=1; i<m; i++){
            t[0] = t[0] + grid[i][0];
            for(int j=1; j<n; j++){
                t[j] = grid[i][j] + Math.min(t[j],t[j-1]);
            }
        }

        return t[n-1];
    }
}