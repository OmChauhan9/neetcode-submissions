class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] t = new int[n+1][m+1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }
        return common(text1,text2,n,m,t);
    }

    public int common(String text1, String text2, int n, int m, int[][] t){
        if(n == 0 || m == 0) return 0;
        if(t[n][m] != -1) return t[n][m];

        if(text1.charAt(n-1) == (text2.charAt(m-1))){
            return t[n][m] = 1 + common(text1,text2,n-1,m-1,t);
        }
        return t[n][m] = Math.max(common(text1,text2,n-1,m,t),common(text1,text2,n,m-1,t));
    }
}

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int[][] t = new int[n+1][m+1];

//         for(int i=1; i<=n; i++){
//             for(int j=1; j<=m; j++){
//                 if(text1.charAt(i-1) == text2.charAt(j-1)){
//                     t[i][j] = 1 + t[i-1][j-1];
//                 }else{
//                     t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
//                 }
//             }
//         }
//         return t[n][m];
//     }
// }