// Last updated: 11/1/2026, 8:33:54 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        if (nums == null || nums.length <= 1) {
4            return 0;
5        }
6
7        int min = nums[0];
8        for (int i = 1; i < nums.length; i++) {
9            if (nums[i] < min) {
10                min = nums[i];
11            }
12        }
13
14        int moves = 0;
15        for (int num : nums) {
16            moves += num - min;
17        }
18
19        return moves;
20    }
21}