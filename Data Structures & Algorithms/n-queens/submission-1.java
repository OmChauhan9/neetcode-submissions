class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        int[] left = new int[n];
        int[] lowerD = new int[(2*n) - 1];
        int[] upperD = new int[(2*n) - 1];

        check(n, 0, board, left, lowerD, upperD, ans);

        return ans;
    }

    public void check(int n, int col, char[][] board, int[] left, int[] lowerD, int[] upperD, List<List<String>> ans){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }


        for(int row = 0; row < n; row++){
            if(left[row] == 0 && lowerD[row + col] == 0 && upperD[(n-1) + (col-row)] == 0){
                // PLace the Queen and mark in the hash.
                board[row][col] = 'Q';
                left[row] = 1;
                lowerD[row + col] = 1;
                upperD[(n-1) + (col-row)] = 1;

                //Call
                check(n, col + 1, board, left, lowerD, upperD, ans);

                // Remove after backtrack
                board[row][col] = '.';
                left[row] = 0;
                lowerD[row + col] = 0;
                upperD[(n-1) + (col-row)] = 0;

            }
        }
    }
}
