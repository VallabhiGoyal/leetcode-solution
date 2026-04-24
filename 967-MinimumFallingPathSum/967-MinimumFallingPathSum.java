// Last updated: 4/24/2026, 10:32:39 AM
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<n; j++){
                int best = matrix[i-1][j];

                if(j > 0){
                    best = Math.min(best, matrix[i-1][j-1]);
                }
                if(j < n-1){
                    best = Math.min(best, matrix[i-1][j+1]);
                }

                matrix[i][j] += best;
            }
        }

        for(int j = 0; j<n; j++){
            ans = Math.min(ans, matrix[n-1][j]);
        }
        return ans;
    }
}