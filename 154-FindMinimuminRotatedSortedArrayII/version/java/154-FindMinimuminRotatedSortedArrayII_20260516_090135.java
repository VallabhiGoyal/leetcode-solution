// Last updated: 5/16/2026, 9:01:35 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length;
4
5        int low = 0;
6        int high = n-1;
7
8        while(low < high){
9
10            int mid = low + (high - low)/2;
11
12            if(nums[mid] > nums[high]){
13                low = mid+1;
14            }else if(nums[mid] < nums[high]){
15                high = mid;
16            }else{
17                while(high > mid && nums[mid] == nums[high]) high--;
18            }
19        }
20
21        return nums[low];
22    }
23}