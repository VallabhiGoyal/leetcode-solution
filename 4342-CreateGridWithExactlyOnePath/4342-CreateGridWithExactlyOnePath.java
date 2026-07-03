// Last updated: 7/3/2026, 11:34:37 AM
class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j<n){
            sb.append('.');
            j++;
        }
        grid[0] = sb.toString();

        StringBuilder sb2 = new StringBuilder();
        j = 1;
        while(j<n){
            sb2.append('#');
            j++;
        }
        sb2.append('.');
        
        for(int i = 1; i<m; i++){
            grid[i] = sb2.toString();
        }

        return grid;
    }
}