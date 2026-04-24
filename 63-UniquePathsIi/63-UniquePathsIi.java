// Last updated: 4/24/2026, 10:36:34 AM
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int[] dp = new int[n];

        for(int i = 0; i<n; i++){
            if(obstacleGrid[0][i] == 1) break;
            else dp[i] = 1;
        }

        for(int i = 1; i<m; i++){
            if(obstacleGrid[i][0] == 1) dp[0] = 0;
            for(int j = 1; j<n; j++){
                if(obstacleGrid[i][j] != 1){
                    dp[j] += dp[j-1];
                }else{
                    dp[j] = 0;
                }
            }
        }

        return dp[n-1];
    }
}