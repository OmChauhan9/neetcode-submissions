class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }

        int l = 0;
        int r = 0;
        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i = 0;i<t.length(); i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }

        while(r < s.length()){
            if(mp.containsKey(s.charAt(r))){
                mp.put(s.charAt(r), mp.get(s.charAt(r)) - 1);
                if(mp.get(s.charAt(r)) >= 0){
                    count++;
                }
            }

            while(count == t.length()){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    sIndex = l;
                }

                if(mp.containsKey(s.charAt(l))){
                    mp.put(s.charAt(l), mp.get(s.charAt(l)) + 1);
                    if(mp.get(s.charAt(l)) > 0){
                        count--;
                    }
                }
                l++;
            }
            r++;     
        }
        return sIndex == -1 ? "" : s.substring(sIndex ,sIndex + minLen);

    }
        
}



