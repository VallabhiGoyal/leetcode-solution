// Last updated: 4/24/2026, 10:30:20 AM
class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int count = 0;
        int or = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2==0){
                or = or | nums[i];
                count++;
            }
        }
        if(count == 0){
            return 0;
        }
        return or;
    }
}