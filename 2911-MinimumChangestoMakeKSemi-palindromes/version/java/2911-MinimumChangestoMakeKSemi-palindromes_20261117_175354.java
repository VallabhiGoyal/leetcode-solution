// Last updated: 11/17/2026, 5:53:54 PM
1class Solution {
2    public int minimumChanges(String s, int k) {
3        int n = s.length();
4
5        int[][] cost = new int[n][n];
6
7        for (int i = 0; i < n; i++) {
8            for (int j = i + 1; j < n; j++) {
9                int len = j - i + 1;
10                cost[i][j] = Integer.MAX_VALUE;
11
12                for (int d = 1; d < len; d++) {
13                    if (len % d != 0) continue;
14
15                    int changes = 0;
16
17                    for (int r = 0; r < d; r++) {
18                        int left = i + r;
19                        int right = i + r + ((len - 1) / d) * d;
20
21                        while (left < right) {
22                            if (s.charAt(left) != s.charAt(right)) {
23                                changes++;
24                            }
25
26                            left += d;
27                            right -= d;
28                        }
29                    }
30
31                    cost[i][j] = Math.min(cost[i][j], changes);
32                }
33            }
34        }
35
36        int INF = 1000000000;
37        int[][] dp = new int[n + 1][k + 1];
38
39        for (int[] row : dp) {
40            Arrays.fill(row, INF);
41        }
42
43        dp[0][0] = 0;
44
45        for (int i = 1; i <= n; i++) {
46            for (int p = 1; p <= k; p++) {
47                for (int j = 0; j <= i - 2; j++) {
48                    if (dp[j][p - 1] == INF) continue;
49
50                    dp[i][p] = Math.min(
51                        dp[i][p],
52                        dp[j][p - 1] + cost[j][i - 1]
53                    );
54                }
55            }
56        }
57
58        return dp[n][k];
59    }
60}