// Last updated: 4/24/2026, 10:31:23 AM
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(nums[i] == target){
                int temp = Math.abs(i - start);
                min = Math.min(min, temp);
            }
        }

        return min;
    }
}