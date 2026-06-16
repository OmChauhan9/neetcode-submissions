class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] fleets = new double[n][2];

        for(int i = 0; i<n; i++){
            fleets[i][0] = position[i];
            fleets[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(fleets,(a,b) -> Double.compare(b[0],a[0]));

        int count = 0;
        double pt = 0;
        for(double[] fleet  : fleets){
            if(fleet[1] > pt){
                count++;
                pt = fleet[1];
            }
        }
        return count;
    }
}
