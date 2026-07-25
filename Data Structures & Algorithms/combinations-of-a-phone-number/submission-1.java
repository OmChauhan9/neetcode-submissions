class Solution {
    String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        StringBuilder sb = new StringBuilder();
        letter(digits, ans, sb, 0);
        return ans;
    }

    public void letter(String digits, List<String> ans, StringBuilder sb, int index){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];

        for(int i=0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            letter(digits, ans, sb, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
