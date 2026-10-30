// Last updated: 10/30/2026, 2:46:47 PM
1class Solution {
2    public int longestArithSeqLength(int[] nums) {
3        int n = nums.length;
4
5        Map<Integer, Integer>[] dp = new HashMap[n];
6        dp[0] = new HashMap<>();
7
8        int max = 2;
9        for(int i = 1; i<n; i++){
10            dp[i] = new HashMap<>();
11
12            for(int j = 0; j<i; j++){
13                int diff = nums[i] - nums[j];
14
15                int take = dp[j].getOrDefault(diff, 1) + 1;
16                int skip = dp[i].getOrDefault(diff, 1);
17                int ans = Math.max(take, skip);
18                dp[i].put(diff, ans);
19
20                max = Math.max(max, ans);
21            }
22        }
23
24        return max;
25    }
26}