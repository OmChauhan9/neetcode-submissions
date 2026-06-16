class Solution {
    public int findDuplicate(int[] nums) {
        // int slow = 0;
        // int fast = 0;

        // do{
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // }while(slow != fast);

        // slow = 0;
        // while(slow != fast){
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }
        // return slow;
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(st.contains(nums[i])){
                return nums[i];
            }
            st.add(nums[i]);
        }
        return -1;
    }
}
