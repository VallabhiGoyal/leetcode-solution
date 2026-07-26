// Last updated: 7/26/2026, 7:05:14 AM
1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n = nums.length;
4
5        int[] dp = new int[n];
6
7        for(int i = 0; i<n; i++){
8            dp[i] = 1;
9        }
10
11        for(int i = 1; i<n; i++){
12            for(int j = 0; j<i; j++){
13                if(nums[i] > nums[j]){
14                    dp[i] = Math.max(dp[i], dp[j] + 1);
15                }
16            }
17        }
18
19        int max = 1;
20
21        for(int i = 0; i<n; i++){
22            max = Math.max(dp[i], max);
23        }
24
25        return max;
26    }
27}