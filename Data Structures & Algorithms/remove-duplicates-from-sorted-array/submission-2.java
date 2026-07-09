class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        while(j < n){
            nums[i] = nums[j];
            while(j < n && nums[j] == nums[i]){
                j++;
            }
            i++;
        }

        return i;
    }
}