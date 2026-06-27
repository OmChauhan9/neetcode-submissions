class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] t = new int[2][n+1][n+1];  
        return solve(piles,1,0,1,t);
    }

    public int solve(int[] piles, int person, int idx, int M, int[][][] t){
        if(idx >= piles.length) return 0;
        if(t[person][idx][M] != 0) return t[person][idx][M];

        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for(int i=1; i<= Math.min(2*M,piles.length - idx); i++){
            if(person == 1){
                stones += piles[i + idx - 1];
                result = Math.max(result, stones + solve(piles,0,i + idx,Math.max(i,M),t));
            }else{
                result = Math.min(result, solve(piles,1,i + idx, Math.max(i,M),t));
            }
        }
        return t[person][idx][M] = result;
    }
}