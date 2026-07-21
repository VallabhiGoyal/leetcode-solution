// Last updated: 7/21/2026, 6:45:15 AM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        Map<Integer, Integer> map = new HashMap<>();
4
5        for(int i = 0; i<nums.length; i++){
6            int temp = target - nums[i];
7            if(map.containsKey(temp)){
8                return new int[]{map.get(temp), i}; 
9            }
10            map.put(nums[i], i);
11        }
12
13        return new int[] {-1,-1};
14    }
15}