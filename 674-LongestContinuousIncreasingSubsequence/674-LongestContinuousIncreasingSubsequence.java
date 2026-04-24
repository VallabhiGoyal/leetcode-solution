// Last updated: 4/24/2026, 10:33:17 AM
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int ans = 1;
        int j = 0;
        for(int i = 1; i<n; i++){
            if(nums[i] <= nums[i-1]){
                ans = Math.max(i-j, ans);
                j = i;
            }
        }

        ans = Math.max(ans, n - j);
        return ans;
    }
}