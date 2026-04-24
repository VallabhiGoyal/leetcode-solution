// Last updated: 4/24/2026, 10:30:30 AM
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i<n; i++){
            int steps = nums[i];
            int nextStep = ((i+steps)%n + n)%n;
            result[i] = nums[nextStep];
        }

        return result;
    }
}