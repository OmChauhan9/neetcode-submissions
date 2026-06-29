class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s,p,0,0);
    }

    public boolean solve(String s, String p, int i, int j){
        if(j == p.length()){
            return i == s.length();
        }

        boolean first_char = false;

        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            first_char = true;
        }

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean not_take = solve(s,p,i,j+2);
            boolean take = first_char && solve(s,p,i+1,j);

            return take || not_take;
        }

        return first_char && solve(s,p,i+1,j+1);
    }
}
