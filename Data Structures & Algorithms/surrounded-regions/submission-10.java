class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int c=0; c<m; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }

            if(board[n-1][c] == 'O'){
                dfs(board, n-1, c);
            }
        }

        for(int r=0; r<n; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }

            if(board[r][m-1] == 'O'){
                dfs(board, r, m-1);
            }
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(board[r][c] == '#'){
                    board[r][c] = 'O';
                }else if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] b, int row, int col){
        if(row < 0 || col < 0 || row >= b.length || col >= b[0].length || b[row][col] == 'X' || b[row][col] == '#'){
            return;
        }

        b[row][col] = '#';

        dfs(b, row + 1, col);
        dfs(b, row - 1, col);
        dfs(b, row, col + 1);
        dfs(b, row, col - 1);

        return;
    }
}
