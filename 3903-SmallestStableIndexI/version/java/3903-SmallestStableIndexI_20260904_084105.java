// Last updated: 9/4/2026, 8:41:05 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4
5        int[] suffixMin = new int[n];
6        suffixMin[n-1] = nums[n-1];
7        
8        for(int i = n-2; i>=0; i--){
9            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
10        }
11
12        int max = Integer.MIN_VALUE;
13        for(int i = 0; i<n; i++){
14            max = Math.max(max, nums[i]);
15            if(max - suffixMin[i] <= k) return i;
16        }
17
18        return -1;
19    }
20}