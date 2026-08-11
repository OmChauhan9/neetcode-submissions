class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        int l=0, r=0;
        int longest = 0;
        int maxFreq = 0;

        while(r < n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(s.charAt(r)));
            
            if((r - l + 1) - maxFreq > k){
                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
