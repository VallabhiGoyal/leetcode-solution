// Last updated: 4/24/2026, 10:34:44 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a = matrix.length;
        int b = matrix[0].length;

        int row = 0;
        int col = b-1;
        
        while(row<a && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }

        return false;
    }
}