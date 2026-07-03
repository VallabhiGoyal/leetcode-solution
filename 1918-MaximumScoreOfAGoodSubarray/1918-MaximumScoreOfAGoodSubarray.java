// Last updated: 7/3/2026, 11:37:36 AM
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int minHeight = nums[k];
        int maxScore = minHeight;

        while(left > 0 || right < n-1){

            if(left == 0){
                right++;
            }else if(right == n-1){
                left--;
            }else if(nums[left-1] >= nums[right+1]){
                left--;
            }else{
                right++;
            }
            
            minHeight = Math.min(minHeight, Math.min(nums[left], nums[right]));

            maxScore  = Math.max(maxScore, minHeight * (right - left + 1));
        }

        return maxScore;
    }

}