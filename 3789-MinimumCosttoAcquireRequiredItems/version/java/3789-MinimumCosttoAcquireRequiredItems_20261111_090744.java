// Last updated: 11/11/2026, 9:07:44 AM
1class Solution {
2    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
3        long totalCost = 0;
4
5        if (cost1 + cost2 <= costBoth) {
6            totalCost = 1L * cost1 * need1 + 1L * cost2 * need2;
7        } else {
8            int cnt = Math.min(need1, need2);
9            totalCost = 1L * cnt * costBoth;
10
11            need1 -= cnt;
12            need2 -= cnt;
13
14            if (need1 > 0) {
15                totalCost += 1L * need1 * Math.min(cost1, costBoth);
16            } else if (need2 > 0) {
17                totalCost += 1L * need2 * Math.min(cost2, costBoth);
18            }
19        }
20
21        return totalCost;
22    }
23}