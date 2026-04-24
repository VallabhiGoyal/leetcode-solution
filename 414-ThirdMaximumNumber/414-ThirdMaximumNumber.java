// Last updated: 4/24/2026, 10:34:05 AM
class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int max1 = nums[0];
        Integer max2 = null;
        Integer max3 = null;
        for(int i = 1; i<n; i++){
            if ((nums[i] == max1) ||
                (max2 != null && nums[i] == max2) ||
                (max3 != null && nums[i] == max3)) {
                continue;
            }
            if(max1<nums[i]){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(max2 == null || max2<nums[i]){
                max3 = max2; 
                max2 = nums[i];
            }else if(max3 == null || max3<nums[i]){
                max3 = nums[i];
            }
        }
        return max3 == null? max1: max3;
    }
}