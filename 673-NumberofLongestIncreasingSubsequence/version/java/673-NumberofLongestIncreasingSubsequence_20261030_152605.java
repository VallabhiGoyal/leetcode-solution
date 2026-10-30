// Last updated: 10/30/2026, 3:26:05 PM
1class Solution {
2    public int findNumberOfLIS(int[] nums) {
3    
4        int n = nums.length;
5
6        int[] dp = new int[n];
7        int[] count = new int[n];
8
9        Arrays.fill(dp, 1);
10        Arrays.fill(count, 1);
11
12        for(int i = 1; i<n; i++){
13            for(int j = 0; j<i; j++){
14                if(nums[i] > nums[j]){
15                    if(dp[i] < 1 + dp[j]){
16                        dp[i] = dp[j] + 1;
17                        count[i] = count[j];
18                    }
19                    else if(dp[i] == 1 + dp[j]) count[i] += count[j];
20                }
21            }
22        }
23
24        int max = 0;
25        int j = 0;
26        for(int i = 0; i<n; i++){
27            if(max < dp[i]){
28                max = dp[i];
29                j = i;
30            }
31        }
32
33        int ans = 0;
34        for(int i = 0; i<n; i++){
35            if(dp[i] == max) ans += count[i];
36        }
37
38        return ans;
39    }
40}