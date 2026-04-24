// Last updated: 4/24/2026, 10:31:09 AM
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i<n; i++){
            int[] row = new int[n+1];
            int[] col = new int[n+1];
            for(int j = 0; j<n; j++){
                row[matrix[i][j]]++;
                col[matrix[j][i]]++;
            }
            for(int j = 1; j<n+1; j++){
                if(row[j] != 1 || col[j] != 1) return false;
            }
        }

        return true;

    }
}