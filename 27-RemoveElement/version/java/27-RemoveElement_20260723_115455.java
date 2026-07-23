// Last updated: 7/23/2026, 11:54:55 AM
1class Solution {
2    public int removeElement(int[] nums, int val) {
3        if(nums.length==0) return 0;
4        int count =0;
5        for(int i = 0; i<nums.length; i++){
6            if(nums[i]!=val){
7                nums[count] = nums[i];
8                count++;
9            }
10        }
11        return count;        
12    }
13}