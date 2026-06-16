class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l =0;
        int r=0;
        int longest = 0;
        HashMap<Character,Integer> mp = new HashMap<>();

        while(r<n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0) + 1);
            while(mp.size() > k){
                mp.put(s.charAt(l),mp.get(s.charAt(l)) - 1);
                if(mp.get(s.charAt(l)) == 0){
                    mp.remove(s.charAt(l));
                    l++;
                }
            }
            longest = Math.max(longest,r-l+1);
            // System.out.println("r ::: " + r);
            r++;
        }
        return longest;
    }
}
