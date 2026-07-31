// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         if(n == 1) return nums[0];
//         if(n == 2) return Math.max(nums[0], nums[1]);

//         int[] t0 = new int[n];
//         Arrays.fill(t0, -1);

//         int[] t = new int[n];
//         Arrays.fill(t, -1);

//         return Math.max(solve(nums, 0, n-1, t0), Math.max(solve(nums, 1, n, t), solve(nums, 2, n, t)));
//     }

//     public int solve(int[] nums, int i, int n, int[] t){
//         if(i >= n) return 0;

//         if(t[i] != -1) return t[i];

//         return t[i] = nums[i] + Math.max(solve(nums, i+2, n, t), solve(nums, i+3, n, t));
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] t0 = new int[n];
        t0[0] = nums[0];
        t0[1] = nums[1];
        t0[2] = nums[0] + nums[2];

        for(int i=3; i<n-1; i++){
            t0[i] = nums[i] + Math.max(t0[i-2], t0[i-3]);
        }

        int max1 = Math.max(t0[n-2], t0[n-3]);

        int[] t = new int[n];
        t[1] = nums[1];
        t[2] = nums[2];

        for(int i=3; i<n; i++){
            t[i] = nums[i] + Math.max(t[i-2], t[i-3]);
        }

        int max2 = Math.max(t[n-1], t[n-2]);

        return Math.max(max1, max2);
    }
}