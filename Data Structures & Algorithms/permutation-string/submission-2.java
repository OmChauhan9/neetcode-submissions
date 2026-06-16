class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2){
            return false;
        }

        int[] cnt = new int[26];
        for(int i = 0; i<n1; i++){
            cnt[s1.charAt(i) - 'a']++;
        }

        int l =0;
        int r =n1-1;

        while(r<n2){
            if(checkedArray(cnt,s2,l,r) == true){
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    private boolean checkedArray(int[] cnt, String s2, int start, int end){
        int[] cnt1 = new int[26];
        for(int i = start; i<=end; i++){
            cnt1[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(cnt1,cnt)){
            return true;
        }
        return false;
    }
}
