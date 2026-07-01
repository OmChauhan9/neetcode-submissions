class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] t = new boolean[n];
        t[0] = true;
        int cnt = 0;

        for(int j=1; j<n; j++){
            if(j - minJump >= 0 && t[j - minJump]){
                cnt++;
            }

            if(j - maxJump - 1 >=0 && t[j - maxJump - 1]){
                cnt--;
            }

            if(cnt > 0 && s.charAt(j) == '0'){
                t[j] = true;
            }
        }


        return t[n-1];
    }
}