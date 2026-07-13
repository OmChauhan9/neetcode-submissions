class Solution {
    public String decodeString(String s) {
        int n = s.length();

        Stack<Integer> num = new Stack<>();
        Stack<String> string = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for(int i=0; i<n; i++){
            if(Character.isDigit(s.charAt(i))){
                k = k * 10 + (s.charAt(i) - '0');
            }else if(s.charAt(i) == '['){
                string.push(sb.toString());
                num.push(k);
                sb = new StringBuilder();
                k = 0;
            }else if(s.charAt(i) == ']'){
                String temp = sb.toString();
                sb = new StringBuilder(string.pop());
                int count = num.pop();
                for(int j=0; j<count; j++){
                    sb.append(temp);
                }
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}