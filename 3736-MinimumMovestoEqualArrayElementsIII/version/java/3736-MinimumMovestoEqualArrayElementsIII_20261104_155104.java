// Last updated: 11/4/2026, 3:51:04 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int n = nums.length;
4        
5        int max = Integer.MIN_VALUE;
6        
7        for(int num : nums){
8            max = Math.max(max, num);
9        }
10        
11        int moves = 0;
12        
13        for(int num : nums){
14            moves += (max - num);
15        }
16 
17        return moves;
18    }
19}