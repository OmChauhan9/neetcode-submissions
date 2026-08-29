class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int pre= 1;
        int[] prefix = new int[n];
        for(int i=0; i<n; i++){
            prefix[i] = pre;
            pre= pre * nums[i];
        }

        int suf = 1;
        int[] suffix = new int[n];
        for(int i=n-1; i>=0; i--){
            suffix[i] = suf;
            suf = suf * nums[i];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
}  
