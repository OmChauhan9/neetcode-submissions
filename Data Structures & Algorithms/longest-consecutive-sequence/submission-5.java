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
        int longest = 1;
        int n = nums.length;

        for(int i=0; i<n; i++){
            int cnt = 1;
            int x = nums[i];
            while(linearSearch(nums, x+1) == true){
                x = x+1;
                cnt++;
            }
            longest = Math.max(longest,cnt);
        }
        return longest;
    }
}
