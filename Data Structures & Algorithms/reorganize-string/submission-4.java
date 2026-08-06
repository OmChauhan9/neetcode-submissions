class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] freq = new int[26];

        int maxFreqCnt = 0;
        Character maxFreq = ' ';

        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a']++;

            if(freq[s.charAt(i) - 'a'] > maxFreqCnt){
                maxFreqCnt = freq[s.charAt(i) - 'a'];
                maxFreq = s.charAt(i);
            }

            if(maxFreqCnt > (n + 1)/2) return "";
        }

        char[] res = new char[n];
        int index = 0;
        while(freq[maxFreq - 'a'] > 0){
            res[index] = maxFreq;
            index += 2;
            freq[maxFreq - 'a']--;
        }

        for(int i=0; i<n; i++){
            while(freq[s.charAt(i) - 'a'] > 0){
                if(index >= n){
                    index = 1;
                }

                res[index] = s.charAt(i);
                index += 2;
                freq[s.charAt(i) - 'a']--;
            }
        }

        return new String(res);
    }
}