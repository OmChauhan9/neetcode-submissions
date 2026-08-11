class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] s1Array = new int[26];
        for(int i=0; i<n; i++){
            s1Array[s1.charAt(i) - 'a']++;
        }

        int[] s2Array = new int[26];
        int l=0, r=0;

        while(r < m){
            s2Array[s2.charAt(r) - 'a']++;

            if(r - l + 1 > n){
                s2Array[s2.charAt(l) - 'a']--;
                l++;
            }

            if(Arrays.equals(s1Array, s2Array)) return true;
            r++;
        }

        return false;
    }
}
