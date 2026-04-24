// Last updated: 4/24/2026, 10:30:36 AM
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;

        int[][] answer = new int[a][b];

        int[] col = new int[b];
        for(int j = 0; j<b; j++){
            int max = matrix[0][j];
            for(int i = 0; i<a; i++){
                max = Math.max(max, matrix[i][j]);
            }
            col[j] = max;
        }

        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                if(matrix[i][j] == -1) answer[i][j] = col[j];
                else answer[i][j] = matrix[i][j];
            }
        }

        return answer;
    }
}