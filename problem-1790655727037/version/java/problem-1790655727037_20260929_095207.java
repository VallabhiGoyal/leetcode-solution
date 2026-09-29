// Last updated: 9/29/2026, 9:52:07 AM
1class Solution {
2    int[][][] memo;
3
4    public boolean hasValidPath(char[][] grid) {
5        int m = grid.length;
6        int n = grid[0].length;
7
8        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;      
9        
10        memo = new int[m][n][m+n];
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                Arrays.fill(memo[i][j], -1);
14            }   
15        }
16
17        return solve(grid, 0, 0, 0);
18    }
19
20    public boolean solve(char[][] grid, int i, int j, int balance){
21        int m = grid.length;
22        int n = grid[0].length;
23
24        if(balance < 0) return false;
25
26        if(memo[i][j][balance] != -1) return memo[i][j][balance] == 1;
27
28        int newBalance = balance;
29        if(grid[i][j] == '(') newBalance++;
30        else newBalance--;
31
32        if(i == m-1 && j == n-1){
33            return newBalance == 0;
34        }
35
36        boolean down = false;
37        if(i+1 < m){
38            down = solve(grid, i+1, j, newBalance);
39        }
40
41        boolean right  = false;
42        if(j+1 < n){
43            right = solve(grid, i, j+1, newBalance);
44        }
45
46        boolean ans = down || right;
47
48        memo[i][j][balance] = ans ? 1 : 0;
49
50        return ans;
51    }
52}