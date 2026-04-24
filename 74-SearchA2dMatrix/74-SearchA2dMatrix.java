// Last updated: 4/24/2026, 10:36:25 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(target < matrix[0][0] || target>matrix[row-1][col-1]) return false;
        
        for(int i = 0; i< row; i++){
            if(target >= matrix[i][0] && target <= matrix [i][col-1]){
                int start = 0;
                int end = col-1;

                while(start<=end){
                    int mid = start + (end - start)/2;

                    if(matrix[i][mid] == target) return true;
                    else if(matrix[i][mid] < target){
                        start = mid + 1;
                    }else{
                        end = mid-1;
                    }
                }
            }
        }

        return false;
    }
}