// Last updated: 7/3/2026, 11:36:36 AM
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        for(int[] row : best){
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        if(grid.get(0).get(0) == 0){
            queue.add(new int[]{ 0, 0, health});
            best[0][0] = health;
        }else{
            if(health <= 1) return false;
            queue.add(new int[]{ 0, 0, health-1});
            best[0][0] = health-1;
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int h = curr[2];

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            if(x > 0){
                int newHealth = h - grid.get(x - 1).get(y);
                if(best[x - 1][y] < newHealth && newHealth >= 1){
                    queue.add(new int[]{ x - 1, y, h - grid.get(x - 1).get(y)});
                    best[x - 1][y] = newHealth;
                }
            }

            if(y > 0){
                int newHealth = h - grid.get(x).get(y - 1);
                if(best[x][y - 1] < newHealth && newHealth >= 1){
                    queue.add(new int[]{ x, y - 1, newHealth});
                    best[x][y - 1] = newHealth;
                }
            }

            if(x < m - 1){
                int newHealth = h - grid.get(x + 1).get(y);
                if(best[x + 1][y] < newHealth && newHealth >= 1){
                    queue.add(new int[]{ x + 1, y, newHealth});
                    best[x + 1][y] = newHealth;
                }
            }

            if(y < n - 1){
                int newHealth = h - grid.get(x).get(y + 1);
                if(best[x][y + 1] < newHealth && newHealth >= 1){
                    queue.add(new int[]{ x, y + 1, newHealth});
                    best[x][y + 1] = newHealth;
                }
            }
        }

        return best[m-1][n-1] >= 1;
    }
}