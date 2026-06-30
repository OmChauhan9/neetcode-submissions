class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = nums[0];
        int max = nums[0];
        int min = nums[0];
        int s1 = nums[0];
        int s2 = nums[0];

        for(int i=1; i<n; i++){
            s1 = Math.max(s1 + nums[i], nums[i]);
            max = Math.max(s1 , max);

            s2 = Math.min(s2 + nums[i], nums[i]);
            min = Math.min(s2, min);

            total += nums[i];
        }

        return max > 0 ? Math.max(max, total - min) : max;

    }
}