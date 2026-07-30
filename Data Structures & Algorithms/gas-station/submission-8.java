class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalFuel = 0;
        int totalCost = 0;

        for(int i=0; i<n; i++){
            totalFuel += gas[i];
            totalCost += cost[i];
        }

        if(totalFuel < totalCost) return -1;

        int totalTravel_cost = 0;
        int startIndex = 0;
        for(int i=0; i<n; i++){
            totalTravel_cost += gas[i] - cost[i];
            if(totalTravel_cost < 0){
                totalTravel_cost = 0;
                startIndex = i + 1;
            }
        }

        return startIndex;
    }
}
