class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        // int low = Integer.MAX_VALUE;
        int low = 0;
        int high = Integer.MIN_VALUE;

        for(int pile : piles){
            // low = Math.min(low, pile);
            high = Math.max(high, pile);
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(total(mid, piles) <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private int total(int mid, int[] piles){
        int n = piles.length;

        int totaltime = 0;
        for(int pile : piles){
            totaltime += Math.ceil((double)pile / mid);
        }

        return totaltime;
    }
}
