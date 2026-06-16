class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int n = s.length();
        int m = t.length();

        for(int i = 0; i<n; i++){
            int[] hash = new int[256];
            HashMap<Character,Integer> mp = new HashMap<>();

            for(int j=0; j<m; j++){
                hash[t.charAt(j)]++;
            }

            int cnt = 0;
            for(int j=0; j<n; j++){
                if(hash[s.charAt(j)] > 0){
                    cnt++;
                }
                hash[s.charAt(j)]--;

                if(cnt == m){
                    if(j-i+1 < minLen){
                        minLen = j-i+1;
                        sIndex = i;
                        break;
                    }
                }
            }
        }
        return s.substring(sIndex,minLen);
    }
}
