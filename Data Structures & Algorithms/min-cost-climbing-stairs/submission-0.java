class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(min(cost,0),min(cost,1));
    }

    public int min(int[] cost, int i){
        if(i >= cost.length) return 0;
        return cost[i] + Math.min(min(cost,i+1),min(cost,i+2));
    }
}
