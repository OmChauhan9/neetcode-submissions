class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String s = strs[i];
            // System.out.println(s);

            char[] sArray = s.toCharArray();
            // System.out.println(sArray);
            int[] count = new int[26];
            for(int j = 0; j<sArray.length; j++){
                count[sArray[j] - 'a']++;
            }
            String c = Arrays.toString(count);
            // System.out.println(c);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(s);
            // System.out.println(map);
        }
        return new ArrayList<>(map.values());
    }
}
