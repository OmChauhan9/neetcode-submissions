class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] t = new int[n + 1];
        Arrays.fill(t , -1);

        return Math.max(dfs(nums, 0, t), dfs(nums, 1, t));
    }

    public int dfs(int[] nums, int index, int[] t){
        if(index >= nums.length) return 0;
        if(t[index] != -1) return t[index];

        return t[index] = nums[index] + Math.max(dfs(nums, index + 2, t), dfs(nums, index + 3, t));
    }
}
