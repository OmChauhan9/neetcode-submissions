class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high = 0;

        for(int i=0; i<n; i++){
            high = Math.max(high, piles[i]);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(totalHrs(mid, piles) <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int totalHrs(int k, int[] piles){
        int total = 0;
        int n = piles.length;

        for(int i=0; i<n; i++){
            total += Math.ceil((double)piles[i] / k);
        }

        return total;
    }
}
