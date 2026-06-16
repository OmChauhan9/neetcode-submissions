class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String s = strs[i];
            char[] sArray = s.toCharArray();
            int[] count = new int[26];
            for(int j = 0; j<sArray.length; j++){
                count[sArray[j] - 'a']++;
            }
            String c = Arrays.toString(count);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
