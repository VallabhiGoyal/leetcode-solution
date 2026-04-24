// Last updated: 4/24/2026, 10:31:55 AM
class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols= grid[0].length;

        int i = rows-1;
        int j = 0;
        int count = 0;

        while(i>=0 && j<cols){
            if(grid[i][j] < 0){
                count += cols - j;
                i--;
            }else j++;
        }

        return count;
    }
}