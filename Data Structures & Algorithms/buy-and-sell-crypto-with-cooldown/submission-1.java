class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int buy = 1;
        int[][] t = new int[n+1][2];
        for(int[] t1 : t) Arrays.fill(t1,-1);

        return solve(prices,0,n,buy,t);
    }

    public int solve(int[] prices, int day, int n, int buy, int[][] t){
        if(day >= n) return 0;
        if(t[day][buy] != -1) return t[day][buy];

        int profit = -1;
        if(buy == 1){
            int take = solve(prices, day+1, n, 0,t) - prices[day];
            int not_take = solve(prices,day+1,n,1,t);

            profit = Math.max(profit, Math.max(take, not_take)); 
        }else{
            int sell = prices[day] + solve(prices, day+2, n, 1,t);
            int not_sell = solve(prices, day+1, n, 0,t);

            profit = Math.max(profit, Math.max(sell, not_sell));
        }

        return t[day][buy] = profit;
    }
}
