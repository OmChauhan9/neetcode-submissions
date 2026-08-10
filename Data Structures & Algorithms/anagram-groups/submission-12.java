class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();
        // List<List<String>> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            String s = strs[i];
            // char[] ch = s.toCharArray();
            // Arrays.sort(ch);

            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }

            String st = Arrays.toString(freq);

            if(!mp.containsKey(st)){
                mp.put(st, new ArrayList<>());
            }
            mp.get(st).add(s);
        }

        // ls.addAll(mp.values());
        return new ArrayList<>(mp.values());
    }
}
