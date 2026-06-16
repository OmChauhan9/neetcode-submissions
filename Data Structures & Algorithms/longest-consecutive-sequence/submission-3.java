class Solution {

    public boolean linearSearch(int[] nums, int target){
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        int cnt = 0;
        int x = nums[0];
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(linearSearch(nums, x) == true){
                x = x+1;
                cnt++;
            }
        }
        return cnt;
    }
}
