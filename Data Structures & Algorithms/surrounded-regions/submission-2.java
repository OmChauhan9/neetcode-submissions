class Solution {
    public void solve(char[][] board) {
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;

        for(int c = 0; c < m; c++){

            if(board[0][c] == 'O'){
                dfs(0, c, board, delrow, delcol);
            }

            if(board[n-1][c] == 'O'){
                dfs(n-1, c, board, delrow, delcol);
            }
        }

        for(int r = 0; r<n; r++){
            if(board[r][0] == 'O'){
                dfs(r, 0, board, delrow, delcol);
            }

            if(board[r][m-1] == 'O'){
                dfs(r, m-1, board, delrow, delcol);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){ 
                    board[i][j] = 'O';
                }
            }
        }

        }


    public void dfs(int r, int c, char[][] board, int[] delrow, int[] delcol){

        if(r<0 || r>= board.length || c<0 || c>= board[0].length || board[r][c] == 'X' || board[r][c] == '#'){
            return;
        }

        board[r][c] = '#';

        for(int i = 0; i<4; i++){
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];
            dfs(nrow,ncol,board,delrow,delcol);
        }
    }
}

