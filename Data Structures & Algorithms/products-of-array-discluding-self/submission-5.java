class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int prefix_cnt = 1;
        for(int i=0; i<n; i++){
            prefix_cnt = prefix_cnt * nums[i];
            prefix[i] = prefix_cnt;
        }
        // System.out.println("prefix ::: " + Arrays.toString(prefix));

        int[] suffix = new int[n];
        int suffix_cnt = 1;
        for(int i=n-1; i>=0; i--){
            suffix_cnt = suffix_cnt * nums[i];
            suffix[i] = suffix_cnt;
        }
        // System.out.println("suffix ::: " + Arrays.toString(suffix));

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            if(i-1 < 0) ans[i] = 1 * suffix[i+1];
            else if(i + 1 > n-1) ans[i] = prefix[i-1] * 1;
            else ans[i] = prefix[i-1] * suffix[i+1];
        }

        return ans;

    }
}  
