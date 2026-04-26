// Last updated: 4/26/2026, 8:59:39 AM
/*
 * Approach
 *     Treat grid as a graph
 *     Use DFS with parent tracking
 *     For each unvisited cell:
 *         Explore same-character neighbors
 *         If you reach a visited cell (not parent) → cycle found
 * 
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
*/

1class Solution {
2    public boolean containsCycle(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        boolean[][] visited = new boolean[m][n];
7
8        for(int i = 0; i<m; i++){
9            for(int j = 0; j<n; j++){
10                if(!visited[i][j]){
11                    if(dfs(grid, visited, i, j, -1, -1)) return true;
12                }
13            }
14        }
15
16        return false;
17    }
18
19    private boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int parentRow, int parentCol){
20        int m = grid.length;
21        int n = grid[0].length;
22
23        visited[row][col] = true;
24
25        if(row-1 >= 0 && grid[row][col] == grid[row-1][col]){
26            if(!visited[row-1][col]){
27                if(dfs(grid, visited, row-1, col, row, col)) return true;
28            }           
29            else if(!(row-1 == parentRow && col == parentCol)) return true;
30        }
31
32        if(col-1 >= 0 && grid[row][col] == grid[row][col-1]){
33            if(!visited[row][col-1]){
34                if(dfs(grid, visited, row, col-1, row, col)) return true;
35            }           
36            else if(!(row == parentRow && col-1 == parentCol)) return true;
37        }
38
39        if(row+1 < m && grid[row][col] == grid[row+1][col]){
40            if(!visited[row+1][col]){
41                if(dfs(grid, visited, row+1, col, row, col)) return true;
42            }           
43            else if(!(row+1 == parentRow && col == parentCol)) return true;
44        }
45
46        if(col + 1 < n && grid[row][col] == grid[row][col+1]){
47            if(!visited[row][col+1]){
48                if(dfs(grid, visited, row, col+1, row, col)) return true;
49            }           
50            else if(!(row == parentRow && col+1 == parentCol)) return true;
51        }
52
53        return false;
54    }
55}