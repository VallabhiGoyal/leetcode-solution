// Last updated: 4/24/2026, 10:30:56 AM
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        if(a == 1 && b == 1) return grid[0][0];

        for(int i = 0; i<a; i++){
            Arrays.sort(grid[i]);
        }

        int answer = 0;
        for(int i = 0; i<b; i++){
            int max = grid[0][i];
            for(int j = 0; j<a; j++){
                if(max<grid[j][i]) max = grid[j][i];
            }
            answer += max;
        }

        return answer;
    }
}