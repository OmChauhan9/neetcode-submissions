// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;

//         int buy = 1;
//         int[][] t = new int[n+1][2];
//         for(int[] t1 : t) Arrays.fill(t1,-1);

//         return solve(prices,0,n,buy,t);
//     }

//     public int solve(int[] prices, int day, int n, int buy, int[][] t){
//         if(day >= n) return 0;
//         if(t[day][buy] != -1) return t[day][buy];

//         int profit = -1;
//         if(buy == 1){
//             int take = solve(prices, day+1, n, 0,t) - prices[day];
//             int not_take = solve(prices,day+1,n,1,t);

//             profit = Math.max(profit, Math.max(take, not_take)); 
//         }else{
//             int sell = prices[day] + solve(prices, day+2, n, 1,t);
//             int not_sell = solve(prices, day+1, n, 0,t);

//             profit = Math.max(profit, Math.max(sell, not_sell));
//         }

//         return t[day][buy] = profit;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;

        int[] t = new int[n];
        t[0] = 0;
        t[1] = Math.max(prices[1] - prices[0],0);

        for(int i=2; i<n; i++){
            t[i] = t[i-1];
            for(int j=0; j<i; j++){
                int prev_profit = j >= 2 ? t[j-2] : 0;
                int profit = prices[i] - prices[j];

                t[i] = Math.max(t[i], profit + prev_profit);
            }
        }

        return t[n-1];
    }
}