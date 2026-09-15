class Solution {
    private int[] t;

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        t = new int[n];
        Arrays.fill(t, -1);

        return Math.max(solve(nums, 0), solve(nums, 1));
    }

    private int solve(int[] nums, int idx){
        if(idx >= nums.length) return 0;

        if(t[idx] != -1) return t[idx];

        return t[idx] = nums[idx] + Math.max(solve(nums, idx + 2), solve(nums, idx + 3));
    }
}
