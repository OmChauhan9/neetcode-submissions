class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n <= 1) return nums[0];
        int max = 0;
        for(int i=0; i<n; i++){
            int mul = nums[i];
            max = Math.max(max,mul);
            for(int j=i+1; j<n; j++){
                mul = mul*nums[j];
                max = Math.max(max,mul);
            }
        }
        return max;
    }
}
