class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int leastWeight = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(find(mid, weights) <= days){
                leastWeight = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return leastWeight;
    }

    public int find(int target, int[] weights){
        int n = weights.length;

        int cnt = 0;
        int weight = 0;

        for(int i=0; i<n; i++){
            weight += weights[i];
            if(weight > target){
                cnt++;
                weight = weights[i];
            }
        }

        return cnt + 1;

    }
}