class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int cnt = 0;
        
        for(int i=0; i<n; i++){
            int ans = 0;
            for(int j=i; j<n; j++){
                ans += nums[j];
                if(ans == k) cnt++;
            }
        }

        return cnt;

    }
}