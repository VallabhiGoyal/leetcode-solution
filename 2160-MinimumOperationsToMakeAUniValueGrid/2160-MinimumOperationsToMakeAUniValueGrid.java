// Last updated: 7/3/2026, 11:37:25 AM
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> list = new ArrayList<>();
        
        int remain = grid[0][0] % x;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] % x != remain) return -1;
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);

        int target = list.get(list.size()/2);

        int count = 0;
        for(int i = 0; i<list.size(); i++){
            count += Math.abs(target - list.get(i))/x;
        }

        return count;
    }
}