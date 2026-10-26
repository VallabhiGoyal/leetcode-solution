// Last updated: 10/26/2026, 6:08:09 AM
1class Solution {
2    public int countIslands(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int count = 0;
7        boolean temp[][] = new boolean[m][n];
8        for(int i = 0; i<m; i++){
9            for(int j = 0; j<n; j++){
10                if(temp[i][j] || grid[i][j] == 0) continue;
11
12                long sum = 0L;
13                Stack<int[]> stack = new Stack<>();
14                stack.push(new int[]{i, j});
15                temp[i][j] = true;
16
17                while(!stack.isEmpty()){
18                    int[] curr = stack.pop();
19                    int tempi = curr[0];
20                    int tempj = curr[1];
21                    sum += grid[tempi][tempj];
22
23                    if(tempi - 1 >= 0 && !temp[tempi-1][tempj] && grid[tempi-1][tempj] != 0){
24                        temp[tempi-1][tempj] = true;
25                        stack.push(new int[] {tempi-1, tempj});
26                    }
27                    if(tempi + 1 < m && !temp[tempi+1][tempj] && grid[tempi+1][tempj] != 0){
28                        temp[tempi+1][tempj] = true;
29                        stack.push(new int[] {tempi+1, tempj});
30                    }
31                    if(tempj - 1 >= 0 && !temp[tempi][tempj-1] && grid[tempi][tempj-1] != 0){
32                        temp[tempi][tempj-1] = true;
33                        stack.push(new int[] {tempi, tempj-1});
34                    }
35                    if(tempj + 1 < n && !temp[tempi][tempj+1] && grid[tempi][tempj+1] != 0){
36                        temp[tempi][tempj+1] = true;
37                        stack.push(new int[] {tempi, tempj+1});
38                    }
39                }
40                if(sum % k == 0) count++;
41            }
42        }
43
44        return count;
45    }
46}