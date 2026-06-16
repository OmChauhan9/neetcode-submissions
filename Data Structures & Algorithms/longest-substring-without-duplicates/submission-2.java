class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();

        while(r<n){
            while(set.contains(s.charAt(r))){
                System.out.println("Set :: " + set);
                set.remove(s.charAt(l));
                l++;
            }
            set.add((s.charAt(r)));
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
