class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] t = new int[n];

        t[0] = nums[0];
        t[1] = nums[1];
        t[2] = nums[0] + nums[2];

        for(int i=3; i<n; i++){
            t[i] = nums[i] + Math.max(t[i-2], t[i-3]);
        }

        return Math.max(t[n-1], t[n-2]);
    }
}
