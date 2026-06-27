class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int pile : piles) total += pile;

        int[][] t = new int[n+1][n+1];
        for(int[] t1 : t) Arrays.fill(t1,-1);

        int alice = solve(piles,0,n-1,t);
        return alice > total - alice;
    }

    public int solve(int[] piles, int left, int right, int[][] t){
        if(left > right) return 0;
        if(t[left][right] != -1) return t[left][right];

        boolean even = (right - left) % 2 == 0 ? true : false;

        int l = even ? piles[left] : 0;
        int r = even ? piles[right] : 0;

        return t[left][right] = Math.max(solve(piles,left+1,right,t) + l, solve(piles,left,right-1,t) + r);
    }
}