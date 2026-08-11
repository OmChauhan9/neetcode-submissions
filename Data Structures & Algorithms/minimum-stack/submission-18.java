class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = (long) val;
        if(st.isEmpty()){
            min = v;
            st.push(v);
        }else{
            if(min < v){
                st.push(v);
            }else{
                long newVal = (2 * v) - min;
                min = v;
                st.push(newVal);
            }
        }
    }
    
    public void pop() {
        if(min > st.peek()){
            long newMin = (2 * min) - st.peek();
            min = newMin;
        }
        st.pop();
    }
    
    public int top() {
        long top = st.peek();
        if(top > min) return (int) top;
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}
