// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> st = new Stack<>(); 

//         for(String token : tokens){
//             if(token.equals("+")){
//                 st.push(st.pop() + st.pop());
//             } else if(token.equals("-")){
//                 int t1 = st.pop();
//                 int t2 = st.pop();
//                 st.push(t2-t1);
//             } else if(token.equals("/")){
//                 int t1 = st.pop();
//                 int t2 = st.pop();
//                 st.push(t2/t1);
//             } else if(token.equals("*")){
//                 st.push(st.pop() * st.pop());
//             } else{
//                 st.push(Integer.parseInt(token));
//             }
//         } 
//         return st.pop();  
//     } 
// }

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (tokens[i].equals("+"))
                    num1 += num2;
                else if (tokens[i].equals("-"))
                    num1 -= num2;
                else if (tokens[i].equals("*"))
                    num1 *= num2;
                else num1 /= num2;
                stack.push(num1);
            }
            else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }
}
