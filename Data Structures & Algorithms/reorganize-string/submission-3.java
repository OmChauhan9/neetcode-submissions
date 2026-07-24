class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];

        int maxFreq = 0;
        char charMaxFreq = ' ';

        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a']++;
            if(freq[s.charAt(i) - 'a'] > maxFreq){
                maxFreq = freq[s.charAt(i) - 'a'];
                charMaxFreq = s.charAt(i);
            }

            if(freq[s.charAt(i) - 'a'] > (n+1)/2) return "";
        }

        char[] res = new char[n];
        int index = 0;

        while(freq[charMaxFreq - 'a'] > 0){
            res[index] = charMaxFreq;
            index += 2;
            freq[charMaxFreq - 'a']--;
        }

        for(char ch = 'a'; ch <= 'z'; ch++){
            while(freq[ch - 'a'] > 0){
                if(index >= n) index = 1;

                res[index] = ch;
                index += 2;
                freq[ch - 'a']--;
            }
        }

        return new String(res);
    }
}