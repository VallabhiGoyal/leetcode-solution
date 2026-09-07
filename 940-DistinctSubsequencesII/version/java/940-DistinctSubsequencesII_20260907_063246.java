// Last updated: 9/7/2026, 6:32:46 AM
1class Solution {
2    public int distinctSubseqII(String s) {
3        int n = s.length();
4        long MOD = 1000000007L;
5
6        long[] last = new long[26];
7
8        long[] dp = new long[n+1];
9        dp[0] = 1;
10
11        for(int i = 1; i <= n; i++){
12            int c = s.charAt(i-1) - 'a';
13
14            dp[i] = (2 * dp[i-1]) % MOD;
15
16            if(last[c] != 0){
17                dp[i] = (dp[i] - last[c] + MOD) % MOD;
18            }
19
20            last[c] = dp[i-1] % MOD;
21        }
22
23        if(dp[n] == 0) return 1000000006;
24        return (int)dp[n]-1;
25    }
26}