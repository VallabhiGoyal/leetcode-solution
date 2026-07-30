// Last updated: 7/30/2026, 11:56:46 AM
1class Solution {
2    public int search(int[] nums, int target) {
3        int n = nums.length;
4
5        int low = 0;
6        int high = n-1;
7
8        while(low <= high){
9            int mid = low + (high - low)/2;
10
11            if(nums[mid] == target) return mid;
12            else if(nums[mid] > target){
13                high = mid - 1;
14            }else{
15                low = mid + 1;
16            }
17        }
18
19        return -1;
20    }
21}