class MinStack {

    Stack<int[]> st;
    // int min;

    public MinStack() {
        st = new Stack<>();
        // min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
            // min = val;
        }else{
            if(st.peek()[1] > val){
                st.push(new int[]{val,val});
            }else{
                st.push(new int[]{val,st.peek()[1]});
            }
        }
        // if(st.isEmpty()){
        //     st.push(val);
        //     min = val;
        // } else {
        //     if(val < min){
        //         int newVal = (2*val) - min;
        //         st.push(newVal);
        //         min = val;
        //     } else{
        //         st.push(val);
        //     }
        // }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }else{
            st.pop();
        }
        // if(st.isEmpty()){
        //     return;
        // } else {
        //     int top = st.peek();
        //     if(top < min){
        //         min = (2*min) - top; 
        //         st.pop();
        //     } else {
        //         st.pop();
        //     }
        // }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }else{
            return st.peek()[0];
        }
        // if(st.isEmpty()){
        //     return -1;
        // }

        // if(st.peek() < min){
        //     return min;
        // } else {
        //      return st.peek();
        // }
    }

    
    public int getMin() {
        return st.peek()[1];
        // return min;
    }
}
