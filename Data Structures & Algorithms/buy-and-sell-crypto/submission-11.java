class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int minAmount = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            minAmount = Math.min(minAmount, prices[i]);
            profit = Math.max(profit, prices[i] - minAmount);
        }

        return profit;
    }
}
