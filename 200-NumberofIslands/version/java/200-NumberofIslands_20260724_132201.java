// Last updated: 7/24/2026, 1:22:01 PM
1class Solution {
2    public int numIslands(char[][] grid) {
3        boolean[][] visit = new boolean[grid.length][grid[0].length];
4        int count = 0;
5
6        for(int i = 0; i<grid.length; i++){
7            for(int j =0; j<grid[0].length; j++){
8                if(!visit[i][j] && grid[i][j] == '1'){
9                    dfs(grid, i, j, visit);
10                    count++;
11                }
12            }
13        }
14
15        return count;
16    }
17
18    private void dfs(char[][] grid, int row, int col, boolean[][] visit){
19
20        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0' || visit[row][col]){
21            return;
22        }
23        
24
25        visit[row][col] = true;
26        dfs(grid, row+1, col, visit);
27        dfs(grid, row, col-1, visit);
28        dfs(grid, row-1, col, visit);
29        dfs(grid, row, col+1, visit);
30
31    }
32}