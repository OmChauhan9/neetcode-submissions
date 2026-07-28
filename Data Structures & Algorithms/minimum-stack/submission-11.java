class MinStack {
    Stack<int[]> st;
    // int min;

    public MinStack() {
        st = new Stack();
        // min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(!st.isEmpty()){
            if(val > st.peek()[1]){
                st.push(new int[]{val, st.peek()[1]});
            }else{
                st.push(new int[]{val, val});
            }
        }else{
            st.push(new int[]{val, val});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
