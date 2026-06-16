class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        parT(0, s, new ArrayList<>(), res);
        return res;
    }

    public void parT(int index, String s, List<String> cur, List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                cur.add(s.substring(index,i+1));
                parT(i + 1, s, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
