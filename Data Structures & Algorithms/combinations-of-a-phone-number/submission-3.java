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
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if(digits.length() == 0) return ls;

        solve(digits, sb, ls, 0);
        return ls;
    }

    public void solve(String digits, StringBuilder sb, List<String> ls, int index){
        if(index == digits.length()){
            ls.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];

        for(int i=0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            solve(digits, sb, ls, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
