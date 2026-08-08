class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            sum += num;
            if(sum < num){
                sum = num;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
