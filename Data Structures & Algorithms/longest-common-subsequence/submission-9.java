class Solution {
    private int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        t = new int[n + 1][m + 1];
        for(int[] t1 : t) Arrays.fill(t1, -1);

        return solve(text1, text2, n, m);
    }

    private int solve(String text1, String text2, int n, int m){
        if(n == 0 || m == 0) return 0;

        if(t[n][m] != -1) return t[n][m];

        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return t[n][m] = 1 + solve(text1, text2, n - 1, m -1);
        }

        return t[n][m] = Math.max(solve(text1, text2, n-1, m), solve(text1, text2, n, m-1));
    }
}
