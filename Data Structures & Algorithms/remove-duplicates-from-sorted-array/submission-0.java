class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        HashSet<Integer> st = new HashSet<>();

        int index=0;
        for(int i=0; i<n; i++){
            if(!st.contains(nums[i])){
                st.add(nums[i]);
                nums[index++] = nums[i];
            }
        }

        return st.size();
    }
}