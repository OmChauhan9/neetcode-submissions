class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(dfs(board, word, r, c, n, m, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int n, int m, int index){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] == '#' || board[row][col] != word.charAt(index)){
            return false;
        }

        board[row][col] = '#';

        boolean check = dfs(board, word, row + 1, col, n, m, index + 1) ||
                        dfs(board, word, row, col + 1, n, m, index + 1) ||
                        dfs(board, word, row - 1, col, n, m, index + 1) ||
                        dfs(board, word, row, col - 1, n, m, index + 1);

        board[row][col] = word.charAt(index);

        return check;
    }
}
