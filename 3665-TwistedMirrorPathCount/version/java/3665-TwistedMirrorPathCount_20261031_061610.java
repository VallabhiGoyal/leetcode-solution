// Last updated: 10/31/2026, 6:16:10 AM
1public class Solution {
2    public int uniquePaths(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int mod = 1_000_000_007;
6        int[] dp = new int[m];
7        dp[0] = 1;
8        for (int j = 1; j < m; j++) {
9            if (grid[0][j - 1] == 0) {
10                dp[j] = dp[j - 1];
11            }
12        }
13        for (int i = 1; i < n; i++) {
14            int[] next = new int[m];
15            if (grid[i - 1][0] == 0 && grid[i][0] == 0) {
16                next[0] = dp[0];
17            }
18            for (int j = 1; j < m; j++) {
19                if (grid[i][j] == 0) {
20                    next[j] = (next[j] + dp[j]) % mod;
21                }
22                if (grid[i][j - 1] == 0) {
23                    next[j] = (next[j] + next[j - 1]) % mod;
24                } else {
25                    next[j] = (next[j] + dp[j - 1]) % mod;
26                }
27            }
28            dp = next;
29        }
30        return dp[m - 1];
31    }
32}