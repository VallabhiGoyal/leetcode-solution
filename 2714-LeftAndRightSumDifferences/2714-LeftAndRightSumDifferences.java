// Last updated: 7/3/2026, 11:37:01 AM
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int rightSum = 0;
        for(int i = 0; i<n; i++){
            rightSum += nums[i];
        }

        int leftSum = 0;
        for(int i = 0; i<n; i++){
            int val = nums[i];
            rightSum -= val;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum += val;
        }

        return nums;
    }
}