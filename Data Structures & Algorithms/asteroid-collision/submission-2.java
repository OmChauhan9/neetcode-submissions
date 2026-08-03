class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0){
                int negVal = Math.abs(asteroids[i]);
                int posVal = st.peek();

                if(negVal > posVal){
                    st.pop();
                }else if(negVal < posVal){
                    asteroids[i] = 0;
                }else{
                    st.pop();
                    asteroids[i] = 0;
                }
            }

            if(asteroids[i] != 0){
                st.push(asteroids[i]);
            }
        }

        int[] ans = new int[st.size()];
        for(int i = st.size() - 1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;

    }
}