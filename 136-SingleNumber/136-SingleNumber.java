// Last updated: 4/24/2026, 10:35:34 AM
class Solution {
    public int singleNumber(int[] nums) {
        int ans  = 0; 
        for(int i = 0; i<nums.length; i++){
            ans ^= nums[i];
        }

        return ans;
    }
}