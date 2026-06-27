// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         int range = 0;
//         for(int i=0; i<n; i++){
//             range += stones[i];
//         }

//         Boolean[][] t = new Boolean[n+1][range/2 + 1];

//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<=range/2; i++){
//             if(solve(stones,i,n,t)){
//                 ans = Math.min(ans, range - 2*i);
//             }
//         }

//         return ans;
//     }

//     public boolean solve(int[] stones, int i, int n, Boolean[][] t){
//         if(i == 0) return true;
//         if(n == 0 && i > 0) return false;

//         if(t[n][i] != null) return t[n][i];

//         if(stones[n-1] <= i){
//             return solve(stones,i - stones[n-1], n-1,t) || solve(stones, i, n-1,t);
//         }

//         return solve(stones,i,n-1,t);
//     }
// }

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int range = 0;
        for(int i=0; i<n; i++){
            range += stones[i];
        }

        boolean[][] t = new boolean[n+1][range/2 + 1];
        for(int i=0; i<=n; i++){
            t[i][0] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=range/2; j++){
                if(stones[i-1] <= j){
                    t[i][j] = t[i-1][j - stones[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=range/2; i++){
            if(t[n][i]){
                ans = Math.min(ans, range - 2*i);
            }
        }

        return ans;
    }

    // public boolean solve(int[] stones, int i, int n, Boolean[][] t){
    //     if(i == 0) return true;
    //     if(n == 0 && i > 0) return false;

    //     if(t[n][i] != null) return t[n][i];

    //     if(stones[n-1] <= i){
    //         return solve(stones,i - stones[n-1], n-1,t) || solve(stones, i, n-1,t);
    //     }

    //     return solve(stones,i,n-1,t);
    // }
}