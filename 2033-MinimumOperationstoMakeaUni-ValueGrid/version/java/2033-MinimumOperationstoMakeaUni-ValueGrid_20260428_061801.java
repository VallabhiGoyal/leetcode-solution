// Last updated: 4/28/2026, 6:18:01 AM
/*
 * Approach (short)
 *     Flatten grid → 1D list
 *     Check all values have same mod x
 *     Sort list → pick median
 *     Sum operations: |value - median| / x
 * 
 * Time Complexity
 *     O(m*nlog(m*n))
 *     Flatten → O(m*n)
 *     Sort → O(mn log(mn))
 * Space Complexity
 *     O(m*n)
*/

1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        List<Integer> list = new ArrayList<>();
7        
8        int remain = grid[0][0] % x;
9        for(int i = 0; i<m; i++){
10            for(int j = 0; j<n; j++){
11                if(grid[i][j] % x != remain) return -1;
12                list.add(grid[i][j]);
13            }
14        }
15
16        Collections.sort(list);
17
18        int target = list.get(list.size()/2);
19
20        int count = 0;
21        for(int i = 0; i<list.size(); i++){
22            count += Math.abs(target - list.get(i))/x;
23        }
24
25        return count;
26    }
27}