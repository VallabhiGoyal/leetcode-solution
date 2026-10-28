// Last updated: 10/28/2026, 5:53:15 AM
1class Solution {
2    public int minCost(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        boolean[][][] dp = new boolean[n][m][1024];
7
8        dp[0][0][grid[0][0]] = true;
9
10        for (int i = 1; i < n; i++) {
11            for (int x = 0; x < 1024; x++) {
12                if (dp[i - 1][0][x]) {
13                    dp[i][0][x ^ grid[i][0]] = true;
14                }
15            }
16        }
17
18        for (int j = 1; j < m; j++) {
19            for (int x = 0; x < 1024; x++) {
20                if (dp[0][j - 1][x]) {
21                    dp[0][j][x ^ grid[0][j]] = true;
22                }
23            }
24        }
25
26        for (int i = 1; i < n; i++) {
27            for (int j = 1; j < m; j++) {
28                for (int x = 0; x < 1024; x++) {
29                    if (dp[i - 1][j][x]) {
30                        dp[i][j][x ^ grid[i][j]] = true;
31                    }
32
33                    if (dp[i][j - 1][x]) {
34                        dp[i][j][x ^ grid[i][j]] = true;
35                    }
36                }
37            }
38        }
39
40        for (int x = 0; x < 1024; x++) {
41            if (dp[n - 1][m - 1][x]) {
42                return x;
43            }
44        }
45
46        return -1;
47    }
48}