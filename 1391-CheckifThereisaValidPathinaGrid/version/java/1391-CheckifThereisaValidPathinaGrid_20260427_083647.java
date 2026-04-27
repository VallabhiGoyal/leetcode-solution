// Last updated: 4/27/2026, 8:36:47 AM
1class Solution {
2    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
3
4    public boolean hasValidPath(int[][] grid) {
5        int m = grid.length;
6        int n = grid[0].length;
7
8        boolean[][] visited = new boolean[m][n];
9
10        return helper(grid, visited, 0, 0, m, n);
11    }
12
13    private boolean helper(int[][] grid, boolean[][] visited, int i, int j, int m, int n){
14        if(visited[i][j]) return false;
15        if(i == m-1 && j == n-1) return true;
16
17        visited[i][j] = true;
18
19        int curr = grid[i][j];
20
21        for(int d = 0; d < 4; d++){
22            int ni = i + dirs[d][0];
23            int nj = j + dirs[d][1];
24
25            if(ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
26            if(visited[ni][nj]) continue;
27
28            int next = grid[ni][nj];
29            boolean valid = false;
30
31            if(d == 0){
32                if(curr == 2 || curr == 5 || curr == 6){
33                    if(next == 2 || next == 3 || next == 4) valid = true;
34                }
35            }else if(d == 1){
36                if(curr == 2 || curr == 3 || curr == 4){
37                    if(next == 2 || next == 5 || next == 6) valid = true;
38                }
39            }else if(d == 2){
40                if(curr == 1 || curr == 3 || curr == 5){
41                    if(next == 1 || next == 4 || next == 6) valid = true;
42                }
43            }else{
44                if(curr == 1 || curr == 4 || curr == 6){
45                    if(next == 1 || next == 3 || next == 5) valid = true;
46                }
47            }
48
49            if(valid){
50                if(helper(grid, visited, ni, nj, m, n)) return true;
51            }
52        }
53
54        return false;
55    }
56}