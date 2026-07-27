class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        HashSet<Character>[] row = new HashSet[n];
        HashSet<Character>[] col = new HashSet[n];
        HashSet<Character>[] box = new HashSet[n];

        for(int i=0; i<n; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                char val = board[r][c];

                if(val == '.') continue;

                if(row[r].contains(board[r][c])) return false;
                row[r].add(board[r][c]);

                if(col[c].contains(board[r][c])) return false;
                col[c].add(board[r][c]);

                int boxN = (r/3)*3 + c/3;
                if(box[boxN].contains(board[r][c])) return false;
                box[boxN].add(board[r][c]);
            }
        }

        return true;
    }
}
