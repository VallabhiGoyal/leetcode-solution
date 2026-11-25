// Last updated: 11/25/2026, 7:51:15 AM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int n = s.length();
4        int m = p.length();
5
6        StringBuilder sb = new StringBuilder();
7        for(int i = 0; i<m; i++){
8            char ch = p.charAt(i);
9            sb.append(ch);
10            if(ch == '*'){
11                int j = i;
12                while(j < m && p.charAt(j) == '*'){
13                    j++;
14                }
15                i = j-1;
16            }
17        }
18
19        m = sb.length();
20
21        boolean[][] dp = new boolean[n+1][m+1];
22        dp[0][0] = true;
23
24        for(int j = 2; j <= m; j++){
25            if(sb.charAt(j-1) == '*'){
26                dp[0][j] = dp[0][j-2];
27            }
28        }
29
30        for(int i = 1; i <= n; i++){
31            for(int j = 1; j <= m; j++){
32                char ch1 = s.charAt(i-1);
33                char ch2 = sb.charAt(j-1);
34
35                if(ch1 == ch2 || ch2 == '.'){
36                    dp[i][j] = dp[i-1][j-1];
37                }
38                else if(ch2 == '*'){
39                    dp[i][j] = dp[i][j-2];
40
41                    if(sb.charAt(j-2) == ch1 || sb.charAt(j-2) == '.'){
42                        dp[i][j] = dp[i][j] || dp[i-1][j];
43                    }
44                }
45            }
46        }
47
48        return dp[n][m];
49    }
50}