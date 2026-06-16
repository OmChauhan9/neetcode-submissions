class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        // char sArray[] = s.toCharArray();
        // char tArray[] = t.toCharArray();

        // Arrays.sort(sArray);
        // Arrays.sort(tArray);

        // for(int i = 0; i<s.length(); i++){
        //     if(sArray[i] != tArray[i]){
        //         return false;
        //     }
        // }
        // return true;

        // HashMap<Character,Integer> sMap = new HashMap<>();
        // HashMap<Character,Integer> tMap = new HashMap<>();

        // for(char sM : s.toCharArray()){
        //     sMap.put(sM,sMap.getOrDefault(sM,0) + 1);
        // }

        // for(char tM : t.toCharArray()){
        //     tMap.put(tM,tMap.getOrDefault(tM,0) + 1);
        // }

        // return sMap.equals(tMap);

        int[] st = new int[26];

        for(int i = 0; i<s.length(); i++){
            st[s.charAt(i) - 'a']++;
            st[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i<st.length; i++){
            if(st[i] != 0){
                return false;
            }
        }
        return true;
    }
}
