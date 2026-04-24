// Last updated: 4/24/2026, 10:34:26 AM
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<3) return false;

        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for(int i = 1; i<n; i++){
            if(first>=nums[i]) first = nums[i];
            else if(second>=nums[i]) second = nums[i];
            else return true;
        }
        return false;
    }
}