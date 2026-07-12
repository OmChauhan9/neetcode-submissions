class MinStack {
    Stack<int[]> st;
    int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            min = val;
        }else{
            min = Math.min(st.peek()[1], val);
        }

        st.push(new int[]{val, min});
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
