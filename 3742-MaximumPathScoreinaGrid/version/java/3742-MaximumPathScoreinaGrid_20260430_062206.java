// Last updated: 4/30/2026, 6:22:06 AM
1class Solution {
2    public int maxPathScore(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        Integer[][][] dp = new Integer[m][n][k+1];
7
8        int ans = dfs(grid, dp, 0, 0, k);
9        
10        if(ans < 0) return -1;
11        return ans;
12    }
13
14    private int dfs(int[][]grid, Integer[][][] dp, int i, int j, int remainingCost){
15        int m = grid.length;
16        int n = grid[0].length;
17
18        if(i>=m || j>=n) return -1;
19
20        if(grid[i][j] != 0) remainingCost--;
21
22        if(remainingCost < 0) return -1;
23
24        if(i == m-1 && j == n-1) return grid[i][j];
25
26        if(dp[i][j][remainingCost] != null){
27            return dp[i][j][remainingCost];
28        }
29
30        int down = dfs(grid, dp, i + 1, j, remainingCost);
31        int right = dfs(grid, dp, i, j + 1, remainingCost);
32
33        int best = Math.max(down, right);
34
35        if(best == -1){
36            dp[i][j][remainingCost] = -1;
37        }else{
38            dp[i][j][remainingCost] = grid[i][j] + best;
39        }
40
41        return dp[i][j][remainingCost];
42    }
43}