class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] freqCnt = new int[26];
        char maxFreqChar = ' ';
        int maxFreqCnt = 0;
        for(char c : s.toCharArray()){
            freqCnt[c - 'a']++;
            if(freqCnt[c - 'a'] > maxFreqCnt){
                maxFreqCnt = freqCnt[c - 'a'];
                maxFreqChar = c;
            }

            if(freqCnt[c - 'a'] > (n + 1)/2) return "";
        }

        char[] res = new char[n];
        int idx = 0;
        while(freqCnt[maxFreqChar - 'a'] > 0){
            res[idx] = maxFreqChar;
            idx += 2;
            freqCnt[maxFreqChar - 'a']--;
        }

        for(int i=0; i<n; i++){
            while(freqCnt[s.charAt(i) - 'a'] > 0){
                if(idx >= n) idx = 1;
                res[idx] = s.charAt(i);
                idx += 2;
                freqCnt[s.charAt(i) - 'a']--;
            }
        }

        return new String(res);
    }
}