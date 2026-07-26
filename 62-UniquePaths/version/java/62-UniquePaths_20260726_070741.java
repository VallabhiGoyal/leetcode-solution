// Last updated: 7/26/2026, 7:07:41 AM
1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[] t = new int[n];
4
5        for(int i = 0; i<n; i++){
6            t[i] = 1;
7        }
8
9        for(int i = 1; i<m; i++){
10            for(int j = 1; j<n; j++){
11                t[j] += t[j-1];
12            }
13        }
14
15        return t[n-1];
16    }
17}