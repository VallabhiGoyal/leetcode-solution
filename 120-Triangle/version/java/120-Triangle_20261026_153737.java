// Last updated: 10/26/2026, 3:37:37 PM
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n = triangle.size();
4
5        int[] dp = new int[n];
6        for (int i = 0; i < n; i++) {
7            dp[i] = triangle.get(n - 1).get(i);
8        }
9
10        if (n > 1) {
11            solver(triangle, dp, n-2, 0);
12        }
13
14        return dp[0];
15    }
16
17    public int solver(List<List<Integer>> list, int[] dp, int i, int j) {
18        if (i < 0) return 0;
19
20        if (j > i) {
21            return solver(list, dp, i - 1, 0);
22        }
23
24        int one = dp[j];
25        int two = dp[j + 1];
26
27        dp[j] = list.get(i).get(j) + Math.min(one, two);
28
29        solver(list, dp, i, j + 1);
30
31        return dp[j];
32    }
33}