class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        // System.out.println("s ::: " + s);
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
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
        return true;
    }
}
