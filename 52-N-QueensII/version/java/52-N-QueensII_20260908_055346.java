// Last updated: 9/8/2026, 5:53:46 AM
1class Solution {
2    public int totalNQueens(int n) {
3        boolean[][] board = new boolean[n][n];
4        return helper(0, n, board);
5    }
6
7    public int helper(int row, int n, boolean[][] board) {
8        if (row == n) {
9            return 1;
10        }
11
12        int count = 0;
13
14        for (int col = 0; col < n; col++) {
15            if (isSafe(board, row, col, n)) {
16                board[row][col] = true;
17                count += helper(row + 1, n, board);
18                board[row][col] = false;
19            }
20        }
21
22        return count;
23    }
24
25    public boolean isSafe(boolean[][] board, int row, int col, int n) {
26        for (int i = 0; i < row; i++) {
27            if (board[i][col]) {
28                return false;
29            }
30        }
31
32        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
33            if (board[i][j]) {
34                return false;
35            }
36        }
37
38        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
39            if (board[i][j]) {
40                return false;
41            }
42        }
43
44        return true;
45    }
46}