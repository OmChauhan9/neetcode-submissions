class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] t = new int[n+1][m+1];
        for(int[] t1 : t) Arrays.fill(t1,-1);
        return solve(word1,word2,n,m,t);
    }

    public int solve(String w1, String w2, int n, int m, int[][] t){
        if(n == 0) return m;
        if(m == 0) return n;
        if(t[n][m] != -1) return t[n][m];

        if(w1.charAt(n-1) == w2.charAt(m-1)){
            return t[n][m] = solve(w1,w2,n-1,m-1,t);
        }

        return t[n][m] = 1 + Math.min(solve(w1,w2,n-1,m-1,t), Math.min(solve(w1,w2,n-1,m,t), solve(w1,w2,n,m-1,t)));
    }
}
