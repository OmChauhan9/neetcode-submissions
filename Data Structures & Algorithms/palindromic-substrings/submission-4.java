class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int resCnt = 0;

        for(int i=0; i<n; i++){
            
            // Odd Length
            int l = i;
            int r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                resCnt++;
                l--;
                r++;
            } 

            //Even Length
            l = i;
            r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                resCnt++;
                l--;
                r++;
            }
        }

        return resCnt;
    }
}
