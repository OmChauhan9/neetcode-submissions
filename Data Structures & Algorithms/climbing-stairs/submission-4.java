class Solution {
    public int climbStairs(int n) {
        int cost = 0;
        return climb(n, cost);
    }

    public int climb(int n, int cost){
        if(n == 0) return ++cost;
        if(n < 0) return 0;

        for(int i=1; i<=2; i++){
            cost = Math.max(climb(n-i,cost),cost);
        }
        return cost;
    }
}
