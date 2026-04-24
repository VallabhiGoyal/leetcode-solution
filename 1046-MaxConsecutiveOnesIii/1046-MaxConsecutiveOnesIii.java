// Last updated: 4/24/2026, 10:32:25 AM
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int maxCount = 0;
        int left = 0;
        int zero = 0;

        for(int right = 0; right<n; right++){
            if(nums[right] == 0) zero++;

            while(zero > k){
                if(nums[left] == 0) zero--;
                left++;
            }

            if(maxCount < right - left +1) maxCount = right - left + 1;
        }
        

        return maxCount;
    }
}