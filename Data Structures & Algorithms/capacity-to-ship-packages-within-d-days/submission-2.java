class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(capacity(mid, weights) <= days){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int capacity(int total, int[] weights){
        int n = weights.length;

        int daysTaken = 0;
        int tweights = 0;

        for(int i=0; i<n ; i++){
            tweights += weights[i];
            if(tweights > total){
                daysTaken++;
                tweights = weights[i];
            }
        }

        return daysTaken + 1;
    }
}