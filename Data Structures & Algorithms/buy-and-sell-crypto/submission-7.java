class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int profit = 0;
        int l = 0, r = 0;

        int max = Integer.MIN_VALUE;

        while(r < n){
            if(prices[l] > prices[r]){
                l = r;
            }
            profit = prices[r] - prices[l];
            max = Math.max(max , profit);
            r++;
        }

        return max;

    }
}
