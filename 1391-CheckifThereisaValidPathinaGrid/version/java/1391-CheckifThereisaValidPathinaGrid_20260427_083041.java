// Last updated: 4/27/2026, 8:30:41 AM
/*
 * Approach
 *     Use DFS from (0,0)
 *     Move only if street connection is valid both ways
 *     Stop if reach (m-1, n-1)
 * 
 * Time Complexity: O(m x n)
 * Space Complexity: O(m x n)
*/

1class Solution {
2    public boolean hasValidPath(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        boolean[][] visited = new boolean[m][n];
7
8        return helper(grid, visited, 0, 0, m, n);
9    }
10
11    private boolean helper(int[][] grid, boolean[][] visited, int i, int j, int m, int n){
12        if(visited[i][j]) return false;
13        if(i == m-1 && j == n-1) return true;
14
15        visited[i][j] = true;
16
17        int curr = grid[i][j];
18        if(i-1 >= 0){
19            int next = grid[i-1][j];
20
21            boolean valid = false;
22
23            if(curr == 2 || curr == 5 || curr == 6){
24                if(next == 2 || next == 3 || next == 4){
25                    valid = true;
26                }
27            }
28
29            if(valid && !visited[i-1][j]){
30                if(helper(grid, visited, i-1, j, m, n)) return true;
31            }
32        }
33        if(i+1 < m){
34            int next = grid[i+1][j];
35
36            boolean valid = false;
37
38            if(curr == 2 || curr == 3 || curr == 4){
39                if(next == 2 || next == 5 || next == 6){
40                    valid = true;
41                }
42            }
43
44            if(valid && !visited[i+1][j]){
45                if(helper(grid, visited, i+1, j, m, n)) return true;
46            }
47        }
48        if(j-1 >= 0){
49            int next = grid[i][j-1];
50
51            boolean valid = false;
52
53            if(curr == 1 || curr == 3 || curr == 5){
54                if(next == 1 || next == 4 || next == 6){
55                    valid = true;
56                }
57            }
58
59            if(valid && !visited[i][j-1]){
60                if(helper(grid, visited, i, j-1, m, n)) return true;
61            }
62        }
63        if(j+1 < n){
64            int next = grid[i][j+1];
65
66            boolean valid = false;
67
68            if(curr == 1 || curr == 4 || curr == 6){
69                if(next == 1 || next == 3 || next == 5){
70                    valid = true;
71                }
72            }
73
74            if(valid && !visited[i][j+1]){
75                if(helper(grid, visited, i, j+1, m, n)) return true;
76            }
77        }
78
79        return false;
80    }
81}