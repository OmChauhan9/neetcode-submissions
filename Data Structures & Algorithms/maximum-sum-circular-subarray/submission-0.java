class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }

        int max = nums[0];
        int s1 = nums[0];
        for(int i=1; i<n; i++){
            s1 = Math.max(s1 + nums[i], nums[i]);
            max = Math.max(s1, max);
        }

        int min = nums[0];
        int s2 = nums[0];
        for(int i=1; i<n; i++){
            s2 = Math.min(s2 + nums[i], nums[i]);
            min = Math.min(s2,min);
        }

        int cir = total - min;

        return max > 0 ? Math.max(max, cir) : max;

    }
}