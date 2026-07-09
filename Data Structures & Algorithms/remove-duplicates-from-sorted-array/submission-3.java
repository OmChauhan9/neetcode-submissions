class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int i = 0;
        int index = 0;

        while(i < n){
            if(i > 0 && nums[i] == nums[i-1]){
                i++;
            }else{
                nums[index++] = nums[i];
                i++;
            }
        }

        return index;
    }
}