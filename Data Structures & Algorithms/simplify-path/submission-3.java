class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        Stack<String> st = new Stack<>();
        String[] splits = path.split("/");

        for(String split : splits){
            if(split.equals("") || split.equals(".")) continue;
            else if(split.equals("..")){
                if(st.isEmpty()) continue;
                else st.pop();
            }
            else st.push(split);
        }

        return "/" + String.join("/", st);
    }
}