// Last updated: 7/26/2026, 7:12:56 AM
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int m = board.length;
4        int n = board[0].length;
5        int len = word.length();
6
7        boolean[][] visited = new boolean[m][n];
8
9        boolean flag = false;
10        for(int i = 0; i<m; i++){
11            for(int j = 0; j<n; j++){
12                if(word.charAt(0) == board[i][j]){
13                    flag = helper(visited, board, word, 0, len, i, j, m, n);
14                    if(flag) return true;
15                }
16            }
17        }
18
19        return false;
20    }
21
22    public boolean helper(boolean[][] visited, char[][] board, String word, int idx, int len, int i, int j, int m, int n){
23
24        boolean left = false;
25        boolean right = false;
26        boolean up = false;
27        boolean down = false;
28
29        if(i<m && j < n && idx < len &&  word.charAt(idx) == board[i][j] && !visited[i][j]){            
30            
31            if(idx == len -1) return true;
32            visited[i][j] = true;
33
34            if(i>0 && !visited[i-1][j]){
35                up = helper(visited, board, word, idx+1, len, i-1, j, m, n);
36                if(up) return true;
37            }
38
39            if(j>0 && !visited[i][j-1]){
40                left = helper(visited, board, word, idx+1, len, i, j-1, m, n);
41                if(left) return true;
42            }
43
44            if(i+1 < m && !visited[i+1][j]){
45                down = helper(visited, board, word, idx+1, len, i+1, j, m, n);
46                if(down) return true;
47            }
48
49            if(j+1 < n && !visited[i][j+1]){
50                right = helper(visited, board, word, idx+1, len, i, j+1, m, n);
51                if(right) return true;
52            }
53
54            visited[i][j] = false;
55        }
56
57        return false;
58    }
59}