class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(operations[i].equals("+")){
                int value1 = st.pop();
                int value2 = st.pop();
                st.push(value2);
                st.push(value1);
                int newValue = value1 + value2;
                st.push(newValue);
            }else if(operations[i].equals("D")){
                int value1 = st.peek();
                int newValue = 2 * value1;
                st.push(newValue);
            }else if(operations[i].equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
        }

        int ans = 0;

        while(!st.isEmpty()){
            ans += st.pop();
        }

        return ans;
    }
}