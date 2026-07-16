// Last updated: 7/16/2026, 7:51:25 AM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int a = matrix.length;
4        int b = matrix[0].length;
5
6        int row = 0;
7        int col = b-1;
8        
9        while(row<a && col >= 0){
10            if(matrix[row][col] == target) return true;
11            else if(matrix[row][col] > target) col--;
12            else row++;
13        }
14
15        return false;
16    }
17}