// Last updated: 4/24/2026, 10:30:22 AM
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n<3) return n;
        
        int count_max = 2;
        int count = 2;
        for(int i = 2; i < n; i++){
            int j = i;
            if(nums[j] == nums[j-1] + nums[j-2]){
                count++;
            }else{
                count = 2;
            }
            
            if(count > count_max){
                count_max= count;
            }    
        }

        return count_max;
    }
}