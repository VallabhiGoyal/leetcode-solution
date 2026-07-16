// Last updated: 7/16/2026, 7:52:33 AM
1import java.util.ArrayList;
2class Solution {
3    public List<Integer> spiralOrder(int[][] matrix) {
4        List<Integer> list = new ArrayList<>();
5        if (matrix.length == 0)
6            return list;
7        spiralPrint(matrix, 0, matrix.length, 0, matrix[0].length, list);
8        return list;
9    }
10
11    private void spiralPrint(int[][] matrix, int row_min, int row_max, int col_min, int col_max, List<Integer> list) {
12
13        if (row_min >= row_max || col_min >= col_max) {
14            return;
15        }
16
17        for (int j = col_min; j < col_max; j++) {
18            list.add(matrix[row_min][j]);
19        }
20
21        for (int i = row_min + 1; i < row_max; i++) {
22            list.add(matrix[i][col_max - 1]);
23        }
24
25        if (row_min < row_max - 1) {
26            for (int j = col_max - 2; j >= col_min; j--) {
27                list.add(matrix[row_max - 1][j]);
28            }
29        }
30
31        if (col_min < col_max - 1) {
32            for (int i = row_max - 2; i > row_min; i--) {
33                list.add(matrix[i][col_min]);
34            }
35        }
36        spiralPrint(matrix, row_min + 1, row_max - 1, col_min + 1, col_max - 1, list);
37    }
38}