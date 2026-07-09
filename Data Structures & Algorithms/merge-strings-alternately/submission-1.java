class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(); 
        int m = word2.length();

        int left1 = 0;
        int left2 = 0;

        StringBuilder newString = new StringBuilder();

        while(left1 < n || left2 < m){
            if(left1 < n){
                newString.append(word1.charAt(left1++));
            }

            if(left2 < m){
                newString.append(word2.charAt(left2++));
            }
        }

        return newString.toString();
    }
}