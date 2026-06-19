// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] t = new int[n+1][amount+1];
//         return coin(coins,amount,n,t);
//     }

//     public int coin(int[] coins, int amount, int n, int[][] t){
//         if(n == 0 && amount == 0) return 1;
//         if(n == 0 && amount > 0) return 0;
//         if(t[n][amount] != 0) return t[n][amount];

//         if(coins[n-1] <= amount){
//             return t[n][amount] = coin(coins,amount - coins[n-1], n,t) + coin(coins, amount, n-1,t);
//         }
//         return t[n][amount] = coin(coins,amount,n-1,t);
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
