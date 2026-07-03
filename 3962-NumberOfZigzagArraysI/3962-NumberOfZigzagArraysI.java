// Last updated: 7/3/2026, 11:36:19 AM
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1000000007;
        int m = r - l + 1;
        
        long[][] dp = new long[m+1][2];

        for(int i = 1; i<=m; i++){
            dp[i][1] = i - 1;
            dp[i][0] = m - i; 
        }

        for(int len = 3; len <= n; len++){
            long[] preUp = new long[m+1];
            long[] preDown = new long[m+1];

            for(int i = 1; i<=m; i++){
                preUp[i] = (preUp[i-1] + dp[i][1])%MOD;
                preDown[i] = (preDown[i-1] + dp[i][0])%MOD;
            }

            long[][] newDp = new long[m+1][2];

            for(int i = 1; i<=m; i++){
                newDp[i][1] = preDown[i-1];
                newDp[i][0] = (preUp[m] - preUp[i] + MOD)%MOD; 
            }

            dp = newDp;
        }

        long ans = 0;

        for(int i = 1; i <= m; i++){
            ans = ans + dp[i][0] + dp[i][1];
            ans %= MOD;
        }

        return (int)(ans%MOD);
    }
}