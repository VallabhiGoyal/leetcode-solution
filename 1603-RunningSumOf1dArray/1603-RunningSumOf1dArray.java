// Last updated: 4/24/2026, 10:31:43 AM
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for(int i = 1; i<n; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}