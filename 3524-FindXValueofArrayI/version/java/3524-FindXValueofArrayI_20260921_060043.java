// Last updated: 9/21/2026, 6:00:43 AM
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        int n = nums.length;
4
5        long[] ans = new long[k];
6        long[] dp = new long[k];
7
8        for (int i = 0; i < n; i++) {
9            long[] next = new long[k];
10
11            int rem = nums[i] % k;
12            next[rem]++;
13
14            for (int r = 0; r < k; r++) {
15                int newRem = (r * rem) % k;
16                next[newRem] += dp[r];
17            }
18
19            for (int r = 0; r < k; r++) {
20                ans[r] += next[r];
21            }
22
23            dp = next;
24        }
25
26        return ans;
27    }
28}