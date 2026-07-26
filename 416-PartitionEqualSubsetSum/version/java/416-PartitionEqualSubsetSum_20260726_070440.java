// Last updated: 7/26/2026, 7:04:40 AM
1class Solution {
2    public boolean canPartition(int[] nums) {
3        int n = nums.length;
4        int sum = 0;
5        for(int i = 0; i<n; i++){
6            sum += nums[i];
7        }
8        if(sum % 2 != 0) return false;
9
10        return helper(nums, sum/2);
11    }
12
13    private boolean helper(int[] nums, int sum){
14        boolean[] t = new boolean[sum + 1];
15
16        t[0] = true;
17
18        for(int num : nums){
19            for(int j = sum; j >= num; j--){
20                t[j] = t[j] || t[j - num];
21            }
22        }
23
24        return t[sum];
25    }
26}