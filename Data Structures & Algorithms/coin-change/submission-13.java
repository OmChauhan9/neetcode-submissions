class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(n == 1){
            if(amount % coins[0] == 0) return amount / coins[0];
            else return -1;
        }

        int[][] t = new int[n + 1][amount + 1];
        for(int[] t1 : t){
            Arrays.fill(t1, -1);
        }

        int result = solve(coins, amount, n, t);

        return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }

    public int solve(int[] coins, int amount, int n, int[][] t){
        if(amount == 0) return 0;
        if(n == 0 && amount > 0) return Integer.MAX_VALUE - 1;

        if(t[n][amount] != -1) return t[n][amount];

        if(coins[n - 1] <= amount){
            return t[n][amount] = Math.min(1 + solve(coins, amount - coins[n - 1], n, t), solve(coins, amount, n - 1, t));
        }

        return t[n][amount] = solve(coins, amount, n - 1, t);
    }
}
