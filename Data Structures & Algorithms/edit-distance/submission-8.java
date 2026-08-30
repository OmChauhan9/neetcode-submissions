class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] t = new int[n + 1][m + 1];
        for(int[] t1 : t) Arrays.fill(t1, -1);
        return solve(word1, word2, t, n, m);
    }

    private int solve(String word1, String word2, int[][] t, int n, int m){
        if(n == 0) return m;
        if(m == 0) return n;

        if(t[n][m] != -1) return t[n][m];

        if(word1.charAt(n - 1) == word2.charAt(m - 1)){
            return t[n][m] = solve(word1, word2, t, n-1, m-1);
        }

        return t[n][m] = 1 + Math.min(solve(word1, word2, t, n-1, m-1), Math.min(solve(word1, word2, t, n, m-1), solve(word1, word2, t, n-1, m)));
    }
}
