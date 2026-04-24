// Last updated: 4/24/2026, 10:36:37 AM
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        spiral(result, 0, n, 0, n, 1);
        return result;
    }

    private void spiral(int[][] result, int row_min, int row_max, int col_min, int col_max, int k){
        if(row_min >= row_max || col_min >= col_max) return;

        for(int j = col_min; j<col_max; j++){
            result[row_min][j] = k++;
        }

        for(int i = row_min + 1; i<row_max; i++){
            result[i][col_max-1] = k++;
        }

        if(row_min < row_max - 1){
            for(int j = col_max-2; j>=col_min; j--){
                result[row_max-1][j] = k++;;
            }
        }

        if(col_min < col_max -1){
            for(int i = row_max-2; i>=row_min+1; i--){
                result[i][col_min] = k++;
            }
        }
        spiral(result, row_min +1, row_max-1, col_min +1, col_max-1, k);
    }
}