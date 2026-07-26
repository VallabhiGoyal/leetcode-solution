// Last updated: 7/26/2026, 7:05:28 AM
1class Solution {
2    public int numSquares(int n) {
3        int[] dp = new int[n+1];
4 
5        for(int i = 1; i<n+1; i++){
6            dp[i] = Integer.MAX_VALUE;
7        }
8
9        for(int i = 1; i*i<=n; i++){
10            int square = i*i;
11            for(int j = square; j<=n; j++){
12                dp[j] = Math.min(dp[j], 1 + dp[j-square]);
13            }
14        }
15
16        return dp[n];
17    }
18}