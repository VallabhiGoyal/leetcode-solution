// Last updated: 7/27/2026, 5:44:25 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length;
4
5        int low = 0;
6        int high = n-1;
7
8        while(low < high){
9            int mid = low + (high - low)/2;
10
11            if(nums[mid] > nums[high]){
12                low = mid + 1;
13            }else{
14                high = mid;
15            }
16        }
17
18        return nums[low];
19    }
20}