class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> group = new HashMap<>();

        for(int i = 0; i<n; i++){
            String str = strs[i];

            int[] count = new int[26];
            for(int j=0; j<str.length(); j++){
                count[str.charAt(j) - 'a']++;
            }

            String key = Arrays.toString(count);

            group.putIfAbsent(key, new ArrayList<>());
            group.get(key).add(str);
        }

        return new ArrayList<>(group.values());
    }
}
