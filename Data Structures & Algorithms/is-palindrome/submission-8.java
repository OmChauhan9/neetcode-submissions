class Solution {
    public boolean isPalindrome(String s) {
        String check = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int l = 0;
        int r = check.length() - 1;

        while(l < r){
            if(check.charAt(l++) != check.charAt(r--)){
                return false;
            }
        }

        return true;
    }
}
