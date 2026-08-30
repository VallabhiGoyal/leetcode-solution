// Last updated: 8/30/2026, 7:22:22 AM
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length;
4
5        if(n == 1 || n == 2) return n;
6
7        int minIdx = 0;
8        int maxIdx = 0;
9
10        for(int i = 1; i<n; i++){
11            if(nums[minIdx] > nums[i]) minIdx = i;
12            if(nums[maxIdx] < nums[i]) maxIdx = i;
13        }
14
15        int left = Math.min(minIdx, maxIdx);
16        int right = Math.max(minIdx, maxIdx);
17
18        return Math.min((left + 1) + (n - right),Math.min(right + 1, n - left));
19    }
20}