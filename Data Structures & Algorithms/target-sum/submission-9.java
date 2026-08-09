class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for(int num : nums){
            total += num;
        }

        if(Math.abs(target) > total || (total + target) % 2 != 0 || (total + target) < 0) return 0;

        if((total + target) % 2 != 0) return 0;
        int sum = (total + target) / 2;

        int[][] t = new int[n + 1][sum + 1];
        for(int[] t1 : t) Arrays.fill(t1, -1);

        return solve(nums, sum, n, t);
    }

    public int solve(int[] nums, int sum, int n, int[][] t){
        if(n == 0 && sum > 0) return 0;
        if(n == 0 && sum == 0) return 1;

        if(t[n][sum] != -1) return t[n][sum];

        if(nums[n - 1] <= sum){
            return t[n][sum] = solve(nums, sum - nums[n-1], n-1, t) + solve(nums, sum, n-1, t);
        }

        return t[n][sum] = solve(nums, sum, n-1, t);
    }
}
