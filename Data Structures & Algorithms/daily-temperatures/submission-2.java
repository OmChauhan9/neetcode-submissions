// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] dT = new int[n];
//         Stack<Integer> st = new Stack<>();

//         for(int i=n-1;i>=0; i--){
//             while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
//                 st.pop();
//             }

//             if(!st.isEmpty()){
//                 dT[i] = st.peek() - i;
//             }

//             st.push(i);
//         }
//         return dT;
//     }
// }
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        // res[n-1] = 0;
        stack.push(n-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}