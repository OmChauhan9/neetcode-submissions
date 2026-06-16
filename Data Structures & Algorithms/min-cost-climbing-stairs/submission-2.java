// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int[] t = new int[cost.length +1];
//         Arrays.fill(t,-1);
//         return Math.min(min(cost,0,t),min(cost,1,t));
//     }

//     public int min(int[] cost, int i, int[] t){
//         if(i >= cost.length) return 0;
//         if(t[i] != -1) return t[i];
//         return t[i] = cost[i] + Math.min(min(cost,i+1,t),min(cost,i+2,t));
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] t = new int[cost.length +1];
        t[0] = cost[0];
        t[1] = cost[1];
        for(int i=2; i<cost.length; i++){
            t[i] = cost[i] + Math.min(t[i-1],t[i-2]);
        }
        return Math.min(t[cost.length-1],t[cost.length-2]);
    }
}
