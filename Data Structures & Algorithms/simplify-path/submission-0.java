class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        Stack<String> st = new Stack<>();
        String[] splits = path.split("/");

        for(String split : splits){
            if(split.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(!split.equals("") && !split.equals(".")){
                st.push(split);
            }
        }

        return "/" + String.join("/", st);
    }
}