class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String s = strs[i];
            char[] sArray = new char[26];

            for(char c : s.toCharArray()){
                sArray[c - 'a']++;
            }

            String ans = String.valueOf(sArray);
            if(!mp.containsKey(ans)){
                mp.put(ans, new ArrayList<>());
            }
            mp.get(ans).add(s);
            
        }
 
        List<List<String>> valueList = new ArrayList<>(mp.values());
        return valueList;
    }
}
