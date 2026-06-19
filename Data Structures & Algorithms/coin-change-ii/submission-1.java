class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];
        return coin(coins,amount,n,t);
    }

    public int coin(int[] coins, int amount, int n, int[][] t){
        if(n == 0 && amount == 0) return 1;
        if(n == 0 && amount > 0) return 0;
        if(t[n][amount] != 0) return t[n][amount];

        if(coins[n-1] <= amount){
            return t[n][amount] = coin(coins,amount - coins[n-1], n,t) + coin(coins, amount, n-1,t);
        }
        return t[n][amount] = coin(coins,amount,n-1,t);
    }
}
