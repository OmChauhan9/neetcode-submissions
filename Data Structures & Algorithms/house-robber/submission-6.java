// class Solution {
//     public int rob(int[] nums) {
//         int[] t = new int[nums.length + 1];
//         Arrays.fill(t,-1);
//         return Math.max(rMon(nums,0,t),rMon(nums,1,t));
//     }

//     public int rMon(int[] nums, int n, int[] t){
//         if(n >= nums.length) return 0;
//         if(t[n] != -1) return t[n];
//         return t[n] = nums[n] + Math.max(rMon(nums,n+2,t),rMon(nums,n+3,t));
//     }
// }

class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] t = new int[nums.length + 1];
        t[0] = nums[0];
        t[1] = nums[1];
        t[2] = nums[2] + t[0];
        for(int i=3; i<nums.length; i++){
            t[i] = nums[i] + Math.max(t[i-3],t[i-2]);
        }
        return Math.max(t[nums.length - 2],t[nums.length - 1]);
    }
}