// Last updated: 4/24/2026, 10:31:02 AM
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        int count = 0;

        Map<List<Integer>, Integer> map = new HashMap<>();

        //rows
        for(int i = 0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<n; j++){
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        //cols
        for(int i = 0; i<n; i++){
            List<Integer> col = new ArrayList<>();
            for(int j = 0; j<n; j++){
                col.add(grid[j][i]);
            }
            if(map.containsKey(col)) count+= map.get(col);
        }

        return count;
    }
}