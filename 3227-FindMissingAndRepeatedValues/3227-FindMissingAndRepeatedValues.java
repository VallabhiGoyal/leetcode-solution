// Last updated: 4/24/2026, 10:30:38 AM
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n =  grid.length;

        int total = n*n;
        int[] count = new int[total + 1];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                count[grid[i][j]]++;
            }
        }

        int[] ans = new int[2];
        for(int i = 1; i<=total; i++){
            if(count[i] == 2) ans[0] = i;
            else if(count[i] == 0) ans[1] = i;
        }

        return ans;
    }
}