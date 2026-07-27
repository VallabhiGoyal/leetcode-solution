// Last updated: 7/27/2026, 5:43:25 AM
1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int j;
4        for(j = 0;j<nums.length; j++){
5            if(nums[j] >= target) return j;
6        }
7
8        return nums.length;
9    }
10}