// Last updated: 4/24/2026, 10:36:42 AM
import java.util.ArrayList;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return list;
        spiralPrint(matrix, 0, matrix.length, 0, matrix[0].length, list);
        return list;
    }

    private void spiralPrint(int[][] matrix, int row_min, int row_max, int col_min, int col_max, List<Integer> list) {

        if (row_min >= row_max || col_min >= col_max) {
            return;
        }

        for (int j = col_min; j < col_max; j++) {
            list.add(matrix[row_min][j]);
        }

        for (int i = row_min + 1; i < row_max; i++) {
            list.add(matrix[i][col_max - 1]);
        }

        if (row_min < row_max - 1) {
            for (int j = col_max - 2; j >= col_min; j--) {
                list.add(matrix[row_max - 1][j]);
            }
        }

        if (col_min < col_max - 1) {
            for (int i = row_max - 2; i > row_min; i--) {
                list.add(matrix[i][col_min]);
            }
        }
        spiralPrint(matrix, row_min + 1, row_max - 1, col_min + 1, col_max - 1, list);
    }
}