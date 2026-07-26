// Last updated: 7/26/2026, 7:05:45 AM
1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if(n == 1) return nums[0];
5
6        int[] t = new int[n];
7
8        t[0] = nums[0];
9        t[1] = Math.max(nums[0], nums[1]);
10        for(int i = 2; i<n; i++){
11            t[i] = Math.max(nums[i] + t[i-2], t[i-1]);
12        }
13
14        return  t[n-1];
15    }
16}