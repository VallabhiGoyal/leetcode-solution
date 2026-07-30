// Last updated: 7/30/2026, 12:05:29 PM
1class Solution {
2    public int search(int[] nums, int target) {
3        int n = nums.length;
4
5        return binarySearch(nums, 0, n-1, target);        
6    }
7
8    public int binarySearch(int[] nums, int low, int high, int target){
9        if(low > high) return -1;
10
11        int n = nums.length;
12
13        int mid = low + (high - low)/2;
14        if(nums[mid] == target) return mid;
15        else if(nums[mid] > target) return binarySearch(nums, low, mid - 1, target);
16        else return binarySearch(nums, mid + 1, high, target);
17    }
18}