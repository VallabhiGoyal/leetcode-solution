// Last updated: 9/17/2026, 5:55:42 AM
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int[] dp = new int[n];
5
6        Arrays.fill(dp, Integer.MAX_VALUE);
7
8        int sum = 0;
9        int minLen = Integer.MAX_VALUE;
10        int ans = Integer.MAX_VALUE;
11
12        int j = 0;
13        for (int i = 0; i < n; i++) {
14            sum += arr[i];
15
16            while (sum > target) {
17                sum -= arr[j];
18                j++;
19            }
20
21            if (sum == target) {
22                int len = i - j + 1;
23
24                if (j > 0 && dp[j - 1] != Integer.MAX_VALUE) {
25                    ans = Math.min(ans, len + dp[j - 1]);
26                }
27
28                minLen = Math.min(minLen, len);
29            }
30
31            dp[i] = minLen;
32        }
33
34        return ans == Integer.MAX_VALUE ? -1 : ans;
35    }
36}