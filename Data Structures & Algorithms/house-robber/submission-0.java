class Solution {
    public int rob(int[] nums) {
        return Math.max(rMon(nums,0),rMon(nums,1));
    }

    public int rMon(int[] nums, int n){
        if(n >= nums.length) return 0;
        return nums[n] + rMon(nums,n+2);
    }
}