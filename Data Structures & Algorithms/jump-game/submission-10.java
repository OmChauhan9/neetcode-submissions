class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int index = 0;
        for(int i=0; i<n; i++){
            if(index < i) return false;
            index = Math.max(index, i + nums[i]);
        }

        return true;
    }
}
