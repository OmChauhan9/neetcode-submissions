class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(s.charAt(i), i);
        }

        List<Integer> ls = new ArrayList<>();
        int i=0;
        int start = 0;
        int end = 0;
        while(i < n){
            end = Math.max(end, mp.get(s.charAt(i)));
            if(i == end){
                ls.add(end - start + 1);
                start = end + 1;
            }
            i++;
        }

        return ls;
    }
}
