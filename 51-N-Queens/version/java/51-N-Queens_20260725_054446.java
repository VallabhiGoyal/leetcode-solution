// Last updated: 7/25/2026, 5:44:46 AM
1class Solution {
2    public List<List<String>> solveNQueens(int n) {
3        List<List<String>> list = new ArrayList<>();
4
5        boolean[][] board = new boolean[n][n];
6        for(int i = 0; i<n; i++){
7            for(int j = 0; j<n; j++){
8                board[i][j] = true;
9            }
10        }
11
12        helper(list, n, 0, board);
13
14        return list;
15    }
16
17    public void helper(List<List<String>> list, int n, int row, boolean[][] board){
18        if(row == n){
19            List<String> temp = new ArrayList<>();
20
21            for(int i = 0; i<n; i++){
22                StringBuilder sb = new StringBuilder();
23                for(int j = 0; j<n; j++){
24                    if(board[i][j]){
25                        sb.append(".");
26                    }else{
27                        sb.append("Q");
28                    }
29                }
30
31                temp.add(sb.toString());
32            }
33            list.add(temp);
34            return;
35        }
36
37        for(int i = 0; i<n; i++){
38            if(isSafe(board, row, i, n)){
39                board[row][i] = false;
40                helper(list, n, row+1, board);
41                board[row][i] = true;
42            }
43        }
44    }
45
46    public boolean isSafe(boolean[][] board, int row, int col, int n){
47        for(int i = 0; i<n; i++){
48            if(!board[i][col] || !board[row][i]) return false; 
49
50            if(row - i >= 0 && col + i < n && !board[row - i][col + i]) return false;
51
52            if(row - i >= 0 && col - i >= 0 && !board[row - i][col - i]) return false;
53        }
54
55        return true;
56    }
57}