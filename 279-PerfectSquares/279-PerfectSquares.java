// Last updated: 4/24/2026, 10:34:37 AM
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
 
        for(int i = 1; i<n+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i*i<=n; i++){
            int square = i*i;
            for(int j = square; j<=n; j++){
                dp[j] = Math.min(dp[j], 1 + dp[j-square]);
            }
        }

        return dp[n];
    }
}