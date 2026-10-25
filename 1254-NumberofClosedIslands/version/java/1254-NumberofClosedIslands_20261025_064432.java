// Last updated: 10/25/2026, 6:44:32 AM
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        for(int i = 0; i<n; i++){
7            helper(grid, i, 0);
8            helper(grid, i, m-1);
9        }
10        for(int j = 0; j<m; j++){
11            helper(grid, 0, j);
12            helper(grid, n-1, j);
13        }
14        
15        int count = 0;
16        for(int i = 1; i<n-1; i++){
17            for(int j = 1; j<m-1; j++){
18                if(grid[i][j] == 0){
19                    count++;
20                    helper(grid, i, j);
21                }
22            }
23        }
24
25        return count;
26    }
27
28    public void helper(int[][] grid, int i, int j) {
29        if(grid[i][j] != 0) return;
30        
31        int n = grid.length;
32        int m = grid[0].length;
33
34        Stack<int[]> stack = new Stack<>();
35        stack.push(new int[] {i,j});
36        grid[i][j] = -1;
37
38        while (!stack.isEmpty()) {
39            int[] curr = stack.pop();
40            int tempi = curr[0];
41            int tempj = curr[1];
42
43            if (tempi > 0 && grid[tempi - 1][tempj] == 0) {
44                grid[tempi-1][tempj] = -1;
45                stack.push(new int[] { tempi - 1, tempj });
46            }
47            if (tempi + 1 < n && grid[tempi + 1][tempj] == 0) {
48                grid[tempi+1][tempj] = -1;
49                stack.push(new int[] { tempi + 1, tempj });
50            }
51            if (tempj > 0 && grid[tempi][tempj - 1] == 0) {
52                grid[tempi][tempj-1] = -1;
53                stack.push(new int[] { tempi, tempj - 1 });
54            }
55            if (tempj + 1 < m && grid[tempi][tempj + 1] == 0) {
56                grid[tempi][tempj+1] = -1;
57                stack.push(new int[] { tempi, tempj + 1 });
58            }
59        }
60    }
61}