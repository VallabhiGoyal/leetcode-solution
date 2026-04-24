// Last updated: 4/24/2026, 10:32:58 AM
class Solution {
    public int numTilings(int n) {
        if(n <= 2) return n;
        if(n == 3) return 5; 

        int MOD = 1000000007;

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<n+1; i++){
            dp[i] = ((2*dp[i-1]) + dp[i-3]) % MOD;
        }

        return (int)dp[n];
    } 
}