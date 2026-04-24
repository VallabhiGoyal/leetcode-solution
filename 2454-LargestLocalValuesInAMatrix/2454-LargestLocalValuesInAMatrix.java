// Last updated: 4/24/2026, 10:31:00 AM
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] maxLocal = new int[n-2][n-2];

        for(int i = 0; i<n-2; i++){
            for(int j = 0; j<n-2; j++){
                int max = grid[i][j];
                for(int a = i; a<i+3; a++){
                    for(int b = j; b<j+3; b++){
                        max = Math.max(max, grid[a][b]);
                    }
                }
                maxLocal[i][j] = max;
            }
        }

        return maxLocal;
    }
}