class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            String s = strs[i];

            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }

            String cts = Arrays.toString(freq);

            if(!mp.containsKey(cts)){
                mp.put(cts, new ArrayList<>());
            }

            mp.get(cts).add(s);
        }

        ls.addAll(mp.values());
        return ls;
    }
}
