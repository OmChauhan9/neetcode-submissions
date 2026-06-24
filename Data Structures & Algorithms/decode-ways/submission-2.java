class Solution {
    public int numDecodings(String s) {
        int[] t = new int[s.length() + 1];
        Arrays.fill(t,-1);
        return solve(s,0,t);
    }

    public int solve(String s, int i, int[] t){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(t[i] != -1) return t[i];

        t[i] = solve(s,i+1,t);

        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
            t[i] += solve(s, i + 2,t);
        }

        return t[i];
    }
}
