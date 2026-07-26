class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t0 = new int[n+1];
        Arrays.fill(t0,-1);

        int[] t1 = new int[n+1];
        Arrays.fill(t1, -1);

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(chor(nums, 0, n - 1, t0), Math.max(chor(nums, 1, n, t1), chor(nums, 2, n, t1)));
    }

    public int chor(int[] nums, int index, int n, int[] t){
        if(index >= n) return 0;
        if(t[index] != -1) return t[index];

        return t[index] = nums[index] + Math.max(chor(nums, index + 2, n, t), chor(nums, index + 3, n, t));
    }
}
