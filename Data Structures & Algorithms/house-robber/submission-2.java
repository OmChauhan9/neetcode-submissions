class Solution {
    public int rob(int[] nums) {
        int[] t = new int[nums.length + 1];
        Arrays.fill(t,-1);
        return Math.max(rMon(nums,0,t),rMon(nums,1,t));
    }

    public int rMon(int[] nums, int n, int[] t){
        if(n >= nums.length) return 0;
        if(t[n] != -1) return t[n];
        return t[n] = nums[n] + Math.max(rMon(nums,n+2,t),rMon(nums,n+3,t));
    }
}