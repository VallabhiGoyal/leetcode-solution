// Last updated: 10/26/2026, 7:27:10 AM
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int m = dungeon.length;
4        int n = dungeon[0].length;
5
6        int ans = 0;
7
8        int[][] dp = new int[m][n];
9        if(dungeon[m-1][n-1] >= 0){
10            dp[m-1][n-1] = 1;
11        }else{
12            dp[m-1][n-1] = Math.abs(dungeon[m-1][n-1]) + 1;
13        }
14
15        for(int i = m-2; i >= 0; i--){
16            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
17        }
18
19        for(int j = n-2; j>=0; j--){
20            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
21        }        
22
23        for(int i = m-2; i >= 0; i--){
24            for(int j = n-2; j >= 0; j--){
25                int next = Math.min(dp[i+1][j], dp[i][j+1]);
26                dp[i][j] = Math.max(1, next - dungeon[i][j]);
27            }
28        }
29        
30        return dp[0][0];
31    }
32}