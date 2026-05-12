// Last updated: 5/12/2026, 5:55:02 AM
1class Solution {
2    public int[] concatWithReverse(int[] nums) {
3        int n = nums.length;
4
5        int[] ans = new int[2*n];
6
7        for(int i = 0; i<n; i++){
8            ans[i] = nums[i];
9            ans[2*n-1-i] = nums[i];
10        }
11
12        return ans;
13    }
14}