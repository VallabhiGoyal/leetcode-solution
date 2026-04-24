// Last updated: 4/24/2026, 10:35:04 AM
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int sum = 0;
        int length = Integer.MAX_VALUE;
        int k = 0;
        for(int j = 0; j<n; j++){
            sum += nums[j];
            while(sum >= target){
                length = Math.min(length, j-k+1);
                sum -= nums[k];
                k++;
            }
        }
        if(length == Integer.MAX_VALUE) return 0;
        return length;
    }
}