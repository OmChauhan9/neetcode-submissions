class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l = 0, r = 0;
        int longest = 0;
        int maxFreq = 0;

        HashMap<Character, Integer> count = new HashMap<>();

        while(r < n){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(count.get(s.charAt(r)), maxFreq);

            if((r - l + 1) - maxFreq > k){
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
