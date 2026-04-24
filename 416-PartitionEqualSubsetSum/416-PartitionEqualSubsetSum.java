// Last updated: 4/24/2026, 10:34:04 AM
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;

        return helper(nums, sum/2);
    }

    private boolean helper(int[] nums, int sum){
        boolean[] t = new boolean[sum + 1];

        t[0] = true;

        for(int num : nums){
            for(int j = sum; j >= num; j--){
                t[j] = t[j] || t[j - num];
            }
        }

        return t[sum];
    }
}