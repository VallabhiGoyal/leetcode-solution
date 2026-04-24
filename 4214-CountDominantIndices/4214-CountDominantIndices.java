// Last updated: 4/24/2026, 10:29:43 AM
class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = n-2; i>=0; i--){
            nums[i] += nums[i+1];
        }

        for(int i = 0; i<n-1; i++){
            if(nums[i]-nums[i+1] > nums[i+1]/(n-i-1)){
                count++;
            }
        }

        return count;
        
    }
}