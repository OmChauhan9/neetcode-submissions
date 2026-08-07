class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int c=0; c<m; c++){
            if(board[0][c] == 'O'){
                dfs(0, c, board, n, m);
            }

            if(board[n-1][c] == 'O'){
                dfs(n-1, c, board, n, m);
            }
        }

        for(int r=0; r<n; r++){
            if(board[r][0] == 'O'){
                dfs(r, 0, board, n, m);
            }

            if(board[r][m-1] == 'O'){
                dfs(r, m-1, board, n, m);
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

    public void dfs(int row, int col, char[][] board, int n, int m){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] == 'X' || board[row][col] == '#'){
            return;
        }

        board[row][col] = '#';

        dfs(row + 1, col, board, n, m);
        dfs(row - 1, col, board, n, m);
        dfs(row, col + 1, board, n, m);
        dfs(row, col - 1, board, n, m);

        return;
    }
}
