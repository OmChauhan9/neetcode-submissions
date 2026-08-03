class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 0;
        int high = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            high = Math.max(high, piles[i]);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(total(mid, piles) <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int total(int total, int[] piles){
        int n = piles.length;
        int time = 0;

        for(int i=0; i<n; i++){
            time += Math.ceil((double) piles[i] / total);
        }

        return time;

    }
}
