class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int elements = st.peek();
                st.pop();
                int nse = heights[i];
                int pse = st.isEmpty() ? -1 : st.peek();
                area = Math.max(area, heights[elements] * (nse - pse -1));
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int elements = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            area = Math.max(area, heights[elements] * (nse - pse -1));
        }

        return area;
    }
}
