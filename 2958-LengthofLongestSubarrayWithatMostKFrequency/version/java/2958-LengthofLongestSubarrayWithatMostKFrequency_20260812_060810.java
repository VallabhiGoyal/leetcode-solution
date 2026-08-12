// Last updated: 8/12/2026, 6:08:10 AM
1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3        int n = nums.length;
4
5        Map<Integer, Integer> map = new HashMap<>();
6
7        int maxCount = 0;
8        int j = 0;
9        for(int i = 0; i<n; i++){
10            map.merge(nums[i], 1, Integer::sum);
11
12            while(j < i && map.get(nums[i]) > k){
13                map.merge(nums[j], -1, Integer::sum);
14                j++;
15            }
16            maxCount = Math.max(maxCount, i - j + 1);
17        }
18
19        return maxCount;
20    }
21}