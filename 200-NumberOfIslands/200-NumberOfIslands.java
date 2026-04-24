// Last updated: 4/24/2026, 10:35:11 AM
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(!visit[i][j] && grid[i][j] == '1'){
                    dfs(grid, i, j, visit);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visit){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0' || visit[row][col]){
            return;
        }
        

        visit[row][col] = true;
        dfs(grid, row+1, col, visit);
        dfs(grid, row, col-1, visit);
        dfs(grid, row-1, col, visit);
        dfs(grid, row, col+1, visit);

    }
}