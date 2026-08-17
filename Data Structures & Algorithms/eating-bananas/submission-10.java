class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 0;
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            high = Math.max(pile, high);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(find(piles, mid) <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int find(int[] piles, int target){
        int n = piles.length;
        int totalTime = 0;
        for(int pile : piles){
            totalTime +=  Math.ceil((double) pile / target);
        }

        return totalTime;
    }
}
