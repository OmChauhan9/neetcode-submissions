class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int curIndex = 0;

        for(int i=0; i<n; i++){
            if(i > curIndex) return false;
            curIndex = Math.max(curIndex, i + nums[i]);
            if(curIndex >= n - 1) return true;
        }

        return true;
    }
}
