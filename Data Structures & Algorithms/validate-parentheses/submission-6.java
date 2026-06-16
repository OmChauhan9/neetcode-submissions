class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        System.out.println("s ::: " + s);
        Stack<Character> st = new Stack<>();

        // for(int i = 0; i<n; i++){
        //     if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
        //         st.push(s.charAt(i));
        //         System.out.println("st ::::: " + st);
        //     } else {
        //         if(s.charAt(i) == ')'){
        //             if(st.peek() == '('){
        //                 st.pop();
        //                 System.out.println("st ::::: " + st);
        //             }
        //             else{
        //                 return false;
        //             }
        //         } else if(s.charAt(i) == '}'){
        //             if(st.peek() == '{'){
        //                 st.pop();
        //                 System.out.println("st ::::: " + st);
        //             }
        //             else{
        //                 return false;
        //             }
        //         } else if(s.charAt(i) == ']'){
        //             if(st.peek() == '['){
        //                 st.pop();
        //                 System.out.println("st ::::: " + st);
        //             }   
        //         else{
        //             return false;
        //         }
        //     }
        // }
        // }
        // return true;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
                System.out.println("st ::::: " + st);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }


                if((s.charAt(i) == ')' && st.pop() != '(') ||
                    (s.charAt(i) == '}' && st.pop() != '{') ||
                    (s.charAt(i) == ']' && st.pop() != '[')){
                        return false;
                } 
            }
        }
        return st.isEmpty();
    }
}
