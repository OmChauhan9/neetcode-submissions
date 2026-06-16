class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxEle(piles);
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high)/2;
            int totalhrs = thr(piles,mid);

            if(totalhrs <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int maxEle(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public int thr(int[] piles, int mid){
        int totaH = 0;
        for(int i = 0; i<piles.length; i++){
            totaH = totaH + (int)Math.ceil((double)piles[i]/mid);
        }
        return totaH;
    }
}
