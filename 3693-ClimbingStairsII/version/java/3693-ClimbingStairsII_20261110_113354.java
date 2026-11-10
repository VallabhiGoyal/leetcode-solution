// Last updated: 11/10/2026, 11:33:54 AM
1class Solution {
2    public int climbStairs(int n, int[] costs) {
3        int one = costs[0] + 1;
4        int two = Integer.MAX_VALUE;
5        int three = Integer.MAX_VALUE;
6
7        if (n > 1) {
8            two = costs[1] + Math.min( 4, one + 1);
9        }
10
11        if (n > 2) {
12            three = costs[2] + Math.min( 9, Math.min(one + 4, two + 1));
13        }
14
15        for (int i = 3; i < n; i++) {
16            int temp = costs[i];
17
18            temp += Math.min(
19                one + 9,
20                Math.min(two + 4, three + 1)
21            );
22
23            one = two;
24            two = three;
25            three = temp;
26        }
27
28        return n == 1 ? one : n == 2 ? two : three;
29    }
30}