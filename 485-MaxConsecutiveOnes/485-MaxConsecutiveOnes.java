// Last updated: 4/24/2026, 10:33:50 AM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int current = 0;

        for(int num : nums){
            if(num==1){
                current++;
                max_count = Math.max(max_count, current);
            }else{
                current = 0;
            }
        }

        return max_count;
    }
}