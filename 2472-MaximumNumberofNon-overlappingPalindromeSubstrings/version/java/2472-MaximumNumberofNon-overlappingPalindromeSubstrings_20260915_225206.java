// Last updated: 9/15/2026, 10:52:06 PM
1class Solution {
2    public int maxPalindromes(String s, int k) {
3        int n = s.length();
4
5        boolean[][] dp = new boolean[n][n];
6
7        for (int i = n - 1; i >= 0; i--) {
8            for (int j = i; j < n; j++) {
9                if (s.charAt(i) == s.charAt(j) &&
10                    (j - i <= 2 || dp[i + 1][j - 1])) {
11                    dp[i][j] = true;
12                }
13            }
14        }
15
16        int[] ans = new int[n + 1];
17
18        for (int i = 1; i <= n; i++) {
19            ans[i] = ans[i - 1];
20
21            for (int j = 0; j <= i - k; j++) {
22                if (dp[j][i - 1]) {
23                    ans[i] = Math.max(ans[i], ans[j] + 1);
24                }
25            }
26        }
27
28        return ans[n];
29    }
30}