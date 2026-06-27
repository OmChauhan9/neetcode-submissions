class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int range = 0;
        for(int i=0; i<n; i++){
            range += stones[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=range/2; i++){
            if(solve(stones,i,n)){
                ans = Math.min(ans, range - 2*i);
            }
        }

        return ans;
    }

    public boolean solve(int[] stones, int i, int n){
        if(i == 0) return true;
        if(n == 0 && i > 0) return false;

        if(stones[n-1] <= i){
            return solve(stones,i - stones[n-1], n-1) || solve(stones, i, n-1);
        }

        return solve(stones,i,n-1);
    }
}