class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0, r = 0;
        int maxLen = 0;

        HashMap<Character, Integer> count = new HashMap<>();

        while(r < n){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            while(count.get(s.charAt(r)) == 2){
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
