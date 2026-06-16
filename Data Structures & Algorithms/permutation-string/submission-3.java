class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2){
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // 1. Create maps for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = n1-1;

        while(r<n2-1){
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }

            s2Map[s2.charAt(l + s1.length()) - 'a']++;
            s2Map[s2.charAt(l) - 'a']--;

            l++;
            r++;
        }

        return Arrays.equals(s1Map, s2Map);

    //     int[] cnt = new int[26];
    //     for(int i = 0; i<n1; i++){
    //         cnt[s1.charAt(i) - 'a']++;
    //     }

    //     int l =0;
    //     int r =n1-1;

    //     while(r<n2){
    //         if(checkedArray(cnt,s2,l,r) == true){
    //             return true;
    //         }
    //         l++;
    //         r++;
    //     }
    //     return false;
    // }

    // private boolean checkedArray(int[] cnt, String s2, int start, int end){
    //     int[] cnt1 = new int[26];
    //     for(int i = start; i<=end; i++){
    //         cnt1[s2.charAt(i) - 'a']++;
    //     }

    //     if(Arrays.equals(cnt1,cnt)){
    //         return true;
    //     }
    //     return false;
    // }
    }
}
