// Last updated: 7/18/2026, 11:53:03 AM
1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        Arrays.sort(nums);
4
5        return nums[nums.length-k];
6    }
7}