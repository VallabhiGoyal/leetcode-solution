// Last updated: 9/14/2026, 10:07:59 AM
1class Solution {
2    public int minDays(int n) {
3        int[] dp = new int[n+1];
4        Arrays.fill(dp, Integer.MAX_VALUE);
5        dp[0] = 0;
6
7        for(int k = 1; ; k++){
8            int score = k * (k + 1)/2;
9
10            if(score > n) break;
11
12            int cost = k + 1;
13
14            for (int x = score; x <= n; x++) {
15                if (dp[x - score] != Integer.MAX_VALUE) {
16                    dp[x] = Math.min(dp[x], dp[x - score] + cost);
17                }
18            }
19        }
20
21        return dp[n] - 1;
22    }
23}