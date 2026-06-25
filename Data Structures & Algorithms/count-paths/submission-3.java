class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                t[i][j] = Math.max(t[i-1][j] + t[i][j-1],1);
            }
        }

        return t[m][n];
    }
}
