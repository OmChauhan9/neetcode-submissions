// class Solution {
//     public int rob(int[] nums) {
//         int[] t0 = new int[nums.length+1];
//         Arrays.fill(t0,-1);
//         int[] t1 = new int[nums.length+1];
//         Arrays.fill(t1,-1);

//         if(nums.length == 1) return nums[0];
//         if(nums.length <= 3) return nums.length == 2 ? Math.max(nums[0],nums[1]) : Math.max(nums[2],Math.max(nums[0],nums[1]));
        
//         return Math.max(rMon(nums,0,0,t0),Math.max(rMon(nums,1,1,t1),rMon(nums,2,1,t1)));
//     }

//     public int rMon(int[] nums , int n, int index, int[] t){
//         if(index == 0 && nums.length - 1 == n) return 0;
//         if(n >= nums.length) return 0;
//         if(t[n] != -1) return t[n];
//         return t[n] = nums[n] + Math.max(rMon(nums,n+2,index,t),rMon(nums,n+3,index,t));
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int[] t0 = new int[nums.length+1];
        int[] t1 = new int[nums.length+1];
        if(nums.length == 1) return nums[0];
        if(nums.length <= 3) return nums.length == 2 ? Math.max(nums[0],nums[1]) : Math.max(nums[2],Math.max(nums[0],nums[1]));

        t0[0] = nums[0];
        t0[1] = t1[1] = nums[1];
        t1[2] = nums[2];
        t0[2] = nums[2] + nums[0];

        for(int i=3; i<nums.length-1; i++){
            t0[i] = nums[i] + Math.max(t0[i-2],t0[i-3]);
        }

        for(int i=3; i<nums.length; i++){
            t1[i] = nums[i] + Math.max(t1[i-2],t1[i-3]);
        }

        return Math.max(Math.max(t0[nums.length-2],t0[nums.length-3]), Math.max(t1[nums.length-1],t1[nums.length-2]));
    }
}