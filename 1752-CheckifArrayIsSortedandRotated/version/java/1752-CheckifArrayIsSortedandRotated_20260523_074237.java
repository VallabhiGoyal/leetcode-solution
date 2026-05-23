// Last updated: 5/23/2026, 7:42:37 AM
1class Solution {
2    public boolean check(int[] nums) {
3        int n = nums.length;
4
5        int count = 0;
6        for(int i = 0; i<n-1; i++){
7            if(nums[i]>nums[i+1]) count++;
8        }
9        if(count == 1 && nums[0]<nums[n-1]) return false;
10        if(count>1) return false;
11        return true;
12
13    }
14}