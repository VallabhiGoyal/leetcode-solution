// Last updated: 7/3/2026, 11:37:31 AM
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] best = new int[m][n];
        for(int[] row : best){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        best[entrance[0]][entrance[1]] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ entrance[0], entrance[1], 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            if(x > 0 && maze[x - 1][y] == '.' && best[x - 1][y] > steps + 1){
                int nx = x - 1;
                int ny = y;
                if(nx == 0 || ny == 0 || nx == m-1 || ny == n-1) return steps + 1;
                queue.add(new int[]{ nx, ny, steps + 1});
                best[nx][ny] = steps + 1;
            }

            if(y > 0 && maze[x][y - 1] == '.' && best[x][y - 1] > steps + 1){
                int nx = x;
                int ny = y - 1;
                if(nx == 0 || ny == 0 || nx == m-1 || ny == n-1) return steps + 1;
                queue.add(new int[]{ nx, ny, steps + 1});
                best[nx][ny] = steps + 1;
            }

            if(x < m - 1 && maze[x + 1][y] == '.' && best[x + 1][y] > steps + 1){
                int nx = x + 1;
                int ny = y;
                if(nx == 0 || ny == 0 || nx == m-1 || ny == n-1) return steps + 1;
                queue.add(new int[]{ nx, ny, steps + 1});
                best[nx][ny] = steps + 1;
            }

            if(y < n - 1 && maze[x][y + 1] == '.' && best[x][y + 1] > steps + 1){
                int nx = x;
                int ny = y + 1;
                if(nx == 0 || ny == 0 || nx == m-1 || ny == n-1) return steps + 1;
                queue.add(new int[]{ nx, ny, steps + 1});
                best[nx][ny] = steps + 1;
            }
        }

        return -1;
    }
}