// Last updated: 7/24/2026, 11:59:10 AM
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int n = nums.length;
4
5        int count = 0;
6        long curr = 0;
7        Map<Long, Integer> map = new HashMap<>();
8
9        for(int i = 0; i<n; i++){
10            curr += nums[i];
11            if(!map.isEmpty() && map.containsKey(curr - k)) count+=map.get(curr - k);
12            if(curr - k == 0) count++;
13            map.put(curr, map.getOrDefault(curr, 0) + 1);
14        }
15
16        return count;
17    }
18}