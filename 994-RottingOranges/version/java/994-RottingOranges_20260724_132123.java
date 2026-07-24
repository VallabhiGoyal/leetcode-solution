// Last updated: 7/24/2026, 1:21:23 PM
1class Solution {
2    public int orangesRotting(int[][] grid) {
3 
4        int rows = grid.length;
5        int cols = grid[0].length;
6
7        Queue<int[]> queue = new ArrayDeque<>();
8        int fresh = 0;
9
10        for(int i = 0; i<rows; i++){
11            for(int j = 0; j<cols; j++){
12                if(grid[i][j] == 2){
13                    queue.offer(new int[]{i,j});
14                }else if(grid[i][j] == 1){
15                    fresh++;
16                }
17            }
18        }
19
20        if(fresh == 0) return 0;
21
22        int time = 0;
23        int[][] direction = {{1,0}, {0,-1}, {-1,0}, {0,1}}; 
24
25        while(!queue.isEmpty()){
26            int size = queue.size();
27            boolean rottentime = false;
28
29            for(int i = 0; i<size; i++){
30                int[] cell =queue.poll();
31                int r = cell[0];
32                int c = cell[1];
33
34                for(int[] dir : direction){
35                    int nr = r + dir[0];
36                    int nc = c + dir[1];
37                    if(nr >= 0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] == 1){
38                        grid[nr][nc] = 2;
39                        fresh--;
40                        queue.offer(new int[] {nr,nc});
41                        rottentime = true;
42                    }
43                }
44            }
45            if(rottentime) time++;
46        }
47
48        return fresh == 0 ? time : -1;
49    }
50}