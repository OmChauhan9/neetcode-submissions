class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for(int i=0; i<n; i++){
            if(cost[i] > gas[i]) continue;
            int currGas = gas[i];
            int currCost = cost[i];
            int j = (i+1)%n;
            int nextGas = gas[j];

            currGas = currGas - currCost + nextGas;

            while( j != i){
                if(cost[j] > currGas) break;
                currCost = cost[j];
                j = (j + 1)%n;
                nextGas = gas[j];

                currGas = currGas - currCost + nextGas;
            }

            if( j == i) return i;
        }

        return -1;
    }
}
