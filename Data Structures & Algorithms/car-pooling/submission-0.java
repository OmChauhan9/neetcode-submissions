class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> tmp = new TreeMap<>();

        for(int[] trip : trips){
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            tmp.put(from, tmp.getOrDefault(from, 0) + numPassengers);
            tmp.put(to, tmp.getOrDefault(to, 0) - numPassengers);
        }

        int currentPassengers = 0;
        for(Map.Entry<Integer, Integer> entry : tmp.entrySet()){
            currentPassengers += entry.getValue();
            if(currentPassengers > capacity) return false;
        }

        return true;
    }
}