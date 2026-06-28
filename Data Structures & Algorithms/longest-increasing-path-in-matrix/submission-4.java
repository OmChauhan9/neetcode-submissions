class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] t = new int[m+1][n+1];

        int max = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int res = solve(matrix,i,j,-1,t);
                max = Math.max(max,res);
            }
        }

        return max;
    }

    public int solve(int[][] matrix, int row, int col, int prev, int[][] t){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= prev){
            return 0;
        }

        if(t[row][col] != 0) return t[row][col];

        int res = 0;
        res = Math.max(res, 1 + solve(matrix,row-1,col,matrix[row][col],t));
        res = Math.max(res, 1 + solve(matrix,row,col+1,matrix[row][col],t));
        res = Math.max(res, 1 + solve(matrix,row+1,col,matrix[row][col],t));
        res = Math.max(res, 1 + solve(matrix,row,col-1,matrix[row][col],t));

        return t[row][col] = res;
    }
}
