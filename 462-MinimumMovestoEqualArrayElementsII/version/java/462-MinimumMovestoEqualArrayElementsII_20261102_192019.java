// Last updated: 11/2/2026, 7:20:19 PM
1class Solution {
2    public int minMoves2(int[] nums) {
3        int n = nums.length;
4        Arrays.sort(nums);
5
6        int median = nums[n/2];
7        int moves = 0;
8        for(int num : nums){
9            moves += Math.abs(median - num);
10        }
11
12        return moves;
13    }
14}