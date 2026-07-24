class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        com(n, k, ans, ls, 1);
        return ans;
    }

    public void com(int n, int k, List<List<Integer>> ans, List<Integer> ls, int index){
        if(ls.size() == k){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i = index; i<=n; i++){
            ls.add(i);
            com(n, k, ans, ls, i + 1);
            ls.remove(ls.size() - 1);
        }
    }
}