// Last updated: 10/18/2026, 8:19:42 AM
1class Solution {
2    public int[] lastVisitedCell(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[] ans = new int[2];
7
8        boolean[][] visited = new boolean[m][n];
9        
10        int i = 0; 
11        int j = 0;
12        while(i < m && j < n){
13            if(visited[i][j]) break;
14            visited[i][j] = true;
15
16            ans[0] = i;
17            ans[1] = j;
18
19            char ch = grid[i][j];
20            
21            if(j > 0 && ch == 'L' && !visited[i][j-1]){
22                j--;
23            }else if(j < n-1 && ch == 'R' && !visited[i][j+1]){
24                j++;
25            }else if(i > 0 && ch == 'U' && !visited[i-1][j]){
26                i--;
27            }else if(i < m-1 && ch == 'D' && !visited[i+1][j]){
28                i++;
29            }else break;
30        }
31
32        return ans;
33    }
34}