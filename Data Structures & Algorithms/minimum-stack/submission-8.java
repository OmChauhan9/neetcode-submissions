class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = val;
        if(st.isEmpty()){
            min = v;
            st.push(v);
        }else{
            if(v < min){
                long newVal = (2 * v) - min;
                min = v;
                st.push(newVal);
            }else{
                st.push(v);
            }
        }
    }
    
    public void pop() {
        long topMost = st.peek();
        if(topMost < min){
            min = (2 * min) - topMost;
            st.pop();
        }else{
            st.pop();
        }
    }
    
    public int top() {
        long topMost = st.peek();
        if(topMost < min){
            return (int) min;
        }else{
            return (int) topMost;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
