// Last updated: 8/3/2026, 9:50:56 AM
1class Solution {
2    public String stoneGameIII(int[] stoneValue) {
3        int n = stoneValue.length;
4
5        int[] dp = new int[3];
6
7        for(int i = n-1; i>=0; i--){
8            int takeOne = stoneValue[i] - dp[(i + 1) % 3];
9
10            int takeTwo = Integer.MIN_VALUE;
11            if (i + 1 < n){
12                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 3];
13            }
14            
15            int takeThree = Integer.MIN_VALUE;
16            if (i + 2 < n){
17                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 3];
18            }
19
20            dp[i % 3] = Math.max(Math.max(takeOne, takeTwo), takeThree);
21        }
22
23        if(dp[0] > 0) return "Alice";
24        else if(dp[0] == 0) return "Tie";
25        return "Bob"; 
26    }
27}