class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        Stack<String> st = new Stack<>();
        String[] splits = path.split("/");

        for(String split : splits){
            if(split.equals("") || split.equals(".")) continue;
            else if(!st.isEmpty() && split.equals("..")) st.pop();
            else if(st.isEmpty() && split.equals("..")) continue;
            else st.push(split);
        }

        if (st.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }
        
        return sb.toString();
    }
}