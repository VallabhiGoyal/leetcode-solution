// Last updated: 4/24/2026, 10:31:44 AM
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int maxLen = 0;
        int zero = 0;
        int left = 0;

        for(int right = 0; right<n; right++){
            if(nums[right] == 0) zero++;

            while(zero>1){
                if(nums[left] == 0) zero--;
                left++;
            }
            if(maxLen < right - left + 1) maxLen = right - left + 1;
        }

        return maxLen-1;
    }
}