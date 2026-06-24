class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        int l = s.length();
        HashSet<String> st = new HashSet<>();
        for(int i=0; i<n; i++){
            st.add(wordDict.get(i));
        }

        Boolean[] t = new Boolean[l+1];
        return solve(s,0,st,t);
    }

    public boolean solve(String s, int i, HashSet<String> st, Boolean[] t){
        if(i == s.length()) return true;
        if(t[i] != null) return t[i];
        
        for(int j=i+1; j<=s.length(); j++){
            String w = s.substring(i,j);

            if(st.contains(w) && solve(s,j,st,t)){
                return t[i] = true;
            }
        }

        return t[i] = false;
    }
}
