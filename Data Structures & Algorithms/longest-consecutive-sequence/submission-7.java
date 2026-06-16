class Solution {

    // public boolean linearSearch(int[] nums, int target){
    //     int n = nums.length;
    //     for(int i = 0; i<n; i++){
    //         if(nums[i] == target){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // int longest = 1;
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     int cnt = 1;
        //     int x = nums[i];
        //     while(linearSearch(nums, x+1) == true){
        //         x = x+1;
        //         cnt++;
        //     }
        //     longest = Math.max(longest,cnt);
        // }
        // return longest;
        // Arrays.sort(nums);
        // int longest = 1;
        // int cnt = 0;
        // int min = Integer.MIN_VALUE;

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] - 1 == min){
        //         min = nums[i];
        //         cnt++;
        //     } else if(nums[i] != min){
        //         cnt = 1;
        //         min = nums[i];
        //     }
        //     longest = Math.max(longest,cnt);
        // }
        // return longest;
        int longest = 1;
        HashSet<Integer> st = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            if(!st.contains(nums[i] - 1)){
                int cnt = 1;
                while(st.contains(nums[i] + 1)){
                    nums[i]++;
                    cnt++;
                }
                longest = Math.max(longest,cnt);
            } 
        }
        return longest;
    }
}
