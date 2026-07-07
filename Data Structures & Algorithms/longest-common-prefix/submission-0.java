class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        String prefix = strs[0];
        for(int i=1; i<n; i++){
            String current = strs[i];
            while(current.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) break;
            }
        }

        return prefix;
    }
}