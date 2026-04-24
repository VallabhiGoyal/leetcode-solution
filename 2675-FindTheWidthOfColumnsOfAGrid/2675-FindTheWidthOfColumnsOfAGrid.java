// Last updated: 4/24/2026, 10:30:54 AM
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        int[] ans = new int[b];

        for(int i = 0; i<b; i++){
            int len = 0; 
            for(int j = 0; j<a; j++){
                String str2 = grid[j][i] + "";
                len = Math.max(len, str2.length());
            }
            ans[i] = len;
        }

        return ans;
    }
}