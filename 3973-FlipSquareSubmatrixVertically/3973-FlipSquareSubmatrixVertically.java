// Last updated: 4/24/2026, 10:30:23 AM
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int a = grid.length;
        int b = grid[0].length;
        
        for(int j = y; j<y+k; j++){
            for(int i = 0; i<(k+1)/2; i++){
                int temp = grid[x+i][j];
                grid[x+i][j] = grid[x+k-i-1][j];
                grid[x+k-i-1][j] = temp;
            }
        }
         
        return grid;
    }
}