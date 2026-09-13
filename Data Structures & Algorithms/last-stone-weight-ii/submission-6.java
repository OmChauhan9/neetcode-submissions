class Solution {
    int[][] t;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int totalSum = 0;
        for(int num : stones) totalSum += num;

        t = new int[n + 1][totalSum/2 + 1];
        for(int[] t1 : t) Arrays.fill(t1, - 1);

        return totalSum - 2 * solve(stones, n, totalSum/2);
    }

    private int solve(int[] stones, int n, int target){
        if(target == 0 || n == 0) return 0;

        if(t[n][target] != -1) return t[n][target];

        if(stones[n - 1] <= target){
            return t[n][target] = Math.max(stones[n - 1] + solve(stones, n - 1, target - stones[n-1]), solve(stones, n -1, target));
        }

        return t[n][target] = solve(stones, n - 1, target);
    }
}