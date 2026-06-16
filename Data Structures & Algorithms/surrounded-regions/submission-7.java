class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};

        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board,delrow,delcol);
            }

            if(board[i][m-1] == 'O'){
                dfs(i,m-1,board,delrow,delcol);
            }
        }

        for(int j=0; j<m; j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board,delrow,delcol);
            }

            if(board[n-1][j] == 'O'){
                dfs(n-1,j,board,delrow,delcol);
            }
        }

        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board, int[]delrow, int[]delcol){
        if(r<0 || c<0 || r>= board.length || c>= board[0].length 
        || board[r][c] == 'X' || board[r][c] == '#'){
            return;
        }

        board[r][c] = '#';

        for(int i=0; i<4; i++){
            dfs(r+delrow[i], c+delcol[i], board, delrow, delcol);
        }
    }
}
