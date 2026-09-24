// Last updated: 9/24/2026, 11:22:13 AM
1class Solution {
2    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
3        int n = rowSum.length;
4        int m = colSum.length;
5
6        int[][] ans = new int[n][m];
7
8        for(int i = 0; i<n; i++){
9            for(int j = 0; j<m; j++){
10                ans[i][j] = Math.min(rowSum[i], colSum[j]);
11                rowSum[i] -= ans[i][j];
12                colSum[j] -=  ans[i][j];
13            }
14        }
15
16        return ans;
17    }
18}