class Solution {
    public String decodeString(String s) {
        int n = s.length();

        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }else if(c == '['){
                strSt.push(sb.toString());
                numSt.push(k);
                k = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                int count = numSt.pop();
                String curStr = sb.toString();
                sb = new StringBuilder(strSt.pop());

                for(int i=0; i<count; i++){
                    sb.append(curStr);
                }
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}