class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int low = 0;
        int high = (n*n) - 1;

        int result = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean[][] vis = new boolean[n][n];

            if(check(mid, 0, 0, grid, vis, n)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return result;
    }

    public boolean check(int time, int i, int j, int[][] grid, boolean[][] vis, int n){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] > time || vis[i][j] == true){
            return false;
        }

        if(i == n-1 && j == n-1){
            return true;
        }

        vis[i][j] = true;

        boolean res = check(time, i + 1, j, grid, vis, n) ||
                      check(time, i - 1, j, grid, vis, n) ||
                      check(time, i, j + 1, grid, vis, n) ||
                      check(time, i, j - 1, grid, vis, n);

        return res;
    }
}
