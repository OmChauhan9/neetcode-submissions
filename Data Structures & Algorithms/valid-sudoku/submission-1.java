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

                if(row[r].contains(val)) return false;
                row[r].add(val);

                if(col[c].contains(val)) return false;
                col[c].add(val);

                int boxNO = (r/3)*3 + c/3;
                if(box[boxNO].contains(val)) return false;
                box[boxNO].add(val);
            }
        }

        return true;
    }
}
