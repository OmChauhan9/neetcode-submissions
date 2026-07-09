class Solution {
    public boolean isPalindrome(String s) {
        String check = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int left = 0;
        int right = check.length() - 1;

        while(left < right) {
            if(check.charAt(left++) != check.charAt(right--)){
                return false;
            }
        }

        return true;
    }
}
