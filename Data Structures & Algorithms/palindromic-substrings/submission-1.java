class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        int n = s.length();
        int count = 0;

        boolean[][] t = new boolean[n][n];

        for(int len=1; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i + len - 1;
                if(len == 1) t[i][j] = true;
                else if(len == 2) t[i][j] = (s.charAt(i) == s.charAt(j));
                else{
                    t[i][j] = (s.charAt(i) == s.charAt(j)) && t[i+1][j-1];
                }

                if(t[i][j]) count++;
            }
        }
        return count;

    }

    // public boolean isPalin(String temp , int left, int right){
    //     while(left < right){
    //         if(temp.charAt(left++) != temp.charAt(right--)) return false;
    //     }
    //     return true;
    // }
}
