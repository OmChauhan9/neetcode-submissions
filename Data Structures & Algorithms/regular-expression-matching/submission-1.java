class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] t = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s,p,0,0,t);
    }

    public boolean solve(String s, String p, int i, int j, Boolean[][] t){
        if(j == p.length()){
            return i == s.length();
        }

        if(t[i][j] != null) return t[i][j];

        boolean first_char = false;

        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            first_char = true;
        }

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean not_take = solve(s,p,i,j+2,t);
            boolean take = first_char && solve(s,p,i+1,j,t);

            return t[i][j] = take || not_take;
        }

        return t[i][j] = first_char && solve(s,p,i+1,j+1,t);
    }
}
