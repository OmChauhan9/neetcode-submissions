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
        if(digits.length() == 0) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(digits, sb, ans, 0);
        return ans;
    }

    private void solve(String digits, StringBuilder sb, List<String> ans, int index){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char[] c = digits.toCharArray();
        String letter = mapping[c[index] - '0'];

        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            solve(digits, sb, ans, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
