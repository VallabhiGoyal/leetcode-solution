// Last updated: 7/16/2026, 7:52:45 AM
1class Solution {
2    public void rotate(int[][] matrix) {
3        
4        int n = matrix.length;
5
6        //transpose matrix
7        for(int i = 0; i<n; i++){
8            for(int j = i+1; j<n; j++){
9                int temp = matrix[i][j];
10                matrix[i][j] = matrix[j][i];
11                matrix[j][i] = temp;
12            }
13        }
14
15        //reverse each row
16        for(int i = 0; i<n; i++){
17            for(int j = 0; j<n/2; j++){
18                int temp = matrix[i][j];
19                matrix[i][j] = matrix[i][n-j-1];
20                matrix[i][n-j-1] = temp;
21            }
22        }
23    }
24
25}