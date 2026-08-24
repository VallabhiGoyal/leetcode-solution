// Last updated: 8/25/2026, 4:49:35 AM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4
5        long aliceScore = 0;
6        long bobScore = 0;
7
8        long[] prefix = new long[n];
9        prefix[0] = stones[0];
10
11        for(int i = 1; i<n; i++){
12            prefix[i] = prefix[i-1] + stones[i];
13        }
14
15        long[] dp = new long[n];
16        dp[n-1] = prefix[n-1];
17
18        for(int i = n-2; i>0; i--){
19            dp[i] = Math.max(prefix[i] - dp[i+1], dp[i+1]);
20        }
21
22        return (int)dp[1];
23    }
24}