class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] s1Count = new int[26];
        for(int i=0; i<n; i++){
            s1Count[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        int[] s2Count = new int[26];

        while(r < m){
            s2Count[s2.charAt(r) - 'a']++;
            if((r - l + 1) > n){
                s2Count[s2.charAt(l) - 'a']--;
                l++;
            }

            if(Arrays.equals(s1Count, s2Count)) return true;
            r++;
        }

        return false;
    }
}
