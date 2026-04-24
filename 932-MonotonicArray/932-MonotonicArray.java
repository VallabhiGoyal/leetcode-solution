// Last updated: 4/24/2026, 10:32:44 AM
class Solution {
    public boolean isMonotonic(int[] nums) {

        if(nums[0]<=nums[nums.length-1]){
            for(int i = 0; i<nums.length-1; i++){
                if(nums[i]>nums[i+1]){
                    return false;
                }
            }
        }
        if(nums[0]>=nums[nums.length-1]){
            for(int i = 0; i<nums.length-1; i++){
                if(nums[i]<nums[i+1]){
                    return false;
                }
            }
        }

        return true;
        
    }
}