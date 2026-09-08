// Last updated: 9/8/2026, 5:48:02 AM
1class Solution {
2    public int totalNQueens(int n) {
3        return backtrack(0, 0, 0, 0, n);
4    }
5    
6    private int backtrack(int row, int cols, int diags1, int diags2, int n) {
7        if (row == n) {
8            return 1;
9        }
10        
11        int count = 0;
12        int availablePositions = ((1 << n) - 1) & ~(cols | diags1 | diags2);
13        
14        while (availablePositions != 0) {
15            int p = availablePositions & -availablePositions;
16            availablePositions -= p;
17            count += backtrack(row + 1, cols | p, (diags1 | p) << 1, (diags2 | p) >> 1, n);
18        }
19        
20        return count;
21    }
22}