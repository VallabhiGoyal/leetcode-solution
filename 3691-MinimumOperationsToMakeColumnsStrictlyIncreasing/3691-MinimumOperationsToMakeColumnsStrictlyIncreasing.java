// Last updated: 4/24/2026, 10:30:28 AM
class Solution {
    public int minimumOperations(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        int count = 0;
        for(int j = 0; j<b; j++){
            for(int i = 1; i<a; i++){
                if(grid[i-1][j] >= grid[i][j]){
                    count += grid[i-1][j] - grid[i][j] + 1;
                    grid[i][j] = grid[i-1][j] + 1;
                }
            }
        }

        return count;
    }
}