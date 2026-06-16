class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        // int[] delrow = {-1,0,1,0};
        // int[] delcol = {0,-1,0,1};
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(dfs(r,c,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, char[][] board, String word, int ind){
            if(ind == word.length()){
                return true;
            }

            if(r<0 || c<0 || r>= board.length || c>= board[0].length ||
                board[r][c] == '#' || board[r][c] != word.charAt(ind)){
                    return false;
                }

            board[r][c] = '#';
            
            // for(int i=0; i<4; i++){
            //     boolean res = dfs(r + delrow[i], c + delcol[i], board, word, delrow, delcol, ind + 1);
            // }
            boolean res = dfs(r+1,c,board,word,ind+1) ||
                            dfs(r-1,c,board,word,ind+1) ||
                            dfs(r,c+1,board,word,ind+1) ||
                            dfs(r,c-1,board,word,ind+1);

            board[r][c] = word.charAt(ind);
            return res;
        }
}
