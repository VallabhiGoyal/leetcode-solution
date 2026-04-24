// Last updated: 4/24/2026, 10:30:50 AM
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int a = mat.length;
        int b = mat[0].length;
        int maxIdx = 0;
        int maxSum = 0;
        for(int  i = 0; i<a; i++){
            int sum = 0;
            for(int j = 0; j<b; j++){
                sum += mat[i][j];
            }
            if(maxSum < sum){
                maxSum = sum;
                maxIdx = i;
            }
        }

        return new int[]{maxIdx, maxSum};
    }
}