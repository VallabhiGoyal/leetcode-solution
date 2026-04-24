// Last updated: 4/24/2026, 10:33:51 AM
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i<len; i++){
            String s = strs[i];
            int size = s.length();

            int zero = 0;
            int one = 0;
            for(int j = 0; j<size; j++){
                if(s.charAt(j) == '0') zero++;
                else one++;
            }
            for(int j = m; j>=zero; j--){
                for(int k = n; k>=one; k--){
                    if(zero <= j && one <= k){
                        dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zero][k - one]);
                    }
                }
            }
        }

        return dp[m][n];
    }
}