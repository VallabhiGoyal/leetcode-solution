// Last updated: 4/24/2026, 10:32:06 AM
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int a = grid.length;
        int b = grid[0].length;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                list.add(grid[i][j]);
            }
        }
        List<Integer> newList = new ArrayList<>();
        int size = list.size();
        k = k % size;
        newList.addAll(list.subList(size-k, size));
        newList.addAll(list.subList(0, size-k));

        int n = 0;
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i<a; i++){
            List<Integer> ans = new ArrayList<>();
            for(int j = 0; j<b; j++){
                ans.add(newList.get(n++));
            }
            answer.add(ans);
        }

        return answer;
    }
}