// Last updated: 4/24/2026, 10:31:39 AM
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        if(n==1) return mat[0][0];
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += mat[i][i] + mat[i][n-i-1];
        }
        if(n%2==0) return sum;
        return sum - mat[n/2][n/2];
    }
}