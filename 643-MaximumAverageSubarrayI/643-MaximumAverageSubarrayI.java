// Last updated: 4/24/2026, 10:33:25 AM
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += nums[i];
        }
        maxSum = sum;
        int j = 0;
        for(int i = 1; i<=n-k; i++){
            sum = sum - nums[j++] + nums[i+k-1];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum/(double)k;
    }
}