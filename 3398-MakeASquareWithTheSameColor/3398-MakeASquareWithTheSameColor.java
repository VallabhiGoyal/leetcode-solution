// Last updated: 4/24/2026, 10:30:35 AM
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                int black = 0;
                int white = 0;

                if(grid[i][j] == 'W') white++;
                else black++;

                if(grid[i+1][j] == 'W') white++;
                else black++;

                if(grid[i][j+1] == 'W') white++;
                else black++;

                if(grid[i+1][j+1] == 'W') white++;
                else black++;

                if(white >= 3 || black >= 3) return true;
            }
        }

        return false;
    }
}