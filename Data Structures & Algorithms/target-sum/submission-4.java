// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;

//         int tsum = 0;
//         for(int i=0; i<n; i++){
//             tsum += nums[i];
//         }

//         if((tsum + target) % 2 != 0) return 0;

//         int sum = (target + tsum)/2;

//         int[][] t = new int[n+1][sum+1];
//         for(int[] t1 : t) Arrays.fill(t1, -1); 

//         return subSet(nums, sum, n, t);  
//     }

//     public int subSet(int[] nums, int target, int n, int[][] t){
//         if(n == 0 && target > 0) return 0;
//         if(n == 0 && target == 0) return 1;

//         if(t[n][target] != -1) return t[n][target];

//         if(nums[n-1] <= target){
//             return t[n][target] = subSet(nums, target - nums[n-1], n-1, t) + subSet(nums, target, n-1, t);
//         }

//         return t[n][target] = subSet(nums, target, n-1, t);
//     }
// }

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int tsum = 0;
        for(int i=0; i<n; i++){
            tsum += nums[i];
        }

        if((tsum + target) % 2 != 0) return 0;

        int sum = (target + tsum)/2;

        int[][] t = new int[n+1][sum+1];
        t[0][0] = 1;

        for(int i=1; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j - nums[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
