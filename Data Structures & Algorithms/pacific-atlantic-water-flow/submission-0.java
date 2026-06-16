class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i = 0; i<n; i++){
            dfs(i,0,pacific,heights,delrow,delcol);
            dfs(i,m-1,atlantic,heights,delrow,delcol);
        }

        for(int i=0; i<m; i++){
            dfs(0,i,pacific,heights,delrow,delcol);
            dfs(n-1,i,atlantic,heights,delrow,delcol);
        }

        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ls.add(Arrays.asList(i,j));
                }
            }
        }

        return ls;
    }

    public void dfs(int r, int c, boolean[][] ocean, int[][] heights,
        int[] delrow, int[] delcol){
        
        if(ocean[r][c]) return;
        ocean[r][c] = true;

        for(int i = 0; i<4; i++){
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];

            if(nrow < 0 || ncol < 0 || ncol >= heights[0].length || nrow >= heights.length){
                continue;
            }

            if(!ocean[nrow][ncol] && heights[nrow][ncol] >= heights[r][c]){
                dfs(r + delrow[i],c + delcol[i],ocean,heights,delrow,delcol);
            }
        }
    }
}
