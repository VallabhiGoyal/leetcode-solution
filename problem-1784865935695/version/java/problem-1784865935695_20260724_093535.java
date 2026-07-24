// Last updated: 7/24/2026, 9:35:35 AM
1class Solution {
2    public int longestConsecutive(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        if(n <= 1) return n;
6
7        int len = 1;
8        int count = 1;
9
10        for(int i = 1; i<n; i++){
11            if(nums[i] == nums[i-1] + 1) count++;
12            else if(nums[i] != nums[i-1]) count = 1;
13            else continue;;
14
15            len = Math.max(len, count);
16        }
17
18        return len;
19    }
20}