class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = 0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(limit(mid, weights) <= days){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int limit(int capacity, int[] weights){
        int n = weights.length;
        int totals = 0;
        int tDay = 0;

        for(int i=0; i<n; i++){
            totals += weights[i];
            if(totals > capacity){
                tDay++;
                totals = weights[i];
            }
        }

        return tDay + 1; 
    }
}