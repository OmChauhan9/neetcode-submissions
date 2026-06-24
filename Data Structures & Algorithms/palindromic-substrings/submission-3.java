class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        int n = s.length();
        int count = 0;

        for(int i=0; i<=n; i++){
            // For odd
            count += isPalin(s,i,i);

            // For even
            count += isPalin(s,i,i+1);
        }

        return count;
    }

    public int isPalin(String s , int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && (s.charAt(left--) == s.charAt(right++))){
            count++;
        }
        return count;
    }
}
