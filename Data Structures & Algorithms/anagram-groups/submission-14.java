class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String current = strs[i];

            int[] freq = new int[26];
            for(char c : current.toCharArray()){
                freq[c - 'a']++;
            }

            String st = Arrays.toString(freq);

            mp.computeIfAbsent(st, k -> new ArrayList<>()).add(current);
        }

        return new ArrayList<>(mp.values());
    }
}
