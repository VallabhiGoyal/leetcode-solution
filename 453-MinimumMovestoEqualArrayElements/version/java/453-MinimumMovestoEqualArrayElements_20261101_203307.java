// Last updated: 11/1/2026, 8:33:07 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        int sum = 0;
5
6        for (int num : nums) {
7            min = Math.min(min, num);
8            sum += num;
9        }
10
11        return sum - nums.length * min;
12    }
13}