// Last updated: 7/3/2026, 11:36:54 AM
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;

        int[][] dist = new int[n][n];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
                if(grid.get(i).get(j) == 1){
                    dist[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if(x > 0 && dist[x - 1][y] == Integer.MAX_VALUE){
                dist[x - 1][y] = dist[x][y] + 1;
                queue.add(new int[]{ x - 1, y});
            }

            if(y > 0 && dist[x][y - 1] == Integer.MAX_VALUE){
                dist[x][y - 1] = dist[x][y] + 1;
                queue.add(new int[]{ x, y - 1});
            }

            if(x < n-1 && dist[x + 1][y] == Integer.MAX_VALUE){
                dist[x + 1][y] = dist[x][y] + 1;
                queue.add(new int[]{ x + 1, y});
            }

            if(y < n-1 && dist[x][y + 1] == Integer.MAX_VALUE){
                dist[x][y + 1] = dist[x][y] + 1;
                queue.add(new int[]{ x, y + 1});
            }
        }

        int[][] best = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], -1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        q.offer(new int[]{0, 0, dist[0][0]});
        best[0][0] = dist[0][0];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];

            if (x == n - 1 && y == n - 1) return d;

            if(x > 0 ){
                int newSafe = Math.min(d, dist[x - 1][y]);
                if (newSafe > best[x - 1][y]) {
                    best[x - 1][y] = newSafe;
                    q.offer(new int[] { x - 1, y, newSafe});
                }
            }

            if(y > 0){
                int newSafe = Math.min(d, dist[x][y-1]);
                if (newSafe > best[x][y-1]) {
                    best[x][y-1] = newSafe;
                    q.offer(new int[] { x, y-1, newSafe});
                }
            }

            if(x < n-1 ){
                int newSafe = Math.min(d, dist[x + 1][y]);
                if (newSafe > best[x + 1][y]) {
                    best[x + 1][y] = newSafe;
                    q.offer(new int[] { x + 1, y, newSafe});
                }
            }

            if(y < n-1){
                int newSafe = Math.min(d, dist[x][y + 1]);
                if (newSafe > best[x][y + 1]) {
                    best[x][y + 1] = newSafe;
                    q.offer(new int[] { x, y + 1, newSafe});
                }
            }
        }

        return 0;
    }
}