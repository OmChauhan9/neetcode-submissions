class Solution {

    private String[] dl = { "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        lCom(0, digits, "", res);
        return res;
    }

    public void lCom(int index, String digits, String cur, List<String> res){
        if(index == digits.length()){
            res.add(cur);
            return;
        }

        String dLets = dl[digits.charAt(index) - '0'];
        for(char dLet : dLets.toCharArray()){
            lCom(index + 1, digits, cur + dLet, res);
        }
    }
}
