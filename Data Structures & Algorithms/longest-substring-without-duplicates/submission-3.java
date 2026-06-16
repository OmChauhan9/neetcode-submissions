class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l=0;
        int r=0;
        int longest = 0;
        // int cnt = 0;
        HashMap<Character,Integer> mp = new HashMap<>();

        while(r<n){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0) + 1);
            // System.out.println("mp ::" + mp);
            while(mp.get(s.charAt(r)) > 1){
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                // System.out.println("mp ::" + mp);
                l++;
            }
            // System.out.println("r ::" + r);
            // System.out.println("l ::" + l);
            longest = Math.max(longest,r-l+1);
            // System.out.println("longest ::" + longest);
            r++;
        }
        return longest;
    }
}
