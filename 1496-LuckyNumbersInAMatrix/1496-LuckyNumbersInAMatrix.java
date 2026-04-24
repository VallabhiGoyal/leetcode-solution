// Last updated: 4/24/2026, 10:31:53 AM
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<a; i++){
            int min = matrix[i][0];
            int col = 0;
            for(int j = 0; j<b; j++){
                if(min>matrix[i][j]){
                    min = matrix[i][j];
                    col = j;
                }
            }
            
            boolean isLucky = true;

            for(int k = 0; k<a; k++){
                if(matrix[k][col] > matrix[i][col]){
                    isLucky = false;
                    break;
                }
            }
            if(isLucky) list.add(matrix[i][col]);
        }

        return list;
    }
}