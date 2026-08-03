// Last updated: 8/3/2026, 9:46:30 AM
1class Solution {
2    public String stoneGameIII(int[] stoneValue) {
3        int n = stoneValue.length;
4
5        int[] dp = new int[n+1];
6
7        for(int i = n-1; i>=0; i--){
8             dp[i] = stoneValue[i] - dp[i + 1];
9
10            if (i + 1 < n) {
11                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);
12            }
13
14            if (i + 2 < n) {
15                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);
16            }
17        }
18
19        if(dp[0] > 0) return "Alice";
20        else if(dp[0] == 0) return "Tie";
21        return "Bob"; 
22    }
23}