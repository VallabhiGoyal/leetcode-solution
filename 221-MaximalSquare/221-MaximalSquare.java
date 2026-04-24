// Last updated: 4/24/2026, 10:34:58 AM
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int ans = 0;
        for(int i = 0; i<m; i++){
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
        }

        for(int j = 0; j<n; j++){
            dp[0][j] = matrix[0][j] - '0';
            ans = Math.max(ans, dp[0][j]);
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    int best =  Math.min(dp[i-1][j-1], dp[i-1][j]);
                    best = Math.min(best, dp[i][j-1]);
                    dp[i][j] = best + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans*ans;
    }
}