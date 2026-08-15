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
        if(digits.equals("")) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(digits, ans, sb, 0);
        return ans;
    }

    public void solve(String digits, List<String> ans, StringBuilder sb, int index){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letter = mapping[digit - '0'];

        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            solve(digits, ans, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
