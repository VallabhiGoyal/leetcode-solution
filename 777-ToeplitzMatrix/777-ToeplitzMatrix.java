// Last updated: 4/24/2026, 10:33:04 AM
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        for(int i = 1; i<a; i++){
            for(int j = 1; j<b; j++){
                if(i>0 && j>0 && matrix[i][j] != matrix[i-1][j-1]) return false;  
            }
        }

        return true;
    }
}