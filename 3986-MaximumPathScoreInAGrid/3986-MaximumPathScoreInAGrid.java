// Last updated: 7/3/2026, 11:36:22 AM
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][][] dp = new Integer[m][n][k+1];

        int ans = dfs(grid, dp, 0, 0, k);
        
        if(ans < 0) return -1;
        return ans;
    }

    private int dfs(int[][]grid, Integer[][][] dp, int i, int j, int remainingCost){
        int m = grid.length;
        int n = grid[0].length;

        if(i>=m || j>=n) return -1;

        if(grid[i][j] != 0) remainingCost--;

        if(remainingCost < 0) return -1;

        if(i == m-1 && j == n-1) return grid[i][j];

        if(dp[i][j][remainingCost] != null){
            return dp[i][j][remainingCost];
        }

        int down = dfs(grid, dp, i + 1, j, remainingCost);
        int right = dfs(grid, dp, i, j + 1, remainingCost);

        int best = Math.max(down, right);

        if(best == -1){
            dp[i][j][remainingCost] = -1;
        }else{
            dp[i][j][remainingCost] = grid[i][j] + best;
        }

        return dp[i][j][remainingCost];
    }
}