// Last updated: 7/3/2026, 11:37:48 AM
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    if(dfs(grid, visited, i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int pr, int pc){
        visited[row][col] = true;
        char ch = grid[row][col];

        for(int[] d : dirs){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if(grid[nr][nc] != ch) continue;

            if(!visited[nr][nc]){
                if(dfs(grid, visited, nr, nc, row, col)) return true;
            } else if(!(nr == pr && nc == pc)){
                return true;
            }
        }
        return false;
    }
}