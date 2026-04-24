// Last updated: 4/24/2026, 10:29:30 AM
class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = -1;
        int k = -1;
        int min = n;
        while(i<n){
            if(nums[i] == 1){
                j = i;
            }else if(nums[i] == 2){
                k = i;
            }
            if(j != -1 && k != -1){
                min = Math.min(Math.abs(j-k), min);
            }
            i++;
        }

        if(min == n) return -1;
        return min;
    }
}