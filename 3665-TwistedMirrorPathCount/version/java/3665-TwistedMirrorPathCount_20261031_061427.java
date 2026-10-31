// Last updated: 10/31/2026, 6:14:27 AM
1class Solution {
2    public int uniquePaths(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int mod = 1_000_000_007;
6
7        int[][][] dp = new int[m][n][2];
8
9        dp[0][0][0] = 1;
10
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13
14                for (int d = 0; d < 2; d++) {
15
16                    int ways = dp[i][j][d];
17
18                    if (ways == 0) continue;
19
20                    if (grid[i][j] == 0) {
21
22                        if (j + 1 < n) {
23                            dp[i][j + 1][0] =
24                                (dp[i][j + 1][0] + ways) % mod;
25                        }
26
27                        if (i + 1 < m) {
28                            dp[i + 1][j][1] =
29                                (dp[i + 1][j][1] + ways) % mod;
30                        }
31
32                    } else {
33
34                        if (d == 0 && i + 1 < m) {
35                            dp[i + 1][j][1] =
36                                (dp[i + 1][j][1] + ways) % mod;
37                        }
38
39                        else if (d == 1 && j + 1 < n) {
40                            dp[i][j + 1][0] =
41                                (dp[i][j + 1][0] + ways) % mod;
42                        }
43                    }
44                }
45            }
46        }
47
48        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % mod;
49    }
50}