class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        solve(s, ls, ans, 0);
        return ans;
    }

    public void solve(String s, List<String> ls, List<List<String>> ans, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalin(s.substring(index, i+1))){
                ls.add(s.substring(index, i+1));
                solve(s, ls, ans, i+1);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public boolean isPalin(String s){
        int n = s.length();

        int l = 0;
        int r = n - 1;

        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }

        return true;
    }
}
