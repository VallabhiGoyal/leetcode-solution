// Last updated: 4/24/2026, 10:30:58 AM
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;

        int[] dp = new int[high + 1];
        dp[0] = 1;

        long total = 0;

        for(int i = 1; i<high+1; i++){
            if(i - zero >= 0){
                dp[i] += dp[i-zero];
                dp[i] %= MOD;
            }

            if(i - one >= 0){
                dp[i] += dp[i-one];
                dp[i] %= MOD;
            }

            if(i>=low){
                total += dp[i];
                total %= MOD;
            }
        }

        return (int)total;
        
    }
}