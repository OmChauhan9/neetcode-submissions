class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] t = new int[n+1][amount+1];
        for(int[] t1 : t) Arrays.fill(t1, -1);

        return coin(coins, amount, n, t);
    }

    public int coin(int[] nums, int target, int n, int[][] t){
        if(n==0 && target == 0) return 1;
        if(n==0 && target > 0) return 0;

        if(t[n][target] != -1) return t[n][target];

        if(nums[n-1] <= target){
            return t[n][target] = coin(nums, target - nums[n-1], n, t) + coin(nums, target, n-1, t);
        }
        return t[n][target] = coin(nums, target, n-1, t);
    }
}
