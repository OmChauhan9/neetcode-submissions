class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] product = new int[n];
        for(int i=0; i<n; i++){
            int product_cnt = 1;
            for(int j=0; j<n; j++){
                if(j == i) continue;
                product_cnt = product_cnt * nums[j];
            }
            product[i] = product_cnt;
        }

        return product;
    }
}  
