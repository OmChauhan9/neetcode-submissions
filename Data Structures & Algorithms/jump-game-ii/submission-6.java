class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int cnt = 0;

        while(r < n-1){
            int max = 0;
            for(int i=l; i<=r; i++){
                max = Math.max(max, i + nums[i]);
            }
            l = r + 1;
            r = max;
            cnt++;
        }
        return cnt;
    }    
}
