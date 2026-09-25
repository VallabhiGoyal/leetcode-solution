// Last updated: 9/25/2026, 10:16:26 AM
1class Solution {
2    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
3        int n = rowSum.length;
4        int m = colSum.length;
5
6        int[][] ans = new int[n][m];
7
8        int i = 0;
9        int j = 0;
10        while(i < n && j < m){
11            ans[i][j] = Math.min(rowSum[i], colSum[j]);
12            rowSum[i] -= ans[i][j];
13            colSum[j] -=  ans[i][j];
14            
15            if(rowSum[i] == 0) i++;
16            if(colSum[j] == 0) j++;
17        }
18
19        return ans;
20    }
21}