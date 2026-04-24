// Last updated: 4/24/2026, 10:30:34 AM
class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                if(i+1<a){
                    if(grid[i][j] != grid[i+1][j]) return false;
                }
                if(j+1<b){
                    if(grid[i][j] == grid[i][j+1]) return false;
                }
            }
        }

        return true;
    }
}