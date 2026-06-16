class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || s.length() == 0 || t.length() == 0){
            return "";
        }

        int n = s.length();
        int m = t.length();
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int l = 0, r = 0;
        int cnt = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i<m; i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0) + 1);
        }

        while(r<n){
            if(mp.containsKey(s.charAt(r))){
                mp.put(s.charAt(r),mp.get(s.charAt(r)) - 1);
                if(mp.get(s.charAt(r)) >= 0){
                    cnt++;
                }
            }

            while(cnt == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex=l;
                }

                if(mp.containsKey(s.charAt(l))){
                    mp.put(s.charAt(l),mp.get(s.charAt(l)) + 1);
                    if(mp.get(s.charAt(l)) > 0){
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex ,sIndex + minLen);

        // for(int i = 0; i<n; i++){
        //     int cnt = 0;
        //     // int[] hA = new int[256];
        //     HashMap<Character,Integer> mp = new HashMap<>();

        //     for(int j=0; j<m;j++){
        //         mp.put(t.charAt(j),mp.getOrDefault(t.charAt(j),0)+1);
        //         // hA[t.charAt(j) - 'a']++;
        //     } 

        //     for(int j=0; j<n; j++){
        //         if(mp.containsKey(s.charAt(j))){
        //             mp.put(s.charAt(j), mp.get(s.charAt(j)) - 1);
        //             if(mp.get(s.charAt(j)) >= 0){
        //                 cnt++;
        //             }
        //         }
        //         // if(hA[s.charAt(j) - 'a'] > 0){
        //         //     cnt++;
        //         // }
        //         // mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)-1);
        //         // hA[s.charAt(j) - 'a']--;

        //         if(cnt == m){
        //             if(j-i+1 < minLen){
        //                 minLen = j-i+1;
        //                 sIndex = i;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return sIndex == -1 ? "" : s.substring(sIndex ,sIndex + minLen);
    }
}
