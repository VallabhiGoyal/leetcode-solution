// Last updated: 7/5/2026, 9:14:33 AM
1class Solution {
2    public int maxSubArray(int[] nums) {
3        int curr_sum = nums[0];
4        int max_sum = nums[0];
5        for(int i = 1; i<nums.length; i++){    
6            curr_sum = Math.max(nums[i],curr_sum + nums[i]);
7            max_sum = Math.max(max_sum, curr_sum);        
8        }
9
10        return max_sum;
11    }
12}