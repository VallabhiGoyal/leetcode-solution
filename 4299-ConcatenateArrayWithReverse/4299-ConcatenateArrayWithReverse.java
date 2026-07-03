// Last updated: 7/3/2026, 11:34:49 AM
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;

        int[] ans = new int[2*n];

        for(int i = 0; i<n; i++){
            ans[i] = nums[i];
            ans[2*n-1-i] = nums[i];
        }

        return ans;
    }
}