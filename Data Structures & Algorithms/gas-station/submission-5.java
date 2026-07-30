class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalFuel = 0;

        for(int i = 0; i<n; i++){
            totalFuel = gas[i] - cost[i];
            if(totalFuel < 0) continue;
            int j = (i + 1) % n;
            while(j < n){
                int fuel_insert = gas[j];
                int cost_toNext = cost[j];

                totalFuel += fuel_insert - cost_toNext;
                if(totalFuel < 0) break;

                j = (j + 1)%n;
                if(j == i) return i;
            }
        }

        return -1;
    }
}
