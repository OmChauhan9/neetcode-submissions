class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        check(s, ans, ls, 0);
        return ans;
    }

    public void check(String s, List<List<String>> ans, List<String> ls, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }


        for(int i=index; i<s.length(); i++){
            if(isPalin(s.substring(index, i + 1))){
                ls.add(s.substring(index, i + 1));
                check(s, ans, ls, i + 1);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public boolean isPalin(String s){
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
