class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(n, 0, 0, sb, ans);
        return ans;
    }

    public void solve(int n, int openN, int closeN, StringBuilder sb, List<String> ans){
        if(openN == n && closeN == n){
            ans.add(sb.toString());
            return;
        }

        if(openN < n){
            sb.append("(");
            solve(n, openN + 1, closeN, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeN < openN){
            sb.append(")");
            solve(n, openN , closeN + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
