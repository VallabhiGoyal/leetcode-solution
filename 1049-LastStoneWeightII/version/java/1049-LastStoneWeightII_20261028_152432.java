// Last updated: 10/28/2026, 3:24:32 PM
1class Solution {
2    public int lastStoneWeightII(int[] stones) {
3        int n = stones.length;
4        
5        int sum = 0;
6        for(int num : stones){
7            sum += num;
8        }
9        
10        int target = (sum + 1)/2;
11        int[][] dp = new int[n+1][target+1];
12        
13        for(int i = 1; i<=n; i++){
14            for(int j = 1; j<=target; j++){
15                dp[i][j] = dp[i-1][j];
16                if(stones[i-1] <= j){
17                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - stones[i-1]] + stones[i-1]);
18                }
19            }
20        }
21        
22        int req = sum - dp[n][target];
23        
24        return Math.abs(req - dp[n][target]);
25    }
26}