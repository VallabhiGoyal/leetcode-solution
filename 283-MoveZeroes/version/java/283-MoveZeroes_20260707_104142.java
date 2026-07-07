// Last updated: 7/7/2026, 10:41:42 AM
1class Solution {
2    public void moveZeroes(int[] nums) {
3        int k = 0;
4
5        for(int i = 0; i < nums.length; i++){
6            if(nums[i] != 0){
7                int temp = nums[i];
8                nums[i] = nums[k];
9                nums[k] = temp;
10                k++;
11            }
12        }
13    }
14}
15