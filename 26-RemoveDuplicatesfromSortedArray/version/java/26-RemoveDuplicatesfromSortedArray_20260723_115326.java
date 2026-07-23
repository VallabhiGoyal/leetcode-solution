// Last updated: 7/23/2026, 11:53:26 AM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 0) return 0;
4
5        int i = 0; 
6
7        for (int j = 1; j < nums.length; j++) {
8            if (nums[j] != nums[i]) {
9                i++;
10                nums[i] = nums[j];
11            }
12        }
13
14        return i + 1; 
15    }
16}
17