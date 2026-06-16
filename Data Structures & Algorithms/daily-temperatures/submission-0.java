class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek() - i; 
            }

            st.push(i);
        }
        return res;
        // int n = temperatures.length;
        // int[] res = new int[n];
        // int count = 0;

        // for(int i = 1; i<n; i++){
        //     int diff = temperatures[i] - temperatures[i-1];
        //     if(diff > 0){
        //         count++;
        //         res[i-1] = count;
        //     }
            
        // }
        // return res;
    }
}
