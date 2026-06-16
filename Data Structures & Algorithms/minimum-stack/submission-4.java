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
            st.push(v);
            min = v;
        } else {
            if(val < min){
                Long newVal = (2*v) - min;
                st.push(newVal);
                min = v;
            } else{
                st.push(v);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        } else {
            Long top = st.peek();
            if(top < min){
                min = (2*min) - top; 
                st.pop();
            } else {
                st.pop();
            }
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }

        if(st.peek() < min){
            return (int)min;
        } else {
            long top = st.peek();
            return (int) top;
        }
    }

    
    public int getMin() {
        return (int)min;
    }
}
