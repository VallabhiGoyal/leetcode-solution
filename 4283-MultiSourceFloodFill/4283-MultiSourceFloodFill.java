// Last updated: 4/24/2026, 10:29:15 AM
class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int k = sources.length;

        Queue<State> queue = new LinkedList<>();
        int[][] time = new int[n][m];
        int[][] grid = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                time[i][j] = (int)1e9;
            }
        }

        Arrays.sort(sources, (a,b) -> b[2]-a[2]);
        for(int i = 0; i<k; i++){
            int row = sources[i][0];
            int col = sources[i][1];
            int color = sources[i][2];

            time[row][col] = 0;
            grid[row][col] = color;
            
            queue.add(new State(row, col, 0, color));
        }

        while(!queue.isEmpty()){
            State s = queue.poll();
            int row = s.row;
            int col = s.col;
            int curr = s.time;
            int color = s.color;

            //Up
            if(row>0){
                int nr = row-1;
                int nc = col;
                
                if(time[nr][nc] > curr + 1){
                    time[nr][nc] = curr + 1;
                    grid[nr][nc] = color;
                    queue.add(new State(nr, nc, curr+1, color));
                }else if(time[nr][nc] == curr +1){
                    grid[nr][nc] = Math.max(color, grid[nr][nc]);
                }
            }

            //right
            if(col<m-1){
                int nr = row;
                int nc = col+1;
                
                if(time[nr][nc] > curr + 1){
                    time[nr][nc] = curr + 1;
                    grid[nr][nc] = color;
                    queue.add(new State(nr, nc, curr+1, color));
                }else if(time[nr][nc] == curr +1){
                    grid[nr][nc] = Math.max(color, grid[nr][nc]);
                }
            }

            //down
            if(row<n-1){
                int nr = row+1;
                int nc = col;
                
                if(time[nr][nc] > curr + 1){
                    time[nr][nc] = curr + 1;
                    grid[nr][nc] = color;
                    queue.add(new State(nr, nc, curr+1, color));
                }else if(time[nr][nc] == curr +1){
                    grid[nr][nc] = Math.max(color, grid[nr][nc]);
                }
            }

            //left
            if(col>0){
                int nr = row;
                int nc = col-1;
                
                if(time[nr][nc] > curr + 1){
                    time[nr][nc] = curr + 1;
                    grid[nr][nc] = color;
                    queue.add(new State(nr, nc, curr+1, color));
                }else if(time[nr][nc] == curr +1){
                    grid[nr][nc] = Math.max(color, grid[nr][nc]);
                }
            }
        }

        return grid;
    }

    class State{
        int row;
        int col;
        int time;
        int color;

        State(int row, int col, int time, int color){
            this.row = row;
            this.col = col;
            this.time = time;
            this.color = color;
        }
    }
}