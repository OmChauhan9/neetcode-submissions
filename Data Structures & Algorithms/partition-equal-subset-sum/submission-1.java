class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        // boolean[][] t = new boolean[n+1][sum/2 + 1];

        if(sum%2 != 0) return false;
        return subset(nums,sum/2,n);
    }

    public boolean subset(int[] nums, int sum, int n){
        if(n == 0 && sum > 0) return false;
        if(sum == 0) return true;

        if(nums[n-1] <= sum){
            return subset(nums,sum - nums[n-1], n-1) || subset(nums,sum,n-1);
        }
        return subset(nums,sum,n-1);
    }
}
