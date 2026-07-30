// Last updated: 7/30/2026, 12:09:43 PM
1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int n = nums.length;
4
5        return helper(nums, 0, n-1, target);
6    }
7
8    public int helper(int[] nums, int low, int high, int target){
9        if(low > high) return low;
10        int n = nums.length;
11
12        int mid = low + (high - low)/2;
13
14        if(nums[mid] == target) return mid;
15        else if(nums[mid] > target){
16            return helper(nums, low, mid -1, target);
17        }else{
18            return helper(nums, mid + 1, high, target);
19        }
20
21    }
22}