class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<n; i++){
            // if(st.isEmpty()){
            //     st.push(i);
            // }
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int top = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[top] * (nse - pse - 1));
                // st.push(i);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int top = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[top] * (nse - pse - 1));
        }

        return maxArea;
    }
}
