class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l =0;
        int r=0;
        int longest = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        int maxF = 0;

        while(r<n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0) + 1);
            maxF = Math.max(maxF,mp.get(s.charAt(r)));
            System.out.println("maxF :: " + maxF);
            System.out.println("maxFrequency  :: " + (((r-l+1)) - maxF));
            if(((r-l+1)) - maxF > k){
                mp.put(s.charAt(l),mp.get(s.charAt(l)) - 1);
                // if(mp.get(s.charAt(l)) == 0){
                //     mp.remove(s.charAt(l));
                //     l++;
                // }
                l++;
            }
            longest = Math.max(longest,r-l+1);
            // System.out.println("r ::: " + r);
            r++;
        }
        return longest;
    }
}
