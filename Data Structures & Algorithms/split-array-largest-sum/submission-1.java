class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        if(k > n) return -1;

        int low = 0, high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(largestSumForK(mid, nums) <= k){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int largestSumForK(int maxSum, int[] nums){
        int total = 0;
        int split = 0;

        for(int num : nums){
            total += num;
            if(total > maxSum){
                total = num;
                split++;
            }
        }

        return split + 1;
    }
}