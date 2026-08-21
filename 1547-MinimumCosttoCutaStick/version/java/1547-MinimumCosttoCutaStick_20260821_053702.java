// Last updated: 8/21/2026, 5:37:02 AM
1class Solution {
2    public int minCost(int n, int[] cuts) {
3        int m = cuts.length;
4
5        Arrays.sort(cuts);
6    
7        int[] points = new int[m+2];
8        points[0] = 0;
9        points[m+1] = n;
10
11        for(int i = 1; i<m+1; i++){
12            points[i] = cuts[i-1];
13        }
14
15        int[][] dp = new int[m+2][m+2];
16
17        for(int len = 2; len < m+2; len++){
18            for(int i = 0; i + len<m+2; i++){
19                int j = i + len;
20
21                int min = Integer.MAX_VALUE;
22
23                for(int k = i+1; k<j; k++){
24                    min = Math.min(min, dp[i][k] + dp[k][j] + points[j] - points[i]);
25                }
26
27                dp[i][j] = min;
28            }
29        }
30
31        return dp[0][m+1];
32    }
33}