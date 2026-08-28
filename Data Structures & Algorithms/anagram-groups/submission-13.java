class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String s = strs[i];

            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }

            String newS = Arrays.toString(freq);
            mp.computeIfAbsent(newS, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
