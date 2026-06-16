class Solution {
    public int tribonacci(int n) {
        int[] t = new int[n+1];
        Arrays.fill(t,-1);
        return tri(n,t);
    }

    public int tri(int n, int[] t){
        if(n == 0) return 0;
        else if( n == 1 || n == 2) return 1;
        if(t[n] != -1) return t[n];
        t[n] = tri(n-1,t) + tri(n-2,t) + tri(n-3,t);
        return t[n];
    }
}