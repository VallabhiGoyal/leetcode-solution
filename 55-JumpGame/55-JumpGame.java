// Last updated: 4/24/2026, 10:36:41 AM
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;

        int jump = 0;
        for(int i = 0; i<n; i++){
            if(i > jump) return false;
            jump = Math.max(jump, i + nums[i]);
            if(jump >= n-1) return true;
        }

        return false;
    }
}