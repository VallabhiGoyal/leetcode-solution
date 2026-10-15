// Last updated: 10/15/2026, 5:42:03 AM
1class Solution {
2    public int sumCounts(List<Integer> nums) {
3        int n = nums.size();
4        int ans = 0;
5
6        for(int i = 0; i < n; i++){
7            Map<Integer, Integer> map = new HashMap<>();
8            for(int j = i; j < n; j++){
9                map.merge(nums.get(j), 1, Integer::sum);
10                ans += Math.pow(map.size(), 2);
11            }
12        }
13
14        return ans;
15    }
16}