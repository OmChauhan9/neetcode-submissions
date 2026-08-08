class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost) return -1;

        int travel = 0;
        int index = 0;
        for(int i=0; i<n; i++){
            travel += gas[i] - cost[i];
            if(travel < 0){
                travel = 0;
                index = i + 1;
            }
        }

        return index;
    }
}
