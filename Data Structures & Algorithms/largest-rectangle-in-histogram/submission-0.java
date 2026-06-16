class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i = 0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();
                max = Math.max(max,(nse - pse -1)*heights[element]);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
                int nse = heights.length;
                int element = st.peek();
                st.pop();
                int pse = st.empty() ? -1 : st.peek();
                max = Math.max(max,(nse - pse -1)*heights[element]);
        }
        return max;
    }
}
