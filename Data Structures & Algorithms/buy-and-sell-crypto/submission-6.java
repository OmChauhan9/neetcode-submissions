class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int profit = 0;
        int l = 0, r = 1;

        int max = 0;

        while(r < n){
            while(prices[l] > prices[r]){
                l++;
                // r++;
            }
            profit = prices[r] - prices[l];
            max = Math.max(max , profit);
            r++;
        }

        return max;

    }
}
