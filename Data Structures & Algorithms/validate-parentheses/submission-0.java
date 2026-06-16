class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If it's an opening bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                // If the stack is empty, there is no matching opening bracket.
                if (st.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack and check for matching pair.
                char top = st.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets were properly matched.
        return st.isEmpty();
    }
}