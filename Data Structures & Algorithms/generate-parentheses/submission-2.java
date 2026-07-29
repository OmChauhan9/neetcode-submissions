class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        check(n, 0, 0, ans, sb);
        return ans;
    }

    public void check(int n, int open, int close, List<String> ans, StringBuilder sb){
        if(open == n && close == n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            check(n, open + 1, close, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            check(n, open, close + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
