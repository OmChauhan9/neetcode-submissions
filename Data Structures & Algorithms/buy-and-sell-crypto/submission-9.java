class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int profit = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            min = Math.min(min, prices[i]);
            // profit = prices[i] - min;
            max = Math.max(max, prices[i] - min);
        }

        return max;

    }
}
