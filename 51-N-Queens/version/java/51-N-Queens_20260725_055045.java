// Last updated: 7/25/2026, 5:50:45 AM
1class Solution {
2    public List<List<String>> solveNQueens(int n) {
3        List<List<String>> list = new ArrayList<>();
4
5        boolean[][] board = new boolean[n][n];
6
7        helper(list, n, 0, board);
8
9        return list;
10    }
11
12    public void helper(List<List<String>> list, int n, int row, boolean[][] board){
13        if(row == n){
14            List<String> temp = new ArrayList<>();
15
16            for(int i = 0; i<n; i++){
17                StringBuilder sb = new StringBuilder();
18                for(int j = 0; j<n; j++){
19                    if(!board[i][j]){
20                        sb.append(".");
21                    }else{
22                        sb.append("Q");
23                    }
24                }
25
26                temp.add(sb.toString());
27            }
28            list.add(temp);
29            return;
30        }
31
32        for(int i = 0; i<n; i++){
33            if(isSafe(board, row, i, n)){
34                board[row][i] = true;
35                helper(list, n, row+1, board);
36                board[row][i] = false;
37            }
38        }
39    }
40
41    public boolean isSafe(boolean[][] board, int row, int col, int n){
42        
43        for (int i = 0; i < row; i++) {
44            if (board[i][col]) return false;
45        }
46
47        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
48            if (board[i][j]) return false;
49        }
50
51        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
52            if (board[i][j]) return false;
53        }
54
55        return true;
56    }
57}