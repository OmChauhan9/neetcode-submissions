class Solution {
    public String stoneGameIII(int[] stoneValue) {
        // if(stoneValue.length <= 3) return "Alice";
        int[] t = new int[stoneValue.length + 1];
        t[stoneValue.length] = solve(stoneValue,0,t);

        if(t[stoneValue.length] > 0) return "Alice";
        else if(t[stoneValue.length] == 0) return "Tie";
        else return "Bob";
    }

    public int solve(int[] stone, int i, int[] t){
        if(i >= stone.length) return 0;
        if(t[i] != 0) return t[i];

        int result = Integer.MIN_VALUE;

        result = Math.max(result,stone[i] - solve(stone,i+1,t));
        if(i + 1 < stone.length) result = Math.max(result, stone[i] + stone[i+1] - solve(stone, i+2,t));
        if(i + 2 < stone.length) result = Math.max(result, stone[i] + stone[i+1] + stone[i+2] - solve(stone, i+3,t));

        return t[i] = result;

    }
}