// Last updated: 8/1/2026, 1:43:54 PM
1class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4
5        if(n % 2 == 0) return true;
6
7        int[][] dp = new int[n][n];
8
9        for(int i = 0; i<n; i++){
10            dp[i][i] = nums[i];
11        }
12
13        for(int len = 2; len <= n; len++){
14            for(int i = 0; i + len - 1<n; i++){
15
16                int j = i + len - 1;
17                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
18            }
19        }
20
21        return dp[0][n-1] >= 0 ? true : false;
22    }
23}