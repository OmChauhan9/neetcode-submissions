class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalin(s,i,j)){
                    count++;
                }
            }
        }
        return count;

    }

    public boolean isPalin(String temp , int left, int right){
        while(left < right){
            if(temp.charAt(left++) != temp.charAt(right--)) return false;
        }
        return true;
    }
}
