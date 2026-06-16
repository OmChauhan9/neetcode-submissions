class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = prices[0];

        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         int min = prices[j] - prices[i];
        //         profit = Math.max(profit,min);
        //     }
        // }
        for(int i=0; i<n-1; i++){
            int cost = prices[i] - min;
            profit = Math.max(profit,cost);
            min = Math.min(min,prices[i]);
        }
        return profit;
    }
}
