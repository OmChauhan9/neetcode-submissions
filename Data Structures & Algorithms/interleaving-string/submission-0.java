class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        if(n+m != k) return false;

        return solve(s1,s2,s3,n,m,k);
    }

    public boolean solve(String s1, String s2, String s3, int n, int m, int k){
        if(n == 0 && m == 0 && k == 0) return true;
        if(k < 0) return false;

        boolean result = false;
        if(n > 0 &&s1.charAt(n-1) == s3.charAt(k-1)) result = solve(s1,s2,s3,n-1,m,k-1);
        if(result) return true;
        if(m > 0 && s2.charAt(m-1) == s3.charAt(k-1)) result = solve(s1,s2,s3,n,m-1,k-1);

        return result;

    }
}
