// Last updated: 4/24/2026, 10:32:33 AM
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        int one = costs[0];
        int seven = costs[1];
        int thirty = costs[2];

        int[] dp = new int[n+1];

        for(int i = n-1; i >=0; i--){
            int day = days[i];

            int j7 = i;

            while(j7 < n && days[j7] <= days[i] + 6){
                j7++;
            }

            int j30 = j7;
            while(j30 < n && days[j30] <= days[i] + 29){
                j30++;
            }

            int best = Math.min(one + dp[i+1], seven + dp[j7]);
            dp[i] = Math.min(best, thirty + dp[j30]);
        }

        return dp[0];
    }
}