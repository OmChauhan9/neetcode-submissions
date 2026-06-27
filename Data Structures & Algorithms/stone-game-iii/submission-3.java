// class Solution {
//     public String stoneGameIII(int[] stoneValue) {
//         int[] t = new int[stoneValue.length + 1];
//         t[stoneValue.length] = solve(stoneValue,0,t);

//         if(t[stoneValue.length] > 0) return "Alice";
//         else if(t[stoneValue.length] == 0) return "Tie";
//         else return "Bob";
//     }

//     public int solve(int[] stone, int i, int[] t){
//         if(i >= stone.length) return 0;
//         if(t[i] != 0) return t[i];

//         int result = Integer.MIN_VALUE;

//         result = Math.max(result,stone[i] - solve(stone,i+1,t));
//         if(i + 1 < stone.length) result = Math.max(result, stone[i] + stone[i+1] - solve(stone, i+2,t));
//         if(i + 2 < stone.length) result = Math.max(result, stone[i] + stone[i+1] + stone[i+2] - solve(stone, i+3,t));

//         return t[i] = result;

//     }
// }

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] t = new int[stoneValue.length+1];

        for(int i=n-1; i>=0; i--){
            t[i] = stoneValue[i] - t[i+1];
            if(i+1 < n) t[i] = Math.max(t[i],stoneValue[i] + stoneValue[i+1] - t[i+2]);
            if(i+2 < n) t[i] = Math.max(t[i],stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - t[i+3]);
        }

        if(t[0] > 0) return "Alice";
        else if(t[0] == 0) return "Tie";
        else return "Bob";
    }

    // public int solve(int[] stone, int i, int[] t){
    //     if(i >= stone.length) return 0;
    //     if(t[i] != 0) return t[i];

    //     int result = Integer.MIN_VALUE;

    //     result = Math.max(result,stone[i] - solve(stone,i+1,t));
    //     if(i + 1 < stone.length) result = Math.max(result, stone[i] + stone[i+1] - solve(stone, i+2,t));
    //     if(i + 2 < stone.length) result = Math.max(result, stone[i] + stone[i+1] + stone[i+2] - solve(stone, i+3,t));

    //     return t[i] = result;

    // }
}