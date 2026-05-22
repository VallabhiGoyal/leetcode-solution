// Last updated: 5/22/2026, 7:57:12 AM
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int n = nums.length;
4
5        Map<Integer, Integer> map = new HashMap<>();
6        Set<Integer> set = new HashSet<>();
7
8        int size = n/3;
9
10        for(int i = 0; i<n; i++){
11            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
12            
13            int val = map.get(nums[i]);
14
15            if(val > size) set.add(nums[i]);
16        }
17
18        List<Integer> ans = new ArrayList<>(set);
19
20        return ans;
21    }
22}