// Last updated: 4/24/2026, 10:33:07 AM
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] t = new int[n];

        t[0] = cost[0];
        t[1] = cost[1];
        for(int i = 2; i<n; i++){
            t[i] = cost[i] + Math.min(t[i-1], t[i-2]);
        }

        return Math.min(t[n-1], t[n-2]);
    }
}