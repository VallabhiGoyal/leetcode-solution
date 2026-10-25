// Last updated: 10/25/2026, 6:45:14 AM
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int count = 0;
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
10                    if (grid[i][j] == 0) {
11                        dfs(grid, i, j);
12                    }
13                }
14            }
15        }
16
17        for (int i = 1; i < m - 1; i++) {
18            for (int j = 1; j < n - 1; j++) {
19                if (grid[i][j] == 0) {
20                    dfs(grid, i, j);
21                    count++;
22                }
23            }
24        }
25
26        return count;
27    }
28
29    private void dfs(int[][] grid, int i, int j) {
30        int m = grid.length;
31        int n = grid[0].length;
32
33        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) {
34            return;
35        }
36
37        grid[i][j] = 1;
38
39        dfs(grid, i + 1, j);
40        dfs(grid, i - 1, j);
41        dfs(grid, i, j + 1);
42        dfs(grid, i, j - 1);
43    }
44}