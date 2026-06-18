// class Solution {
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;

//         int sum = 0;
//         for(int i=0; i<n; i++){
//             sum += nums[i];
//         }

//         Boolean[][] t = new Boolean[n+1][sum/2 + 1];

//         if(sum%2 != 0) return false;
//         return subset(nums,sum/2,n, t);
//     }

//     public boolean subset(int[] nums, int sum, int n, Boolean[][] t){
//         if(n == 0 && sum > 0) return false;
//         if(sum == 0) return true;
//         if(t[n][sum] != null) return t[n][sum];

//         if(nums[n-1] <= sum){
//             return t[n][sum] = subset(nums,sum - nums[n-1], n-1,t) || subset(nums,sum,n-1,t);
//         }
//         return t[n][sum] = subset(nums,sum,n-1,t);
//     }
// }

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        boolean[][] t = new boolean[n+1][sum/2 + 1];
        for(int i=0; i<=n; i++){
            t[i][0] = true;
        }

        if(sum%2 != 0) return false;
        return subset(nums,sum/2,n, t);
    }

    public boolean subset(int[] nums, int sum, int n, boolean[][] t){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
