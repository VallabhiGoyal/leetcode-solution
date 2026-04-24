// Last updated: 4/24/2026, 10:31:16 AM
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n) return new int[0][];
        int[][] answer = new int[m][n];

        int k = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                answer[i][j] = original[k++];
            }
        }
        return answer;
    }
}