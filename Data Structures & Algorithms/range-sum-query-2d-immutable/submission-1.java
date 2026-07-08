class NumMatrix {

    // sumMatrix[i][j] stores the sum of the rectangle
    // from (0,0) to (i-1,j-1) in the original matrix.
    //
    // We make the matrix one row and one column larger so that
    // the first row and first column are all 0.
    // This avoids boundary checks while answering queries.

    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0]. length;

        // Extra row and column filled with 0.
        prefix = new int[m+1][n+1];

        // Build the 2D Prefix Sum Matrix.
        for(int i=0; i<m; i++){

            // Running sum of the current row.
            // Instead of recalculating the row sum again and again,
            // we keep adding the next element.
            //
            // Example:
            // Row = [3,0,1,4]
            //
            // prefix becomes:
            // 3 -> 3 -> 4 -> 8
            //
            // This makes construction O(rows * cols).

            int prefix_cnt = 0;
            for(int j=0; j<n; j++){

                // Current row prefix till column j.
                prefix_cnt = prefix_cnt + matrix[i][j];

                // Sum of everything above the current cell.
                //
                // Since sumMatrix already contains prefix sums
                // of previous rows, we simply reuse it.
                int above = prefix[i][j + 1];

                // Current rectangle sum
                //
                // prefix = current row contribution
                // above  = contribution of previous rows
                //
                // Their sum gives the total rectangle
                // from (0,0) to (i,j).
                prefix[i + 1][j + 1] = prefix_cnt + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Shift every coordinate by 1 because sumMatrix
        // has one extra row and column.
        row1 += 1; col1 += 1; row2 += 1; col2 += 1;

        int bottomRight = prefix[row2][col2];
        int above = prefix[row1 - 1][col2];
        int left = prefix[row2][col1 - 1];
        int topLeft = prefix[row1 - 1][col1 - 1];

        // Inclusion-Exclusion Principle
        //
        // Wanted Rectangle =
        // Whole Rectangle
        // - Top Area
        // - Left Area
        // + Top-Left Overlap

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */