// Last updated: 4/24/2026, 10:33:36 AM
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] reshape = new int[r][c];

        int m = mat.length;
        int n = mat[0].length;

        if(m *n != r*c) return mat;

        int row = 0;
        int col = 0;

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                reshape[i][j] = mat[row][col];
                col++;
                if(col == n){
                    col = 0;
                    row++;
                }
            }
        }

        return reshape;
    }
}