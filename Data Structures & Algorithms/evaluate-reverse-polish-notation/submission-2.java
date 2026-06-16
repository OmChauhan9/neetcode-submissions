class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>(); 

        for(String token : tokens){
            if(token.equals("+")){
                st.push(st.pop() + st.pop());
            } else if(token.equals("-")){
                st.push(st.pop() - st.pop());
            } else if(token.equals("/")){
                int t1 = st.pop();
                int t2 = st.pop();
                st.push(t2/t1);
            } else if(token.equals("*")){
                st.push(st.pop() * st.pop());
            } else{
                st.push(Integer.parseInt(token));
            }
        } 
        return st.pop();  
    } 
}

