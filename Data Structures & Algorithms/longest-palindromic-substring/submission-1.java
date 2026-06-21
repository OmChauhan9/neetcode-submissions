class Solution {
    public String longestPalindrome(String s) {
        String b = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] t = new int[n+1][n+1];
        int maxL = 0;
        int index = 0;

        for(int i = 1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    if(i - t[i][j] == n - j){
                        if(t[i][j] > maxL){
                            maxL = t[i][j];
                            index = i;
                        }
                    }
                }else{
                    t[i][j] = 0;
                }
            }
        }

        // StringBuilder p = new StringBuilder();
        // System.out.println("index :: " + index);
        // while(maxL > 0){
        //     if(s.charAt(index-1) == b.charAt(index-1)){
        //         p.append(s.charAt(index-1));
        //         maxL--;
        //     }
        //     index--;
        // }

        // return p.reverse().toString();
        return s.substring(index - maxL, index);
    }
}
