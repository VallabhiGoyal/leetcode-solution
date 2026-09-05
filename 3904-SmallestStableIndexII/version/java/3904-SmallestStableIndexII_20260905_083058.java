// Last updated: 9/5/2026, 8:30:58 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4
5        int[] suffixMin = new int[n];
6        suffixMin[n-1] = nums[n-1];
7        for(int i = n-2; i>=0; i--){
8            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
9        }
10
11        int max = Integer.MIN_VALUE;
12        for(int i = 0; i<n; i++){
13            max = Math.max(max, nums[i]);
14            if(max - suffixMin[i] <= k) return i;
15        }
16
17        return -1;
18    }
19}