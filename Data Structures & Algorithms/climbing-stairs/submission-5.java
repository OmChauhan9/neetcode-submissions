class Solution {
    public int climbStairs(int n) {
        if(n==0) return 1;
        if(n < 0) return 0;
        int cost = 0;
        for(int i=1; i<=2; i++){
            cost += climbStairs(n-i);
        }
        return cost;
    }
}
