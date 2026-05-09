// Last updated: 5/9/2026, 2:23:54 PM
1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3
4        int m = grid.length;
5        int n = grid[0].length;
6
7        int totalCycles = Math.min(m, n) / 2;
8
9        for (int layer = 0; layer < totalCycles; layer++) {
10
11            int top = layer;
12            int left = layer;
13            int bottom = m - layer - 1;
14            int right = n - layer - 1;
15
16            List<Integer> list = new ArrayList<>();
17
18            for (int j = left; j <= right; j++) {
19                list.add(grid[top][j]);
20            }
21
22            for (int i = top + 1; i <= bottom; i++) {
23                list.add(grid[i][right]);
24            }
25
26            for (int j = right - 1; j >= left; j--) {
27                list.add(grid[bottom][j]);
28            }
29
30            for (int i = bottom - 1; i > top; i--) {
31                list.add(grid[i][left]);
32            }
33
34            int size = list.size();
35            int rot = k % size;
36
37            List<Integer> rotated = new ArrayList<>();
38
39            for (int i = 0; i < size; i++) {
40                rotated.add(list.get((i + rot) % size));
41            }
42
43            int idx = 0;
44
45            for (int j = left; j <= right; j++) {
46                grid[top][j] = rotated.get(idx++);
47            }
48
49            for (int i = top + 1; i <= bottom; i++) {
50                grid[i][right] = rotated.get(idx++);
51            }
52
53            for (int j = right - 1; j >= left; j--) {
54                grid[bottom][j] = rotated.get(idx++);
55            }
56
57            for (int i = bottom - 1; i > top; i--) {
58                grid[i][left] = rotated.get(idx++);
59            }
60        }
61
62        return grid;
63    }
64}