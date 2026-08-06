class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(dfs(r, c, board, word, n, m, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, char[][] board, String word, int n, int m, int index){
        if(index == word.length()) return true;

        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] == '#' || board[row][col] != word.charAt(index)){
            return false;
        }

        board[row][col] = '#';

        boolean ans = dfs(row + 1, col, board, word, n ,m ,index + 1) ||
                      dfs(row - 1, col, board, word, n ,m ,index + 1) ||
                      dfs(row, col + 1, board, word, n ,m ,index + 1) ||
                      dfs(row, col - 1, board, word, n ,m ,index + 1);

        board[row][col] = word.charAt(index);

        return ans;
    }
}
