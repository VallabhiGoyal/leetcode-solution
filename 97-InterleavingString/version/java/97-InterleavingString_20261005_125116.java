// Last updated: 10/5/2026, 12:51:16 PM
1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        int p = s1.length();
4        int q = s2.length();
5        int r = s3.length();
6
7        if(p + q != r) return false;
8
9        boolean[][] dp = new boolean[p+1][q+1];
10        dp[0][0] = true;
11
12        for(int i = 0; i<=p; i++){
13            for(int j = 0; j<=q; j++){
14                if(i > 0 && s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]){
15                    dp[i][j] = true;
16                }
17
18                if(j > 0 && s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]){
19                    dp[i][j] = true;
20                }
21            }
22        }
23
24        return dp[p][q];
25    }
26}