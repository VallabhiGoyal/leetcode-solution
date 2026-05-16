// Last updated: 5/16/2026, 9:02:52 AM
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start<end) {
            int mid = start + (end - start)/2;
            if(nums[end] > nums[mid]) {
                end = mid;
            } else if (nums[end] < nums[mid]) {
                start = mid + 1;
            } else {
                end --;
            }
        }
        return nums[start];
    }
}