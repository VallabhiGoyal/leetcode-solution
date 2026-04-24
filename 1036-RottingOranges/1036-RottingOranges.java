// Last updated: 4/24/2026, 10:32:28 AM
class Solution {
    public int orangesRotting(int[][] grid) {
 
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int time = 0;
        int[][] direction = {{1,0}, {0,-1}, {-1,0}, {0,1}}; 

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottentime = false;

            for(int i = 0; i<size; i++){
                int[] cell =queue.poll();
                int r = cell[0];
                int c = cell[1];

                for(int[] dir : direction){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[] {nr,nc});
                        rottentime = true;
                    }
                }
            }
            if(rottentime) time++;
        }

        return fresh == 0 ? time : -1;
    }
}