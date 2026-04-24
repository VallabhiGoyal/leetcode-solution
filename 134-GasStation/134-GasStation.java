// Last updated: 4/24/2026, 10:35:36 AM
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas) return -1;

        int currCost = 0;

        int j = 0;
        for(int i = 0; i<n; i++){
            currCost += gas[i] - cost[i];

            if(currCost < 0){
                currCost = 0;
                j = i + 1;
            }
        }

        return j;
    } 
}