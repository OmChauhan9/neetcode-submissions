class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] fleet = new double[n][2];

        // for(int i=0; i<n; i++){
        //     System.out.println("Speed ::: " + speed[i]);
        // }

        for(int i =0; i<n; i++){
            fleet[i][0] = (double)position[i];
            fleet[i][1] = (double)(target - position[i])/speed[i]; 
        }

        // for (int i = 0; i < n; i++) { // Iterate through rows
        //     for (int j = 0; j < 2; j++) { // Iterate through columns
        //         System.out.print("before " + fleet[i][j] + " "); // Print element and a space
        //     }
        //     System.out.println(); // Move to the next line after each row
        // }

        Arrays.sort(fleet, (a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) { // Iterate through rows
            for (int j = 0; j < 2; j++) { // Iterate through columns
                System.out.print(fleet[i][j] + " "); // Print element and a space
            }
            System.out.println(); // Move to the next line after each row
        }

        int cnt = 0;
        double prevCar = 0;
        for(int i = 0; i<n; i++){
            if(fleet[i][1] > prevCar){
                cnt++;
                prevCar = fleet[i][1];
                System.out.println("prev :: " + prevCar);
            } 
            // else {
            //     prevCar = fleet[i][1];
            // }
        }
        return cnt;
    }
}
