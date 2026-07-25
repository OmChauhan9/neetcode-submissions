class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int cntFresh = 0;

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 2){
                    q.add(new int[]{r, c, 0});
                }else if(grid[r][c] == 1){
                    cntFresh++;
                }
            }
        }

        // if(cntFresh == 0) return -1;

        int[] delcol = {0, 1, 0, -1};
        int[] delrow = {1, 0, -1, 0};
        int total = 0;

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];
            int time = top[2];
            total = Math.max(total, time);

            for(int i=0; i<4; i++){
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    q.add(new int[]{newRow, newCol, time + 1});
                    cntFresh--;
                }
            }
        }

        return cntFresh > 0 ? -1 : total;
    }
}
