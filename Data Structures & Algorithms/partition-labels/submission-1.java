class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];

        for(int i=0; i<n; i++){
            int alphabet = s.charAt(i) - 'a';
            lastIndex[alphabet] = i;
        }

        List<Integer> ls = new ArrayList<>();
        int i = 0, end = 0, start = 0;
        while(i < n){
            end = Math.max(end,lastIndex[s.charAt(i) - 'a']);
            if(i == end){
                ls.add(end - start + 1);
                start = end + 1;
            }
            i++;
        }

        return ls;
    }
}
