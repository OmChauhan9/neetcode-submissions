class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left = 0;
        int right = clean.length()-1;

        while(left<right){
            if(clean.charAt(left++) != clean.charAt(right--)){
                return false;
            }
            // left++;
            // right--;
        }
        return true;
    }
}
