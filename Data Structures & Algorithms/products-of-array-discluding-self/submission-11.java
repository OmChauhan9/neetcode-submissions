class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int prefix = 1;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for(int i=n-1; i>=0; i--){
            res[i] = suffix * res[i];
            suffix *= nums[i];
        }

        return res;

        // int[] prefix = new int[n];
        // int prefix = 1;
        // for(int i=0; i<n; i++){
        //     prefix[i] = prefix;
        //     prefix = prefix * nums[i];
        // }

        // int[] suffix = new int[n];
        // int suffix = 1;
        // for(int i=n-1; i>=0; i--){
        //     suffix[i] = suffix;
        //     suffix = suffix * nums[i];
        // }

        // int[] res = new int[n];
        // for(int i=0; i<n; i++){
        //     res[i] = suffix[i] * prefix[i];
        // }

        // return res;
    }
}  
