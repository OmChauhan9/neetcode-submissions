class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int max = nums[0];
        int sum = nums[0];

        for(int i = 1; i<n; i++){
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max,sum);
        }

        return max;
    }
}
