class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("+")){
                int top2 = st.pop();
                int top1 = st.pop();

                int total = top2 + top1;
                st.push(total);
            }else if(token.equals("-")){
                int top2 = st.pop();
                int top1 = st.pop();

                int total = top1 - top2;
                st.push(total);
            }else if(token.equals("*")){
                int top2 = st.pop();
                int top1 = st.pop();

                int total = top1 * top2;
                st.push(total);
            }else if(token.equals("/")){
                int top2 = st.pop();
                int top1 = st.pop();

                int total = top1 / top2;
                st.push(total);
            }else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}
