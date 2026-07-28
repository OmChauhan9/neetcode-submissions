class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] fleet = new double[n][2];
        for(int i=0; i<n; i++){
            fleet[i][0] = position[i];
            fleet[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(fleet, (a,b) -> Double.compare(b[0], a[0]));

        int cntFleet = 0;
        double curTime = 0;
        for(int i=0; i<n; i++){
            if(fleet[i][1] >  curTime){
                cntFleet++;
                curTime = fleet[i][1];
            }
        }

        return cntFleet++;
    }
}
