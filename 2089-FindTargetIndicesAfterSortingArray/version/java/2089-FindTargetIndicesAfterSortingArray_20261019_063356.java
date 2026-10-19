// Last updated: 10/19/2026, 6:33:56 AM
1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3        Arrays.sort(nums);
4
5        int n = nums.length;
6
7        List<Integer> ans = new ArrayList<>();
8
9        for(int i = 0; i<n; i++){
10            if(nums[i] == target) ans.add(i);
11        }
12
13        return ans;
14    }
15}