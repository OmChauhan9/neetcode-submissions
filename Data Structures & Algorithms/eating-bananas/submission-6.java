class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 0;
        int high = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            high = Math.max(piles[i], high);
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

    public int total(int count, int[] piles){
        int n = piles.length;
        int totalTime = 0;

        for(int i=0; i<n; i++){
            totalTime += Math.ceil((double)piles[i] / count);
        }

        return totalTime;
    }
}
