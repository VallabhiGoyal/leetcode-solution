// Last updated: 11/14/2026, 8:18:45 AM
1class Solution {
2    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
3        int n = nums.size();
4
5        int ans = Integer.MAX_VALUE;
6
7        for(int i = 0; i<n; i++){
8            int sum = 0;
9            for(int j = i; j < n; j++){
10                sum += nums.get(j);
11
12                if(j- i + 1 >= l && j - i + 1 <= r && sum > 0){
13                    ans = Math.min(ans, sum);
14                }
15                if(j - i + 1 > r) break;
16            }
17        }
18
19        return ans == Integer.MAX_VALUE ? -1 : ans;
20    }
21}