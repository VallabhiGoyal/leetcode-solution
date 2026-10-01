// Last updated: 10/1/2026, 10:28:48 AM
1class Solution {
2    public List<Integer> largestDivisibleSubset(int[] nums) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        int[] dp = new int[n];
8        Arrays.fill(dp, 1);
9
10        int max = 1;
11        int maxIdx = 0;
12        
13        for(int i = 1; i < n; i++){
14            for(int j = 0; j < i; j++){
15                if(nums[i] % nums[j] == 0){
16                    dp[i] = Math.max(dp[i], dp[j] + 1);
17                }
18            }
19
20            if(max < dp[i]){
21                max = dp[i];
22                maxIdx = i;
23            }
24        }
25
26        List<Integer> ans = new ArrayList<>();
27        ans.add(nums[maxIdx]);
28        
29        int curr = maxIdx;
30
31        for(int i = maxIdx-1; i >= 0; i--){
32            if(dp[i] == dp[curr]-1 && nums[curr] % nums[i] == 0){
33                ans.add(nums[i]);
34                curr = i;
35            }
36        }
37
38        return ans;
39    }
40}