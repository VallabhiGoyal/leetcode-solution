// Last updated: 4/24/2026, 10:30:42 AM
class Solution {
    public int findChampion(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        int[] row = new int[a];

        int maxIdx = 0;
        int max = 0;
        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                row[i] += grid[i][j];
            }
            if(max<row[i]){
                max = row[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}