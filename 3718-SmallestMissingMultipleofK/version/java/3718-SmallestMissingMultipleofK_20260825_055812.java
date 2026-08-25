// Last updated: 8/25/2026, 5:58:12 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        int ans = 1;
8
9        for(int i = 0; i<n; i++){
10            if(k*ans == nums[i]) ans++;
11        }
12
13        return k*ans;
14    }
15}