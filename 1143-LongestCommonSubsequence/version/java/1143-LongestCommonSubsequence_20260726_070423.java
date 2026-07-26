// Last updated: 7/26/2026, 7:04:23 AM
1class Solution {
2    public static int[][] t;
3    public int longestCommonSubsequence(String text1, String text2) {
4        int m = text1.length();
5        int n = text2.length();
6
7        if(n == 0 || m == 0) return 0;
8
9        t = new int[m+1][n+1];
10
11        for(int i = 1; i<m+1; i++){
12            for(int j = 1; j < n+1; j++){
13                if(text1.charAt(i-1) == text2.charAt(j-1)) {
14                    t[i][j] = 1 + t[i-1][j-1];
15                }else{
16                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
17                }
18            }
19        }
20
21        return t[m][n];
22    }
23}