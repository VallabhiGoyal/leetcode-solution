// Last updated: 7/24/2026, 12:01:27 PM
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int n = nums.length;
4
5        int count = 0;
6        long curr = 0;
7        Map<Long, Integer> map = new HashMap<>();
8        map.put(0L, 1);
9
10        for(int i = 0; i<n; i++){
11            curr += nums[i];
12
13            count += map.getOrDefault(curr - k, 0);
14            
15            map.put(curr, map.getOrDefault(curr, 0) + 1);
16        }
17
18        return count;
19    }
20}