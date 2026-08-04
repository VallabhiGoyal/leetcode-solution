// Last updated: 8/4/2026, 8:33:14 AM
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3        int n = nums.length;
4
5        int max = nums[0];
6        int min = nums[0];
7
8        Set<Integer> set = new HashSet<>();
9        for(int i = 0; i<n; i++){
10            set.add(nums[i]);
11            max = Math.max(max, nums[i]);
12            min = Math.min(min, nums[i]);
13        }
14
15        List<Integer> ans = new ArrayList<>();
16        for(int i = min+1; i<max; i++){
17            if(!set.contains(i)){
18                ans.add(i);
19            }
20        }
21
22        return ans;
23    }
24}