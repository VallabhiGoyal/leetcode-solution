// Last updated: 4/24/2026, 10:30:32 AM
class NeighborSum {

    int[][] grid;
    int n;
    int[][] map;
    
    public NeighborSum(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        map = new int[n*n][2];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int curr = grid[i][j];
                map[curr][0] = i;
                map[curr][1] = j;
            }
        }
    }
    
    public int adjacentSum(int value) {
        int row = map[value][0];
        int col = map[value][1];

        int sum = 0;
        if(row>0){
            sum += grid[row-1][col];
        }
        if(row<n-1){
            sum += grid[row+1][col];
        }
        if(col>0){
            sum += grid[row][col-1];
        }
        if(col<n-1){
            sum += grid[row][col+1];
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int row = map[value][0];
        int col = map[value][1];

        int sum = 0;
        if(row>0 && col>0){
            sum += grid[row-1][col-1];
        }
        if(row<n-1 && col<n-1){
            sum += grid[row+1][col+1];
        }
        if(col<n-1 && row>0){
            sum += grid[row-1][col+1];
        }
        if(col>0 && row<n-1){
            sum += grid[row+1][col-1];
        }
        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */