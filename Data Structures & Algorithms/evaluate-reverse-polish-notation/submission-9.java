class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(String token : tokens){
            if(token.equals("+")){
                int val1 = st.pop();
                int val2 = st.pop();
                int newVal = val1 + val2;
                st.push(newVal); 
            }else if(token.equals("*")){
                int val1 = st.pop();
                int val2 = st.pop();
                int newVal = val1 * val2;
                st.push(newVal); 
            }else if(token.equals("-")){
                int val1 = st.pop();
                int val2 = st.pop();
                int newVal = val2 - val1;
                st.push(newVal); 
            }else if(token.equals("/")){
                int val1 = st.pop();
                int val2 = st.pop();
                int newVal = val2 / val1;
                st.push(newVal); 
            }else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}
