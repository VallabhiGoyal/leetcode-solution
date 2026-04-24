// Last updated: 4/24/2026, 10:34:40 AM
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = n*(n+1)/2;

        for(int i = 0; i<n; i++){
            sum -= nums[i];
        }

        return sum;
    }
}