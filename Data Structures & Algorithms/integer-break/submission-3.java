// class Solution {
//     public int integerBreak(int n) {
//         int[] t = new int[n+1];
//         return solve(n,t);
//     }

//     public int solve(int n, int[] t){
//         if(n==1) return 1;
//         if(t[n] != 0) return t[n];

//         int res = 0;
//         for(int i=1; i<n; i++){
//             res = Math.max(res, i * Math.max(n-i,solve(n-i,t)));
//         }

//         return t[n] = res;
//     }
// }

class Solution {
    public int integerBreak(int n) {
        int[] t = new int[n+1];

        for(int i=2; i<=n; i++){
            t[i] = 0;
            for(int j=1; j<i; j++){
                t[i] = Math.max(t[i], j * Math.max(i-j,t[i-j]));
            }
        }
        return t[n];
    }
}