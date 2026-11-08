// Last updated: 11/8/2026, 9:49:06 AM
1class Solution {
2    public int countServers(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[] row = new int[m];
7        int[] col = new int[n];
8
9        for(int i = 0; i < m; i++){
10            for(int j = 0; j < n; j++){
11                if(grid[i][j] == 1){
12                    row[i]++;
13                    col[j]++;
14                }
15            }
16        }
17
18        int ans = 0;
19
20        for(int i = 0; i < m; i++){
21            for(int j = 0; j < n; j++){
22                if(grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)){
23                    ans++;
24                }
25            }
26        }
27
28        return ans;
29    }
30}