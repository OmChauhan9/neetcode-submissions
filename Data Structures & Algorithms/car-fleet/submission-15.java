class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;

        double[][] fleet = new double[n][2];
        for(int i=0; i<n; i++){
            fleet[i][0] = position[i];
            fleet[i][1] = (double) (target - position[i]) / speed[i];
        } 

        Arrays.sort(fleet, (a, b) -> Double.compare(b[0], a[0]));

        int cnt = 0;
        double time = Double.MIN_VALUE;
        for(double[] car : fleet){
            if(car[1] > time){
                cnt++;
                time = car[1];
            }
        }

        return cnt;
    }
}
