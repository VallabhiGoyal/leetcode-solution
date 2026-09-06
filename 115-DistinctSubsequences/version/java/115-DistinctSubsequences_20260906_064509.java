// Last updated: 9/6/2026, 6:45:09 AM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length();
4        int n = t.length();
5
6        int[][] dp = new int[m+1][n+1];
7
8        for(int i = 0; i<m+1; i++){
9            dp[i][0] = 1;
10        }
11        
12        for(int i = 1; i<m+1; i++){
13            for(int j = 1; j<n+1; j++){
14                if(s.charAt(i-1) == t.charAt(j-1)){
15                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
16                }else{
17                    dp[i][j] = dp[i-1][j];
18                }
19            }
20        }
21
22        return dp[m][n];
23    }
24}