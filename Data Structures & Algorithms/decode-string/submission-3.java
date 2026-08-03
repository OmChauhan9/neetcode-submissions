class Solution {
    public String decodeString(String s) {
        int n = s.length();

        Stack<Integer> num = new Stack<>();
        Stack<String> prevStr = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }else if(c == '['){
                prevStr.push(sb.toString());
                num.push(k);
                k = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                String newStr = sb.toString();
                int noOfTimes = num.pop();
                sb = new StringBuilder(prevStr.pop());

                for(int i=0; i<noOfTimes; i++){
                    sb.append(newStr);
                }
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}