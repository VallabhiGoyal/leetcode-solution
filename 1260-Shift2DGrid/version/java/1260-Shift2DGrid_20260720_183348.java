// Last updated: 7/20/2026, 6:33:48 PM
1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        int a = grid.length;
4        int b = grid[0].length;
5
6        List<Integer> list = new ArrayList<>();
7        for(int i = 0; i<a; i++){
8            for(int j = 0; j<b; j++){
9                list.add(grid[i][j]);
10            }
11        }
12        List<Integer> newList = new ArrayList<>();
13        int size = list.size();
14        k = k % size;
15        newList.addAll(list.subList(size-k, size));
16        newList.addAll(list.subList(0, size-k));
17
18        int n = 0;
19        List<List<Integer>> answer = new ArrayList<>();
20        for(int i = 0; i<a; i++){
21            List<Integer> ans = new ArrayList<>();
22            for(int j = 0; j<b; j++){
23                ans.add(newList.get(n++));
24            }
25            answer.add(ans);
26        }
27
28        return answer;
29    }
30}