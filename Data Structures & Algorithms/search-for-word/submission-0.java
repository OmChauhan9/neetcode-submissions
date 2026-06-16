class Solution {

    private int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(dfs(0, r, c, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int index, int r, int c, String word, char[][]board){
        if(index == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(index) || board[r][c] == '#'){
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(index + 1 , r + 1, c , word, board) || dfs(index + 1 , r - 1, c , word, board) || dfs(index + 1, r, c - 1 , word, board) || 
                        dfs(index + 1 , r, c + 1 , word, board);
                    
        board[r][c] = word.charAt(index);
        return res;
    }
}

