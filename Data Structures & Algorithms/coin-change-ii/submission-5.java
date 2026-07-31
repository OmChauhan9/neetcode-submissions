// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;

//         int[][] t = new int[n+1][amount+1];
//         for(int[] t1 : t) Arrays.fill(t1, -1);

//         return coin(coins, amount, n, t);
//     }

//     public int coin(int[] nums, int target, int n, int[][] t){
//         if(n==0 && target == 0) return 1;
//         if(n==0 && target > 0) return 0;

//         if(t[n][target] != -1) return t[n][target];

//         if(nums[n-1] <= target){
//             return t[n][target] = coin(nums, target - nums[n-1], n, t) + coin(nums, target, n-1, t);
//         }
//         return t[n][target] = coin(nums, target, n-1, t);
//     }
// }

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] t = new int[n+1][amount+1];
        for(int i=0; i<=n; i++){
            t[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1] <= j){
                    t[i][j] = t[i][j - coins[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][amount];
    }
}
