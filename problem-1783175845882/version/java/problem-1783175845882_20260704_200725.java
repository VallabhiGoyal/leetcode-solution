// Last updated: 7/4/2026, 8:07:25 PM
1class Solution {
2    public boolean isMiddleElementUnique(int[] nums) {
3        int n = nums.length;
4        int mid = n/2;
5
6        for(int i = 0; i<n; i++){
7            if(i == mid) continue;
8            if(nums[i] == nums[mid]) return false;
9        }
10
11        return true;
12    }
13}