class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            while(!st.isEmpty() && asteroid < 0 && st.peek() > 0){
                int diff = asteroid + st.peek();
                if(diff < 0){
                    st.pop();
                }else if(diff > 0){
                    asteroid = 0;
                }else{
                    asteroid = 0;
                    st.pop();
                }
            }

            if(asteroid != 0) st.push(asteroid);
        }

        int[] result = new int[st.size()];

        for(int i=st.size()-1; i>=0; i--){
            result[i] = st.pop();
        }

        return result;
    }
}