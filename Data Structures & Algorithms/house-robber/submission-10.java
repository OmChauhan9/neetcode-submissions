class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] t = new int[n];
        Arrays.fill(t, -1);
        
        return Math.max(solve(nums, 0, n, t), solve(nums, 1, n, t));
    }

    public int solve(int[] nums, int i, int n, int[] t){
        if(i >= n) return 0;
        if(t[i] != -1) return t[i];

        return t[i] = nums[i] + Math.max(solve(nums, i + 2, n, t), solve(nums , i + 3, n, t));
    }
}
