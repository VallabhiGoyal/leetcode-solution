// Last updated: 8/17/2026, 9:38:34 AM
1class Solution {
2    public int stoneGameV(int[] stoneValue) {
3        int n = stoneValue.length;
4
5        if(n == 1) return 0;
6
7        int[] prefix = new int[n+1];
8
9        for(int i = 0; i<n; i++){
10            prefix[i+1] = prefix[i] + stoneValue[i];
11        }
12
13        int[][] dp = new int[n][n];
14
15        for(int len = 2; len<=n; len++){
16            for(int i = 0; i + len - 1<n; i++){
17                int j = i + len - 1;
18                int best = 0;
19                int curr;
20                for(int k = i; k<j; k++){
21                    int leftSum = prefix[k+1] - prefix[i];
22                    int rightSum = prefix[j+1] - prefix[k+1];
23                    
24                    if(leftSum < rightSum){
25                        curr = leftSum + dp[i][k];
26                    }else if(leftSum > rightSum){
27                        curr = rightSum + dp[k+1][j];
28                    }else{
29                        curr = leftSum + Math.max(dp[i][k], dp[k+1][j]);
30                    }
31                    best = Math.max(best, curr);
32                }
33
34                dp[i][j] = best;
35            }
36        }
37
38        return dp[0][n-1];
39    }
40}