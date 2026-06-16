class Solution {
    public boolean isPalindrome(String s) {
        String stringWS = s.replaceAll("[^a-zA-Z0-9]","");
        String uniString = stringWS.toLowerCase();
        System.out.println("uni ::::: " + uniString);
        int left = 0;
        int right = stringWS.length() - 1;

        while(left <= right){
            if(uniString.charAt(left++) != uniString.charAt(right--)){
                return false;
            }
            // left++;
            // right--;
        }
        return true;
    }
}
