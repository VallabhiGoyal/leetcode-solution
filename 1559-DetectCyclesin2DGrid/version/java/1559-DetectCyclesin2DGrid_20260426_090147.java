// Last updated: 4/26/2026, 9:01:47 AM
1class Solution {
2    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
3    int m, n;
4
5    public boolean containsCycle(char[][] grid) {
6        m = grid.length;
7        n = grid[0].length;
8
9        boolean[][] visited = new boolean[m][n];
10
11        for(int i = 0; i < m; i++){
12            for(int j = 0; j < n; j++){
13                if(!visited[i][j]){
14                    if(dfs(grid, visited, i, j, -1, -1)) return true;
15                }
16            }
17        }
18        return false;
19    }
20
21    private boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int pr, int pc){
22        visited[row][col] = true;
23        char ch = grid[row][col];
24
25        for(int[] d : dirs){
26            int nr = row + d[0];
27            int nc = col + d[1];
28
29            if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
30            if(grid[nr][nc] != ch) continue;
31
32            if(!visited[nr][nc]){
33                if(dfs(grid, visited, nr, nc, row, col)) return true;
34            } else if(!(nr == pr && nc == pc)){
35                return true;
36            }
37        }
38        return false;
39    }
40}