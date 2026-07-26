// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] t0 = new int[n+1];
//         Arrays.fill(t0,-1);

//         int[] t1 = new int[n+1];
//         Arrays.fill(t1, -1);

//         if(n == 1) return nums[0];
//         if(n == 2) return Math.max(nums[0], nums[1]);

//         return Math.max(chor(nums, 0, n - 1, t0), Math.max(chor(nums, 1, n, t1), chor(nums, 2, n, t1)));
//     }

//     public int chor(int[] nums, int index, int n, int[] t){
//         if(index >= n) return 0;
//         if(t[index] != -1) return t[index];

//         return t[index] = nums[index] + Math.max(chor(nums, index + 2, n, t), chor(nums, index + 3, n, t));
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] t0 = new int[n+1];
        int[] t1 = new int[n+1];

        t0[0] = nums[0];
        t0[2] = nums[0] + nums[2];

        t1[1] = nums[1];
        t1[2] = nums[2];

        for(int i=3; i<n-1; i++){
            t0[i] = Math.max(t0[i-2], t0[i-3]) + nums[i];
        }

        for(int i=3; i<n; i++){
            t1[i] = Math.max(t1[i-2], t1[i-3]) + nums[i];
        }

        return Math.max(Math.max(t0[n-2], t0[n-3]), Math.max(t1[n-1], t1[n-2]));


    }
}
