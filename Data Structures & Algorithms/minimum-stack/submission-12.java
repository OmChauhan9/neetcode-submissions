class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = (long)val;
        if(st.isEmpty()){
            min = v;
            st.push(v);
        }else{
            if(val > min){
                st.push(v);
            }else{
                long newValue = ((2 * v) - min);
                min = v;
                st.push(newValue);
            }
        }
    }
    
    public void pop() {
        if(st.peek() < min){
            min = (2 * min) - st.peek();
        }
        st.pop();
    }
    
    public int top() {
        long top = st.peek();
        if(top < min){
            return (int)min;
        }
        return (int) top;
    }
    
    public int getMin() {
        return (int) min;
    }
}
