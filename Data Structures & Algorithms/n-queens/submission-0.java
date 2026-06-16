class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int[] left = new int[n];
        int[] lowerDL = new int[2*n-1];
        int[] upperDL = new int[2*n-1];
        queeN(0, board, res, left, lowerDL,upperDL);
        return res;
    }

    public void queeN(int col, char[][] board, List<List<String>> res, int[] left, int[] lowerDL, int[] upperDL){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int i = 0; i<board.length; i++){
            if(left[i] == 0 && lowerDL[i + col] == 0 && upperDL[board.length - 1 + col - i] == 0){
                board[i][col] = 'Q';
                left[i] = 1;
                lowerDL[i + col] = 1;
                upperDL[board.length - 1 + col - i] = 1;
                queeN(col + 1, board, res, left, lowerDL, upperDL);
                board[i][col] = '.';
                left[i] = 0;
                lowerDL[i + col] = 0;
                upperDL[board.length - 1 + col - i] = 0;
            }
        }
    }

    public List<String> construct(char[][] board){
        List<String> ls = new ArrayList<>();
        for(int i =0; i<board.length; i++){
            String s = new String(board[i]);
            ls.add(s);
        }
        return ls;
    }
}
