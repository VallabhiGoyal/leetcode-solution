// Last updated: 7/24/2026, 12:02:50 PM
1class Solution {
2    public boolean canJump(int[] nums) {
3        int n = nums.length;
4        if(n == 1) return true;
5
6        int jump = 0;
7        for(int i = 0; i<n; i++){
8            if(i > jump) return false;
9            jump = Math.max(jump, i + nums[i]);
10            if(jump >= n-1) return true;
11        }
12
13        return false;
14    }
15}