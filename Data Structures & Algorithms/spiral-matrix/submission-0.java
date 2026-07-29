class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;

        int top = 0;
        int bottom = n - 1;

        List<Integer> ls = new ArrayList<>();

        while(top <= bottom && left <= right){
            // Moving from 00 -> 02 (First Row)
            for(int i=left; i<=right; i++){
                ls.add(matrix[top][i]);
            }
            top++;

            // Moving from 12 -> 22 (Last Column)
            for(int i=top; i<=bottom; i++){
                ls.add(matrix[i][right]);
            }
            right--;

            // Moving from 21 -> 20 (Last Row)
            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    ls.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Moving from 02 -> 01 (First column)
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    ls.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ls;
    }
}
