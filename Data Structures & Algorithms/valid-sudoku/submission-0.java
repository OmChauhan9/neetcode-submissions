class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        HashSet<Character>[] row = new HashSet[N];
        HashSet<Character>[] col = new HashSet[N];
        HashSet<Character>[] box = new HashSet[N];

        for(int i = 0; i<N; i++){
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        for(int r = 0; r<N; r++){
            for(int c = 0; c<N; c++){
                char val = board[r][c];

                if(val == '.'){
                    continue;
                }


                if(row[r].contains(val)){
                    return false;
                }
                row[r].add(val);

                if(col[c].contains(val)){
                    return false;
                }
                col[c].add(val);

                int value = (r/3) * 3 + c/3;
                if(box[value].contains(val)){
                    return false;
                }
                box[value].add(val);
            }
        }
        return true;
    }
}
