// Last updated: 4/24/2026, 10:32:45 AM
class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;

        int area = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                area += getArea(grid, i, j);
            }
        }

        return area;
    }

    private int getArea(int[][] grid, int i, int j){
        int area = 0;
        int n = grid.length;
        int height = grid[i][j];

        if(height > 0) area += 2;

        if(i>0) area += Math.max(height - grid[i-1][j], 0);
        else area += height;
                
        if(j>0) area += Math.max(height - grid[i][j-1], 0);
        else area += height;
                
        if (i < n - 1) area += Math.max(height - grid[i + 1][j], 0);
        else area += height;

        if (j < n - 1) area += Math.max(height - grid[i][j + 1], 0);
        else area += height;

        return area;
    }
}