class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for(int[] trip : trips){
            int source = trip[1];
            int dest = trip[2];

            diff[source] += trip[0];
            diff[dest] -= trip[0];
        }

        int currentPassengers = 0;
        for(int i=0; i<1001; i++){
            currentPassengers += diff[i];
            if(currentPassengers > capacity) return false;
        }

        return true;
    }
}