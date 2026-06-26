// class Solution {
//     public int numSquares(int n) {
//         int[] t = new int[n+1];
//         Arrays.fill(t,-1);
//         return solve(n,t);
//     }

//     public int solve(int n, int[] t){
//         if(n==0) return 0;
//         if(t[n] != -1) return t[n];

//         int min = Integer.MAX_VALUE;
//         for(int i=1;i*i<=n;i++){
//             min = Math.min(min,1 + solve(n - (i*i),t));
//         }

//         return t[n] = min;
//     }
// }

class Solution {
    public int numSquares(int n) {
        int[] t = new int[n+1];

        for(int i=1; i<=n; i++){
            t[i] = i;
            for(int j=1; j*j<=i; j++){
                if((j*j) <= i){
                    t[i] = Math.min(1 + t[i - (j*j)],t[i]);
                }
            }
        }
        return t[n];
    }

    // public int solve(int n, int[] t){
    //     if(n==0) return 0;
    //     if(t[n] != -1) return t[n];

    //     int min = Integer.MAX_VALUE;
    //     for(int i=1;i*i<=n;i++){
    //         min = Math.min(min,1 + solve(n - (i*i),t));
    //     }

    //     return t[n] = min;
    // }
}